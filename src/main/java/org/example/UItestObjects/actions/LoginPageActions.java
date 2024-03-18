package org.example.UItestObjects.actions;

import org.example.UItestObjects.locators.LoginPageLocators;
import org.example.UItestObjects.utils.DriverFactory;
import org.openqa.selenium.support.PageFactory;

public class LoginPageActions {
    LoginPageLocators loginPageLocators = null;

    public LoginPageActions() {
        this.loginPageLocators = new LoginPageLocators(DriverFactory.getInstance());
    }

    // Get the error message when username is blank
    public String getMissingUsernameText() {
        return loginPageLocators.missingUsernameErrorMessage.getText();
    }

    // Get the Error Message
    public String getErrorMessage() {
        return loginPageLocators.errorMessage.getText();
    }

    public void login(String strUserName, String strPassword) {

        // Fill username
        loginPageLocators.userName.sendKeys(strUserName);

        // Fill password
        loginPageLocators.password.sendKeys(strPassword);

        // Click Login button
        loginPageLocators.login.click();
    }

    public void clickGoToRequestPasswordResetCodePage() {
        // Click Login button
        loginPageLocators.forgotPasswordButton.click();
    }
}
