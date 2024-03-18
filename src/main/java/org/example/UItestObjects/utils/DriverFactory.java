package org.example.UItestObjects.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {
    private static WebDriver driver;
    private static final int TIMEOUT = 5;
    private static Logger logger = LogManager.getLogger();

    private DriverFactory() {
    }

    public static WebDriver getInstance() {
        if (driver == null) {
            setINSTANCE("chrome");
        }
        return driver;
    }

    private static void setINSTANCE(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                driver = new ChromeDriver(options);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
                break;
            /*case "firefox":
                FirefoxOptions optionsff = new FirefoxOptions();
                options.addArguments("--start-maximized");
                driver = new FirefoxDriver();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
                break;
            case "ie":
                InternetExplorerOptions optionsie = new InternetExplorerOptions();
                driver = new InternetExplorerDriver();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
                break;
            case "safari":
                WebDriverManager.safari().setup();
                driver = new org.openqa.selenium.safari.SafariDriver();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));*/
            default:
                throw new IllegalArgumentException("Invalid browser");
        }
    }

    public static void tearDown() {
        if (driver != null) {
            try {
                driver.close();
            } catch (Exception e) {
                logger.error("An error occurred while closing the web page: " + e.getMessage());
            } finally {
                driver.quit();

            }
            driver = null;
        } else {
            logger.warn("WebDriver instance is already null. No action taken in tearDown() method.");
        }
    }

}

