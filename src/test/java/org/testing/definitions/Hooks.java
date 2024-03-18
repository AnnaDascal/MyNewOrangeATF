package org.testing.definitions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testing.utils.DriverFactory;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);
    private static String scenarioName;

    @Before
    public void beforeEveryScenario(Scenario scenario) { // Исправлено: удален модификатор static и добавлен параметр типа Scenario
        //featureName = scenario.getFeatureName();
        scenarioName = scenario.getName();

    }
 /*   @Before
    public static void beforeEveryScenarious(Scenario scenario) {
        //ScenarioContext.getInstance().clearContext();
        scenarioName = scenario.getName();
    }*/
//TODO: Before должно происходить: идет в базу данных и(создает юзера если там нет данных) сохраняет данные в scenario context и работает с ними


    @Before("@UI")
    public void setUpUI() {
        logger.info("Starting UI test {}", scenarioName);
        DriverFactory.getInstance();
    }

    @Before("@API")
    public void setUpAPI() {
        logger.info("Starting API test {}", scenarioName);
        DriverFactory.getInstance();
    }

    @After
    public void tearDown(Scenario scenario) {
        //validate if scenario has failed
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) DriverFactory.getInstance()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
            logger.error("Scenario failed: {}", scenarioName);
        } else {
            logger.info("Scenario passed: {}", scenarioName);
        }
        DriverFactory.tearDown();

}}


//TODO: After: Удаляет данные из DB =delete and Приводит к прежднему виду =rollback
// component Service  (если используешь спринг то все зависимости использешь out of were (аутоуаер) не будет new)
// what are anotation in java
//seleniti - большой обьем информации
//castom exeption  (asssert ..)
// String name of enums