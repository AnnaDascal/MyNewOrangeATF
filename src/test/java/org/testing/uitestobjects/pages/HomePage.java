package org.testing.uitestobjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends Page {

    @FindBy(xpath = "//span[@class='oxd-topbar-header-breadcrumb']/h6")
    public WebElement homePageUserName;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //TODO:  Web element Locators-> Custom XPath (link)
    //TODO: Refactor : (Locators -> Pages) and utils to Java test pcg
//TODO: Scenario contecst
}
