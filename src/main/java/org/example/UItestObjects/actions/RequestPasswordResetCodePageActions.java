package org.example.UItestObjects.actions;

import org.example.UItestObjects.locators.RequestPasswordResetCodePageLocators;
import org.example.UItestObjects.utils.DriverFactory;
import org.openqa.selenium.support.PageFactory;

public class RequestPasswordResetCodePageActions {
    RequestPasswordResetCodePageLocators requestPasswordResetCodePageLocators = null;
    // private static Logger logger = LogManager.getLogger();

    public RequestPasswordResetCodePageActions() {
        this.requestPasswordResetCodePageLocators = new RequestPasswordResetCodePageLocators(DriverFactory.getInstance());
    }


    public void enterLoginAndGoToSendPasswordResetPage(String resetPasswordUserName) {
        requestPasswordResetCodePageLocators.resetPasswordUserNameField.sendKeys(resetPasswordUserName);
        requestPasswordResetCodePageLocators.resetPasswordButton.click();
    }

    public String verifyRequestPasswordResetCodeNameOfThePage() {
        return requestPasswordResetCodePageLocators.resetPasswordTitle.getText();
    }
        //logger.info("Verify the Home page title");

    // public String getErrorMessage() {
//        return loginPageLocators.errorMessage.getText();
}
