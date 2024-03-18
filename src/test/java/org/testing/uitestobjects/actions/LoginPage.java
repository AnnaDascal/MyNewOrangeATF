package org.testing.uitestobjects.actions;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testing.utils.DriverFactory;

public class LoginPage {
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    org.testing.uitestobjects.pages.LoginPage loginPage = null;

    public LoginPage() {
        this.loginPage = new org.testing.uitestobjects.pages.LoginPage(DriverFactory.getInstance());
    }

    public String getMissingUsernameText() {
        return loginPage.missingUsernameErrorMessage.getText();
    }

    public String getErrorMessage() {
        return loginPage.errorMessage.getText();
    }

    public void login(String strUserName, String strPassword) {
        loginPage.userName.sendKeys(strUserName);
        loginPage.password.sendKeys(strPassword);
        loginPage.login.click();
    }

    public void clickGoToRequestPasswordResetCodePage() {
        loginPage.forgotPasswordButton.click();
    }
}
