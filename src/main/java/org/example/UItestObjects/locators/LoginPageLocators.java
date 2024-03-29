package org.example.UItestObjects.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageLocators extends Page{
    @FindBy(name = "username")
    public WebElement userName;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(xpath = "//span[contains(@class,'input-group__message')]")
    public WebElement missingUsernameErrorMessage;

    @FindBy(xpath = "//button[contains(@class,'orangehrm-login-button')]")

    public WebElement login;

    @FindBy(xpath = "//p[contains(@class,'alert-content-text')]")
    public WebElement errorMessage;

    @FindBy(xpath = "//div[@class='orangehrm-login-forgot']/p")
    public WebElement forgotPasswordButton;

    public LoginPageLocators(WebDriver driver) {
        super(driver);
    }
}
