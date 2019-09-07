package tests;

import common.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.AssertJUnit.assertEquals;

public class DefaultAccountsTests {

    SetupPage setupPage;
    AccountsPage accountsPage;
    AccountCreationPage accountCreationPage;
    SubAccountPage subAccountPage;
    TransactionsPage transactionsPage;
    TransactionCreationPage transactionCreationPage;

    @BeforeClass
    public void setupPageObjects() {
        setupPage = new SetupPage(Driver.androidDriver);
        accountsPage = new AccountsPage(Driver.androidDriver);
        accountCreationPage = new AccountCreationPage(Driver.androidDriver);
        subAccountPage = new SubAccountPage(Driver.androidDriver);
        transactionsPage = new TransactionsPage(Driver.androidDriver);
        transactionCreationPage = new TransactionCreationPage(Driver.androidDriver);
    }

    @Test(priority = 6)
    public void verifyCompleteSetup() {
        Common.completeSetup(setupPage, accountsPage, SetupPage.Currency.USD.toString(),
                SetupPage.AccountType.DEFAULT, SetupPage.FeedbackOptions.DISABLE);
    }

    @Test(priority = 7)
    @Parameters({"transactionAmount", "transactionDescription", "expectedTransactionAmount"})
    public void verifyCreateTransactionInDefaultAccount(String transactionAmount, String transactionDescription, String expectedTransactionAmount) {
        String accountName = AccountsPage.DefaultAccounts.ASSETS;
        accountsPage.clickAccountButton(accountName);
        subAccountPage.clickSubAccountButton();
        transactionsPage.clickCreateTransactionButton();
        transactionCreationPage.addTransactionDescription(transactionDescription);
        transactionCreationPage.addTransactionAmount(transactionAmount);
        transactionCreationPage.clickSaveTransactionButton();
        String updatedTransactionAmount = transactionsPage.getAccountBalance();
        assertEquals(updatedTransactionAmount, expectedTransactionAmount);
    }

    @Test(priority = 8)
    public void verifyDeleteTransaction() {
        transactionsPage.deleteTransaction();
    }

    @AfterClass
    public void tearDown() {
        Driver.androidDriver.resetApp();
    }

}
