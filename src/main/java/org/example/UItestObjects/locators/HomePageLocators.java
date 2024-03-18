package org.example.UItestObjects.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageLocators extends Page {

    @FindBy(xpath = "//span[@class='oxd-topbar-header-breadcrumb']/h6")
    public WebElement homePageUserName;

    public HomePageLocators(WebDriver driver) {
        super(driver);
    }

    //TODO:  Web element Locators-> Custom XPath (link)
    //TODO: Refactor : (Locators -> Pages) and utils to Java test pcg
//TODO: Scenario contecst
}
