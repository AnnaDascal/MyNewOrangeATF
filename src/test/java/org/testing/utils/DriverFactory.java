package org.testing.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testing.uitestobjects.actions.LoginPage;

import java.time.Duration;

public class DriverFactory {
    private static final Logger logger = LoggerFactory.getLogger(DriverFactory.class); // Исправлено: изменено имя класса для логирования

    private static WebDriver driver;
    private static final int TIMEOUT = 5;

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
                logger.info("Chrome driver instance initialized");
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
                logger.info("Web page closed successfully");
            } catch (Exception e) {
                logger.error("An error occurred while closing the web page: {}", e.getMessage());
            } finally {
                driver.quit();
                logger.info("WebDriver quit successfully");
            }
            driver = null;
        } else {
            logger.warn("WebDriver instance is already null. No action taken in tearDown() method.");
        }
    }
}
