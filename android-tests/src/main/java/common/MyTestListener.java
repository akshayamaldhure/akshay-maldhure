package common;

import config.Environment;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MyTestListener implements ISuiteListener, ITestListener {

    private Logger log = MyLogger.log;
    public AppiumDriverLocalService appiumDriverLocalService;

    public void onStart(ISuite iSuite) {
        new Environment();
        String hubUrl = Environment.url;
        startAppiumDriverLocalService();
        DesiredCapabilities desiredCapabilities = setupDesiredCapabilities();
        setupAndroidDriver(hubUrl, desiredCapabilities);
    }

    public void setupAndroidDriver(String hubUrl, DesiredCapabilities desiredCapabilities) {
        try {
            Driver.androidDriver = new AndroidDriver(new URL(hubUrl), desiredCapabilities);
            Driver.androidDriver.manage().timeouts().implicitlyWait(Environment.globalTimeout, TimeUnit.SECONDS);
        } catch (Exception e) {
            log.info("Stopping the AppiumService");
            appiumDriverLocalService.stop();
            e.printStackTrace();
        }
    }

    public void startAppiumDriverLocalService() {
        String environment = System.getProperty("env", Environment.LOCAL_ENV);
        if (environment.equalsIgnoreCase(Environment.LOCAL_ENV)) {
            try {
                appiumDriverLocalService = AppiumDriverLocalService.buildDefaultService();
                appiumDriverLocalService.start();
            } catch (Exception e) {
                log.error("Something went wrong while setting up AppiumService.");
                e.printStackTrace();
            }
        } else {
            log.info("No implementation available for " + environment);
            System.exit(1);
        }
    }

    public DesiredCapabilities setupDesiredCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("app", Environment.appPath);
        desiredCapabilities.setCapability("autoGrantPermissions", Environment.autoGrantPermissions);
        desiredCapabilities.setCapability("deviceName", Environment.deviceName);
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", Environment.platformVersion);
        desiredCapabilities.setCapability("appPackage", Environment.appPackage);
        desiredCapabilities.setCapability("appActivity", Environment.appActivity);
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        return desiredCapabilities;
    }

    public void onFinish(ISuite iSuite) {
        log.info("Finished running all the tests.");
        if(Driver.androidDriver != null) {
            log.info("Quitting the AndroidDriver");
            Driver.androidDriver.quit();
        }
        if(appiumDriverLocalService.isRunning()) {
            log.info("Stopping the AppiumService");
            appiumDriverLocalService.stop();
        }
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        log.info("Starting test " + iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info("Test " + iTestResult.getName() + " PASSED");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.error("Test " + iTestResult.getName() + " FAILED");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log.warn("Test " + iTestResult.getName() + " SKIPPED");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
