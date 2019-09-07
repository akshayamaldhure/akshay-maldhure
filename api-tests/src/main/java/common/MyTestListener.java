package common;

import config.Environment;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.Logger;
import org.testng.*;

import static common.CommonTests.getHealthCheckResponse;

public class MyTestListener implements ISuiteListener, ITestListener {

    private Logger log = MyLogger.log;

    public void onStart(ISuite iSuite) {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        new Environment();
        new Spec();
        Response healthCheckResponse = getHealthCheckResponse();
        if (healthCheckResponse.statusCode() != 200)
            throw new SkipException("Skipping tests as the application backend is down. Error: " + healthCheckResponse.getStatusLine());
        else
            log.info("Health check successful: " + healthCheckResponse.getStatusLine());
    }

    public void onFinish(ISuite iSuite) {
        log.info("Finished running all the tests.");
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
