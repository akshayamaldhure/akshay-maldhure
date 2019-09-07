package tests;

import pages.AccountsPage;
import pages.SetupPage;

import static org.testng.Assert.assertTrue;

public class Common {
    public static void completeSetup(SetupPage setupPage, AccountsPage accountsPage, String currency, String accountOption, String feedbackOption) {
        setupPage.clickNext();
        setupPage.selectCurrency(currency);
        setupPage.clickNext();
        setupPage.selectAccountOption(accountOption);
        setupPage.clickNext();
        setupPage.selectFeedbackOption(feedbackOption);
        setupPage.clickNext();
        assertTrue(setupPage.isTextSeen(currency));
        assertTrue(setupPage.isTextSeen(accountOption));
        assertTrue(setupPage.isTextSeen(feedbackOption));
        setupPage.clickDoneButton();
        accountsPage.clickDismissButton();
    }
}
