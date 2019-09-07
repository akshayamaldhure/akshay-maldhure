package tests;

import common.Driver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.AccountCreationPage;
import pages.AccountsPage;
import pages.SetupPage;

import static org.testng.Assert.assertTrue;

public class CustomAccountsTests {

    SetupPage setupPage;
    AccountsPage accountsPage;
    AccountCreationPage accountCreationPage;
    String accountName = "Test Account";
    String updatedAccountName = "Test Account 2";

    @BeforeSuite
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
        //TODO: add assertions for the review screen here
        setupPage.clickDoneButton();
    }

    @Test(priority = 2)
    public void verifyCreateAccount() {
        accountsPage.clickDismissButton();
        assertTrue(accountsPage.noAccountsExist());
        accountsPage.clickAddAccountButton();
        accountCreationPage.enterAccountName(accountName);
        accountCreationPage.setCurrency(SetupPage.Currency.USD.toString());
        accountCreationPage.setAccountType(AccountCreationPage.AccountType.CASH);
        accountCreationPage.enterAccountDescription("This is the account description.");
        accountCreationPage.clickSaveButton();
        assertTrue(accountsPage.isAccountPresent(accountName));
    }

    @Test(priority = 3)
    public void verifyEditAccount() {
        accountsPage.editAccount();
        accountCreationPage.enterAccountName(updatedAccountName);
        accountCreationPage.clickSaveButton();
        assertTrue(accountsPage.isAccountPresent(updatedAccountName));
    }

    @Test(priority = 4)
    public void verifyMarkAccountAsFavorite() {
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
}