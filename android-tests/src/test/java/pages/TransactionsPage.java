package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransactionsPage {

    AndroidDriver androidDriver;

    @FindBy(id = "org.gnucash.android:id/create_transaction")
    private WebElement createTransactionButton;

    @FindBy(id = "org.gnucash.android:id/account_balance")
    private WebElement accountBalanceText;

    @FindBy(id = "org.gnucash.android:id/options_menu")
    private WebElement editTransactionMenu;

    @FindBy(xpath = "//android.widget.TextView[contains(@text, 'Delete')]")
    private WebElement deleteButton;

    public TransactionsPage(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements(androidDriver, this);
    }

    public void clickCreateTransactionButton() {
        createTransactionButton.click();
    }

    public String getAccountBalance() {
        return accountBalanceText.getText();
    }

    public void clickTransaction(String transactionAmount) {
        this.androidDriver.findElement(By.xpath("//android.widget.TextView[contains(@text, '" + transactionAmount + "')]")).click();
    }

    public void deleteTransaction() {
        editTransactionMenu.click();
        deleteButton.click();
    }
}
