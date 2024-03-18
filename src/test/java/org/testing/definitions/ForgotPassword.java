package org.testing.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testing.uitestobjects.actions.RequestPasswordResetCodePage;
import org.testing.uitestobjects.actions.LoginPage;
import org.testing.uitestobjects.actions.SendPasswordResetPage;
import org.testng.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ForgotPassword {

    LoginPage objLogin = new LoginPage();
    RequestPasswordResetCodePage objRequestPasswordReset = new RequestPasswordResetCodePage();
    SendPasswordResetPage objSendPasswordReset = new SendPasswordResetPage();

    private static final Logger logger = LoggerFactory.getLogger(org.testing.definitions.LoginPage.class);


    @And("Click on the Forgot Password button")
    public void goToRequestPasswordResetCodePage() {
        logger.info("Clicking on the Forgot Password button");
        objLogin.clickGoToRequestPasswordResetCodePage();
    }


    @When("User enters username as {string} and click on the Reset Password button")
    public void goToSendPasswordResetPage(String resetPasswordName) {
        logger.info("Entering username: {} and clicking on the Reset Password button", resetPasswordName);
        objRequestPasswordReset.enterLoginAndGoToSendPasswordResetPage(resetPasswordName);
    }

    @Then("New page is open and user should have success massage {string}")
    public void verifySendPasswordResetSuccessMessage(String expectedSendPasswordResetSuccessMessage) {
        logger.info("Verifying success message: {}", expectedSendPasswordResetSuccessMessage);
        Assert.assertEquals(objSendPasswordReset.getSendPasswordResetSuccessMessage(), expectedSendPasswordResetSuccessMessage);
    }

    @Then("User should have error message {string}")
    public void verifyErrorMessage(String expectedErrorMessage) {
        logger.info("Verifying error message: {}", expectedErrorMessage);
        Assert.assertEquals(objLogin.getMissingUsernameText(), expectedErrorMessage);
    }

    @When("User click on the Cancel button")
    public void userClickOnTheCancelButton() {
        logger.info("Clicking on the Cancel button");
    }

    @Then("User should be on login page again")
    public void userShouldBeOnLoginPageAgain() {
        logger.info("Verifying user is on the login page again");
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
