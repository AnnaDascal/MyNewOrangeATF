package org.example.UItestObjects.actions;


import org.example.UItestObjects.locators.HomePageLocators;
import org.example.UItestObjects.utils.DriverFactory;


public class HomePageActions {
    HomePageLocators homePageLocators;

    public HomePageActions() {
        this.homePageLocators = new HomePageLocators(DriverFactory.getInstance());

    }

    // Get the Username from Home Page
    public String getHomePageText() {
        // logger.info("Verify the Home page title");
        return homePageLocators.homePageUserName.getText();
    }
}
