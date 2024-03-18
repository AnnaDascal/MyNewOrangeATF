package org.testing.definitions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testing.uitestobjects.actions.HomePage;
import org.testing.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    // Initializing the logger
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    WebDriver driver = DriverFactory.getInstance();
    org.testing.uitestobjects.actions.LoginPage objLogin = new org.testing.uitestobjects.actions.LoginPage();
    HomePage objHomePage = new HomePage();

    @Given("User is on orangeHRM login page {string}")
    public void loginTest(String url) {
        // Logging opening of the application
        logger.info("Opening the application with URL: {}", url);
        driver.get(url);
    }

    @When("User enters username as {string} and password as {string}")
    public void goToHomePage(String userName, String passWord) {
        // Logging user input
        logger.info("Entering username: {} and password: {}", userName, passWord);
        objLogin.login(userName, passWord);
    }

    @Then("User should be able to login successfully and new page open")
    public void verifyLogin() {
        // Logging successful login
        logger.info("User logged in successfully.");
        Assert.assertTrue(objHomePage.getHomePageText().contains("Dashboard"));
    }

    @Then("User should be able to see error message {string}")
    public void verifyErrorMessage(String expectedErrorMessage) {
        // Logging error message verification
        logger.info("Verifying error message: {}", expectedErrorMessage);
        Assert.assertEquals(objLogin.getErrorMessage(), expectedErrorMessage);
    }

    @Then("User should be able to see a message {string} below Username")
    public void verifyMissingUsernameMessage(String message) {
        // Logging missing username message verification
        logger.info("Verifying missing username message: {}", message);
        Assert.assertEquals(objLogin.getMissingUsernameText(), message);
    }
}
