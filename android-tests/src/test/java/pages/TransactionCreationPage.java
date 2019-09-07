package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransactionCreationPage {

    AndroidDriver androidDriver;

    @FindBy(id = "org.gnucash.android:id/input_transaction_name")
    private WebElement transactionDescriptionTextField;

    @FindBy(id = "org.gnucash.android:id/input_transaction_amount")
    private WebElement transactionAmountTextField;

    @FindBy(id = "org.gnucash.android:id/menu_save")
    private WebElement saveTransactionButton;

    public TransactionCreationPage(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements(androidDriver, this);
    }

    public void addTransactionDescription(String description) {
        transactionDescriptionTextField.clear();
        transactionDescriptionTextField.sendKeys(description);
    }

    public void addTransactionAmount(String amount) {
        transactionAmountTextField.clear();
        transactionAmountTextField.sendKeys(amount);
    }

    public void clickSaveTransactionButton() {
        saveTransactionButton.click();
    }
}
