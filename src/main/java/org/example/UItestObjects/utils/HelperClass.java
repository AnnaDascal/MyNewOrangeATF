package org.example.UItestObjects.utils;

public class HelperClass {
   /* private static HelperClass helperClass;//

    private static WebDriver driver;//
    public final static int TIMEOUT = 5;//
    //TODO: Почему public
    private static Logger logger = LogManager.getLogger();

    private HelperClass() {

        WebDriverManager.chromedriver().setup();
        logger.info("Open a Chrome Web Browser");
        ChromeOptions options = new ChromeOptions();
        logger.info("Make the Web Browser full screen");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        logger.info("Wait for 5 sec");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
    }
    //TODO метод для конструктора

    public static void openPage(String url) {
        driver.get(url);
    }

    public static WebDriver getDriver() {//
        return driver;//
    }

    public static void setUpDriver() {

        if (helperClass == null) {

            helperClass = new HelperClass();
        }
    }

    public static void tearDown() {

        if (driver != null) {
            logger.info("Close the webpage");
            driver.close();
            logger.info("Close the Chrome Web Browser");
            driver.quit();
        }

        helperClass = null;
    }*/
}
