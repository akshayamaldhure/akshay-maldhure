package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsPage {

    @FindBy(xpath = "//android.widget.Button[@text='DISMISS']")
    private WebElement dismissButton;

    @FindBy(id = "org.gnucash.android:id/fab_create_account")
    private WebElement addAccountButton;

    AndroidDriver androidDriver;

    public AccountsPage(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements(androidDriver, this);
    }

    public void clickDismissButton() {
        if (dismissButton.isDisplayed())
            dismissButton.click();
    }

    public void clickAddAccountButton() {
        addAccountButton.click();
    }

    public boolean isAccountPresent(String accountName) {
        return this.androidDriver.findElement(By.xpath("//android.widget.TextView[contains(@text, '" + accountName + "')]")).isDisplayed();
    }
}
