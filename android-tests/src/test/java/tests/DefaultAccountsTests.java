package tests;

import common.Driver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DefaultAccountsTests {

    SetupPage setupPage;
    AccountsPage accountsPage;
    AccountCreationPage accountCreationPage;
    SubAccountPage subAccountPage;
    TransactionsPage transactionsPage;
    TransactionCreationPage transactionCreationPage;
    String transactionAmount = "500";

    @BeforeSuite
    public void setupPageObjects() {
        setupPage = new SetupPage(Driver.androidDriver);
        accountsPage = new AccountsPage(Driver.androidDriver);
        accountCreationPage = new AccountCreationPage(Driver.androidDriver);
        subAccountPage = new SubAccountPage(Driver.androidDriver);
        transactionsPage = new TransactionsPage(Driver.androidDriver);
        transactionCreationPage = new TransactionCreationPage(Driver.androidDriver);
    }

    @Test(priority = 1)
    public void verifyCompleteSetup() {
        setupPage.clickNext();
        setupPage.selectCurrency(SetupPage.Currency.USD.toString());
        setupPage.clickNext();
        setupPage.selectAccountOption(SetupPage.AccountType.DEFAULT);
        setupPage.clickNext();
        setupPage.selectFeedbackOption(SetupPage.FeedbackOptions.DISABLE);
        setupPage.clickNext();
        assertTrue(setupPage.isTextSeen(SetupPage.Currency.USD.toString()));
        assertTrue(setupPage.isTextSeen(SetupPage.AccountType.DEFAULT));
        assertTrue(setupPage.isTextSeen(SetupPage.FeedbackOptions.DISABLE));
        setupPage.clickDoneButton();
        accountsPage.clickDismissButton();
    }

    @Test(priority = 2)
    public void verifyCreateTransactionInDefaultAccount() {
        String accountName = AccountsPage.DefaultAccounts.ASSETS;
        accountsPage.clickAccountButton(accountName);
        subAccountPage.clickSubAccountButton();
        transactionsPage.clickCreateTransactionButton();
        transactionCreationPage.addTransactionDescription("Test description");
        transactionCreationPage.addTransactionAmount(transactionAmount);
        transactionCreationPage.clickSaveTransactionButton();
        String updatedTransactionAmount = transactionsPage.getAccountBalance();
        assertEquals(updatedTransactionAmount, "$" + transactionAmount + ".00");
    }

    @Test(priority = 3)
    public void verifyDeleteTransaction() {
        transactionsPage.deleteTransaction();
    }

}
