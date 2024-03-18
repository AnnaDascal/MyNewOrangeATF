package org.testing.uitestobjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {
    public Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
