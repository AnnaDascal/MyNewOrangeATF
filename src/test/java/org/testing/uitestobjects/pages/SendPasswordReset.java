package org.testing.uitestobjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.testing.pages.Page;

public class SendPasswordReset extends Page{

    @FindBy(xpath = "//h6[contains(@class,'forgot-password-title')]")
    public WebElement sendPasswordResetSuccessMessage;

    public SendPasswordReset(WebDriver driver) {
        super(driver);
    }
}
