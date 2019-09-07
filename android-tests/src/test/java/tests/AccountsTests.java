package tests;

import common.Driver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.AccountCreationPage;
import pages.AccountsPage;
import pages.SetupPage;

import static org.testng.Assert.assertTrue;

public class AccountsTests {

    SetupPage setupPage;
    AccountsPage accountsPage;
    AccountCreationPage accountCreationPage;

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
        // add assertions for the review screen here
        setupPage.clickDoneButton();
    }

    @Test(priority = 2)
    public void verifyAccountCreation() {
        String accountName = "Test Account";
        accountsPage.clickDismissButton();
        accountsPage.clickAddAccountButton();
        accountCreationPage.enterAccountName(accountName);
        accountCreationPage.setCurrency(SetupPage.Currency.USD.toString());
        accountCreationPage.setAccountType(AccountCreationPage.AccountType.CASH);
        accountCreationPage.enterAccountDescription("This is the account description.");
        accountCreationPage.clickSaveButton();
        assertTrue(accountsPage.isAccountPresent(accountName));
    }
}
