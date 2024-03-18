package org.testing.uitestobjects.actions;


import org.testing.utils.DriverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage {
    org.testing.uitestobjects.pages.HomePage homePage;

    public HomePage() {
        this.homePage = new org.testing.uitestobjects.pages.HomePage(DriverFactory.getInstance());

    }

    // Get the Username from Home Page
    public String getHomePageText() {
        // logger.info("Verify the Home page title");
        return homePage.homePageUserName.getText();
    }
}
