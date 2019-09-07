package config;

import common.MyLogger;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Environment {

    public static String baseUrl;
    public static String products;
    public static String categories;
    public static String stores;
    public static String services;
    public static String version;
    public static String healthcheck;
    private Logger log = MyLogger.log;

    public Environment() {
        log.info("Setting up the test environment");
        String testEnvironment = System.getProperty("ENV", "staging");
        String commonConfigKey = "common";
        JSONObject envConfig = new JSONObject();
        JSONObject commonConfig = new JSONObject();
        try {
            envConfig = (JSONObject) ConfigProvider.getConfigObject(testEnvironment);
            commonConfig = (JSONObject) ConfigProvider.getConfigObject(commonConfigKey);
        } catch (IOException | ParseException e) {
            log.error("Something went wrong while parsing the environment data: " + e.getMessage());
        }
        if (envConfig == null) {
            log.error("The test environment '" + testEnvironment + "' was not found. Please provide a valid test environment name.");
        }
        Environment.baseUrl = envConfig.get("baseUrl").toString();
        Environment.products = commonConfig.get("products").toString();
        Environment.categories = commonConfig.get("categories").toString();
        Environment.stores = commonConfig.get("stores").toString();
        Environment.services = commonConfig.get("services").toString();
        Environment.version = commonConfig.get("version").toString();
        Environment.healthcheck = commonConfig.get("healthcheck").toString();
        log.info("Base URL: " + Environment.baseUrl);
    }
}
