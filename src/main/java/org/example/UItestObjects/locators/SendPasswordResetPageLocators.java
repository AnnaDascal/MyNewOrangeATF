package org.example.UItestObjects.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SendPasswordResetPageLocators extends Page {

    @FindBy(xpath = "//h6[contains(@class,'forgot-password-title')]")
    public WebElement sendPasswordResetSuccessMessage;

    public SendPasswordResetPageLocators(WebDriver driver) {
        super(driver);
    }
}
