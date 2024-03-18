package org.testing.uitestobjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestPasswordResetCode extends Page {
   /* @FindBy(name = "username")
    public WebElement userName;*/


    @FindBy(xpath = "//h6[contains(@class,'forgot-password-title')]")
    public WebElement resetPasswordTitle;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement resetPasswordUserNameField;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement resetPasswordButton;

    public RequestPasswordResetCode(WebDriver driver) {
        super(driver);
    }
}
