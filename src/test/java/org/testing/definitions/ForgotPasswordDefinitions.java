package org.testing.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.UItestObjects.actions.RequestPasswordResetCodePageActions;
import org.example.UItestObjects.actions.LoginPageActions;
import org.example.UItestObjects.actions.SendPasswordResetPageActions;
import org.example.UItestObjects.utils.DriverFactory;
import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ForgotPasswordDefinitions {

    LoginPageActions objLogin = new LoginPageActions();
    RequestPasswordResetCodePageActions objRequestPasswordReset = new RequestPasswordResetCodePageActions();
    SendPasswordResetPageActions objSendPasswordReset = new SendPasswordResetPageActions();

    private static Logger logger = LogManager.getLogger();


    @And("Click on the Forgot Password button")
    public void goToRequestPasswordResetCodePage() {
        objLogin.clickGoToRequestPasswordResetCodePage();
    }


    @When("User enters username as {string} and click on the Reset Password button")
    public void goToSendPasswordResetPage(String resetPasswordName) {
        objRequestPasswordReset.enterLoginAndGoToSendPasswordResetPage(resetPasswordName);
    }

    @Then("New page is open and user should have success massage {string}")
    public void verifySendPasswordResetSuccessMessage(String expectedSendPasswordResetSuccessMessage) {
        Assert.assertEquals(objSendPasswordReset.getSendPasswordResetSuccessMessage(), expectedSendPasswordResetSuccessMessage);
    }

    @Then("User should have error message {string}")
    public void verifyErrorMessage(String expectedErrorMessage) {
        // Verify error message
        Assert.assertEquals(objLogin.getMissingUsernameText(), expectedErrorMessage);
    }

    @When("User click on the Cancel button")
    public void userClickOnTheCancelButton() {
    }

    @Then("User should be on login page again")
    public void userShouldBeOnLoginPageAgain() {
    }



    /*@Then("User failed to login")
public void userFailedToLogin(){
    try {
        String failedLoginMessage = "Error!"; // TODO: to add exact message
        String actualMessage = message.getText();
        Assert.assertEquals(failedLoginMessage, actualMessage);
    } catch (NoSuchElementException e) {
        logger.error("Login succeeded");
        homePage.logout();
    }*/


//verifyRequestPasswordResetCodeNameOfThePage
    //TODO DB HOOKS
/* Assert.assertEquals(objLogin.getErrorMessage(), expectedErrorMessage);
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
*/
}
