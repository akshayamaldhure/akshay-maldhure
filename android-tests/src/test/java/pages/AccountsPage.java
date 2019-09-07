package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsPage {

    @FindBy(xpath = "//android.widget.Button[@text='DISMISS']")
    private WebElement dismissButton;

    AndroidDriver androidDriver;

    public AccountsPage(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements(androidDriver, this);
    }

    public void clickDismissButton() {
        dismissButton.click();
    }
}
