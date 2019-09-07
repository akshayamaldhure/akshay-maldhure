package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationPage {

    public class AccountType {
        public static final String CASH = "CASH";
        public static final String BANK = "BANK";
        public static final String CREDIT_CARD = "CREDIT CARD";
        public static final String ASSET = "ASSET";
    }

    @FindBy(id = "org.gnucash.android:id/input_account_name")
    private WebElement inputAccountTextField;

    @FindBy(id = "org.gnucash.android:id/input_currency_spinner")
    private WebElement currencySelector;

    @FindBy(id = "org.gnucash.android:id/input_account_type_spinner")
    private WebElement accountTypeSelector;

    @FindBy(id = "org.gnucash.android:id/input_account_description")
    private WebElement accountDescriptionTextField;

    @FindBy(id = "org.gnucash.android:id/menu_save")
    private WebElement saveButton;

    AndroidDriver androidDriver;

    public AccountCreationPage(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements(androidDriver, this);
    }

    public void enterAccountName(String accountName) {
        inputAccountTextField.clear();
        inputAccountTextField.sendKeys(accountName);
    }

    public void setCurrency(String currency) {
        currencySelector.click();
        this.androidDriver.findElement(By.xpath("//android.widget.CheckedTextView[contains(@text, '"+currency+"')]")).click();
    }

    public void setAccountType(String accountType) {
        accountTypeSelector.click();
        this.androidDriver.findElement(By.xpath("//android.widget.CheckedTextView[contains(@text, '"+accountType+"')]")).click();
    }

    public void enterAccountDescription(String accountDescription) {
        accountDescriptionTextField.clear();
        accountDescriptionTextField.sendKeys(accountDescription);
    }

    public void clickSaveButton() {
        saveButton.click();
    }
}
