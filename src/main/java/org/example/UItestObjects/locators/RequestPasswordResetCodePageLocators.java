package org.example.UItestObjects.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RequestPasswordResetCodePageLocators  extends Page {
   /* @FindBy(name = "username")
    public WebElement userName;*/


    @FindBy(xpath = "//h6[contains(@class,'forgot-password-title')]")
    public WebElement resetPasswordTitle;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement resetPasswordUserNameField;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement resetPasswordButton;

    public RequestPasswordResetCodePageLocators(WebDriver driver) {
        super(driver);
    }
}
