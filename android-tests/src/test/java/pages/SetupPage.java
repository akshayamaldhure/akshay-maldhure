package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SetupPage {

    public enum Currency {
        CHF, EUR, GBP, USD
    }

    public class AccountType {
        public static final String DEFAULT = "Create default accounts";
        public static final String IMPORT = "Import my accounts";
        public static final String LET_ME_HANDLE = "Let me handle it";
    }

    public class FeedbackOptions {
        public static final String AUTOMATIC = "Automatically send crash reports";
        public static final String DISABLE = "Disable crash reports";
    }

    @FindBy(id = "org.gnucash.android:id/btn_save")
    private WebElement nextButton;

    @FindBy(xpath = "//android.widget.Button[@text='DONE']")
    private WebElement doneButton;

    AndroidDriver androidDriver;

    public SetupPage(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements(androidDriver, this);
    }

    public void clickNext() {
        nextButton.click();
    }

    public void selectCurrency(String currency) {
        this.androidDriver.findElement(By.xpath("//android.widget.CheckedTextView[@text='" + currency + "']")).click();
    }

    public void selectAccountOption(String accountType) {
        this.androidDriver.findElement(By.xpath("//android.widget.CheckedTextView[@text='" + accountType + "']")).click();
    }

    public void selectFeedbackOption(String feedbackOption) {
        this.androidDriver.findElement(By.xpath("//android.widget.CheckedTextView[@text='" + feedbackOption + "']")).click();
    }

    public void clickDoneButton() {
        doneButton.click();
    }

    public boolean isTextSeen(String text) {
        return this.androidDriver.findElement(By.xpath("//android.widget.TextView[contains(@text, '" + text + "')]")).isDisplayed();
    }
}
