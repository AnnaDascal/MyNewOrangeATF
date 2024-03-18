package org.testing.definitions;

import io.cucumber.java.BeforeAll;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.UItestObjects.utils.DriverFactory;
import org.example.UItestObjects.utils.ScenarioContext;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    private static Logger logger = LogManager.getLogger();
    private static String scenarioName;


//    @Before
//    public static void beforeEveryScenarious(Scenario scenario) {
//        ScenarioContext.getInstance().clearContext();
//        scenarioName = scenario.getName();
//    }
//TODO: Before должно происходить: идет в базу данных и(создает юзера если там нет данных) сохраняет данные в scenario context и работает с ними


    @Before("@UI")
    public static void setUpUI()            {
    logger.info(System.lineSeparator()+"Starting UI test "+scenarioName);
    DriverFactory.getInstance();
    }

    /*@Before("@API")
    * public static void setUpUI()            {
    logger.info(System.lineSeparator()+"Starting API test "+scenarioName);
    DriverFactory.getInstance();
    }*/

    @After

    public static void tearDown(Scenario scenario) {

        //validate if scenario has failed
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) DriverFactory.getInstance()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        DriverFactory.tearDown();
    }
} //TODO: After: Удаляет данные из DB =delete and Приводит к прежднему виду =rollback
// component Service  (если используешь спринг то все зависимости использешь out of were (аутоуаер) не будет new)
// what are anotation in java
//seleniti - большой обьем информации
//castom exeption  (asssert ..)
// String name of enums