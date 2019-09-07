package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class AccountsPage {

    public class DefaultAccounts {
        public static final String ASSETS = "Assets";
        public static final String EQUITY = "Equity";
        public static final String EXPENSES = "Expenses";
        public static final String INCOME = "Income";
        public static final String LIABILITIES = "Liabilities";
    }

    public static final List<String> DEFAULT_ACCOUNTS = Arrays.asList(DefaultAccounts.ASSETS,
            DefaultAccounts.EQUITY, DefaultAccounts.EXPENSES, DefaultAccounts.INCOME, DefaultAccounts.LIABILITIES);

    @FindBy(xpath = "//android.widget.Button[@text='DISMISS']")
    private WebElement dismissButton;

    @FindBy(id = "org.gnucash.android:id/fab_create_account")
    private WebElement addAccountButton;

    @FindBy(id = "org.gnucash.android:id/options_menu")
    private WebElement editAccountMenu;

    @FindBy(id = "org.gnucash.android:id/favorite_status")
    private WebElement markAccountAsFavoriteButton;

    @FindBy(id = "org.gnucash.android:id/empty_view")
    private WebElement emptyViewNoAccounts;

    @FindBy(xpath = "//android.widget.TextView[contains(@text, 'FAVORITES')]")
    private WebElement favoritesTabButton;

    @FindBy(xpath = "//android.widget.TextView[contains(@text, 'ALL')]")
    private WebElement allTabButton;

    AndroidDriver androidDriver;

    public AccountsPage(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements(androidDriver, this);
    }

    public void clickAccountButton(String accountName) {
        this.androidDriver.findElement(By.xpath("//android.widget.TextView[contains(@text, '" + accountName + "')]")).click();
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

    public void editAccount() {
        editAccountMenu.click();
        this.androidDriver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Edit Account')]")).click();
    }

    public void markAccountAsFavorite() {
        markAccountAsFavoriteButton.click();
    }

    public void deleteAccount() {
        editAccountMenu.click();
        this.androidDriver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Delete')]")).click();
    }

    public boolean noAccountsExist() {
        return emptyViewNoAccounts.isDisplayed();
    }

    public void clickAll() {
        allTabButton.click();
    }

    public void clickFavorites() {
        favoritesTabButton.click();
    }
}
