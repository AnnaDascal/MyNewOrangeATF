package org.testing.uitestobjects.actions;

import org.testing.utils.DriverFactory;
import org.testing.uitestobjects.pages.RequestPasswordResetCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestPasswordResetCodePage {
    RequestPasswordResetCode requestPasswordResetCode = null;
    // private static Logger logger = LogManager.getLogger();

    public RequestPasswordResetCodePage() {
        this.requestPasswordResetCode = new RequestPasswordResetCode(DriverFactory.getInstance());
    }


    public void enterLoginAndGoToSendPasswordResetPage(String resetPasswordUserName) {
        requestPasswordResetCode.resetPasswordUserNameField.sendKeys(resetPasswordUserName);
        requestPasswordResetCode.resetPasswordButton.click();
    }

    public String verifyRequestPasswordResetCodeNameOfThePage() {
        return requestPasswordResetCode.resetPasswordTitle.getText();
    }
        //logger.info("Verify the Home page title");

    // public String getErrorMessage() {
//        return loginPageLocators.errorMessage.getText();
}
