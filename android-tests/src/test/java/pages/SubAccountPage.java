package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubAccountPage {

    AndroidDriver androidDriver;

    @FindBy(xpath = "//android.widget.TextView[contains(@text, 'Current Assets')]")
    private WebElement subAccountName;

    @FindBy(id = "org.gnucash.android:id/create_transaction")
    private WebElement addTransactionButton;

    public SubAccountPage(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements(androidDriver, this);
    }

    public void clickSubAccountButton() {
        subAccountName.click();
    }

    public void clickAddTransactionButton() {
        addTransactionButton.click();
    }
}
