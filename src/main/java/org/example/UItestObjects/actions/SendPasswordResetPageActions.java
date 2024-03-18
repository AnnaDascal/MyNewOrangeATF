package org.example.UItestObjects.actions;

import org.example.UItestObjects.locators.SendPasswordResetPageLocators;
import org.example.UItestObjects.utils.DriverFactory;


public class SendPasswordResetPageActions {
    SendPasswordResetPageLocators sendPasswordResetPageLocators = null;

    // private static Logger logger = LogManager.getLogger();
    public SendPasswordResetPageActions() {
        this.sendPasswordResetPageLocators = new SendPasswordResetPageLocators(DriverFactory.getInstance());
    }

    public String getSendPasswordResetSuccessMessage() {
        return sendPasswordResetPageLocators.sendPasswordResetSuccessMessage.getText();
    }
}
