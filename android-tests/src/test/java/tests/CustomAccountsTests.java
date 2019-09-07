package tests;

import common.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AccountCreationPage;
import pages.AccountsPage;
import pages.SetupPage;

import static org.testng.Assert.assertTrue;

public class CustomAccountsTests {

    SetupPage setupPage;
    AccountsPage accountsPage;
    AccountCreationPage accountCreationPage;

    @BeforeClass
    public void setupPageObjects() {
        setupPage = new SetupPage(Driver.androidDriver);
        accountsPage = new AccountsPage(Driver.androidDriver);
        accountCreationPage = new AccountCreationPage(Driver.androidDriver);
    }

    @Test(priority = 1)
    public void verifyCompleteSetup() {
        setupPage.clickNext();
        setupPage.selectCurrency(SetupPage.Currency.USD.toString());
        setupPage.clickNext();
        setupPage.selectAccountOption(SetupPage.AccountType.LET_ME_HANDLE);
        setupPage.clickNext();
        setupPage.selectFeedbackOption(SetupPage.FeedbackOptions.DISABLE);
        setupPage.clickNext();
        assertTrue(setupPage.isTextSeen(SetupPage.Currency.USD.toString()));
        assertTrue(setupPage.isTextSeen(SetupPage.AccountType.LET_ME_HANDLE));
        assertTrue(setupPage.isTextSeen(SetupPage.FeedbackOptions.DISABLE));
        setupPage.clickDoneButton();
        accountsPage.clickDismissButton();
    }

    @Test(priority = 2)
    @Parameters({"accountName", "accountDescription"})
    public void verifyCreateAccount(String accountName, String accountDescription) {
        assertTrue(accountsPage.noAccountsExist());
        accountsPage.clickAddAccountButton();
        accountCreationPage.enterAccountName(accountName);
        accountCreationPage.setCurrency(SetupPage.Currency.USD.toString());
        accountCreationPage.setAccountType(AccountCreationPage.AccountType.CASH);
        accountCreationPage.enterAccountDescription(accountDescription);
        accountCreationPage.clickSaveButton();
        assertTrue(accountsPage.isAccountPresent(accountName));
    }

    @Test(priority = 3)
    @Parameters({"updatedAccountName"})
    public void verifyEditAccount(String updatedAccountName) {
        accountsPage.editAccount();
        accountCreationPage.enterAccountName(updatedAccountName);
        accountCreationPage.clickSaveButton();
        assertTrue(accountsPage.isAccountPresent(updatedAccountName));
    }

    @Test(priority = 4)
    @Parameters({"accountName"})
    public void verifyMarkAccountAsFavorite(String accountName) {
        accountsPage.markAccountAsFavorite();
        accountsPage.clickFavorites();
        assertTrue(accountsPage.isAccountPresent(accountName)); // the test fails as the account does not get listed in the Favorites tab within the globalTimeout duration
    }

    @Test(priority = 5)
    public void verifyDeleteAccount() {
        accountsPage.clickAll();
        accountsPage.deleteAccount();
        assertTrue(accountsPage.noAccountsExist());
    }

    @AfterClass
    public void tearDown() {
        Driver.androidDriver.resetApp();
    }
}
