package config;

import common.MyLogger;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;

public class Environment {

    private Logger log = MyLogger.log;
    public static String appPath;
    public static String url;
    public static long globalTimeout;
    public static boolean autoGrantPermissions;
    public static String deviceName;
    public static String platformVersion;
    public static String appPackage;
    public static String appActivity;
    public static final String LOCAL_ENV = "local";
    public static final String SAUCELABS_ENV = "sauceLabs";

    public Environment() {
        log.info("Setting up the test environment");
        String testEnvironment = System.getProperty("ENV", LOCAL_ENV);
        String commonConfigKey = "common";
        JSONObject envConfig = new JSONObject();
        JSONObject commonConfig;
        String projectDir = System.getProperty("user.dir");
        String pathSep = File.separator;
        try {
            envConfig = (JSONObject) ConfigProvider.getConfigObject(testEnvironment);
            commonConfig = (JSONObject) ConfigProvider.getConfigObject(commonConfigKey);
            appPath = projectDir + pathSep + "src" + pathSep + "main" + pathSep + "resources" + pathSep + commonConfig.get("app").toString();
            globalTimeout = Long.parseLong(commonConfig.get("globalTimeout").toString());
            url = envConfig.get("url").toString();
            autoGrantPermissions = Boolean.getBoolean(commonConfig.get("autoGrantPermissions").toString());
            deviceName = envConfig.get("deviceName").toString();
            platformVersion = commonConfig.get("platformVersion").toString();
            appPackage = commonConfig.get("appPackage").toString();
            appActivity = commonConfig.get("appActivity").toString();
        } catch (IOException | ParseException e) {
            log.error("Something went wrong while parsing the environment data: " + e.getMessage());
        }
        if (envConfig == null) {
            log.error("The test environment '" + testEnvironment + "' was not found. Please provide a valid test environment name.");
        }
    }
}
