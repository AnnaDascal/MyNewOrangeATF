package org.testing.definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.UItestObjects.actions.HomePageActions;
import org.example.UItestObjects.actions.LoginPageActions;
import org.example.UItestObjects.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class LoginPageDefinitions {
    WebDriver driver = DriverFactory.getInstance();

    LoginPageActions objLogin = new LoginPageActions();
    HomePageActions objHomePage = new HomePageActions();
    private static Logger logger = LogManager.getLogger();

    @Given("User is on orangeHRM login page {string}")
    public void loginTest(String url) {
        driver.get(url);
        logger.info("Open the application");
    }


    @When("User enters username as {string} and password as {string}")
    public void goToHomePage(String userName, String passWord) {

        // login to application
        objLogin.login(userName, passWord);

        // go the next page

    }

    @Then("User should be able to login successfully and new page open")
    public void verifyLogin() {

        Assert.assertTrue(objHomePage.getHomePageText().contains("Dashboard"));
    }

    /*@When("User enters username as {string} and password as {string}")
    public void user_enters_username_as_and_password_as(String string, String string2)*/
    @Then("User should be able to see error message {string}")
    public void verifyErrorMessage(String expectedErrorMessage) {
        // Verify error message
        Assert.assertEquals(objLogin.getErrorMessage(), expectedErrorMessage);
    }

    @Then("User should be able to see a message {string} below Username")
    public void verifyMissingUsernameMessage(String message) {

        Assert.assertEquals(objLogin.getMissingUsernameText(), message);
    }

}

