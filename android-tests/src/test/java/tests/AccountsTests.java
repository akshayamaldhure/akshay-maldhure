package tests;

import common.Driver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.AccountsPage;
import pages.SetupPage;

public class AccountsTests {

    SetupPage setupPage;
    AccountsPage accountsPage;

    @BeforeSuite
    public void verifyCompleteGnucashSetup() {
        setupPage = new SetupPage(Driver.androidDriver);
        accountsPage = new AccountsPage(Driver.androidDriver);
        setupPage.clickNext();
        setupPage.selectCurrency(SetupPage.Currency.USD.toString());
        setupPage.clickNext();
        setupPage.selectAccountOption(SetupPage.AccountType.DEFAULT);
        setupPage.clickNext();
        setupPage.selectFeedbackOption(SetupPage.FeedbackOptions.DISABLE);
        setupPage.clickNext();
        // add assertions for the review screen here
        setupPage.clickDoneButton();
        accountsPage.clickDismissButton();
    }

    @Test
    public void verifySomething() {
        
    }
}
