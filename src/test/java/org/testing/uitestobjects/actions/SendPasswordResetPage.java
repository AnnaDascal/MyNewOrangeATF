package org.testing.uitestobjects.actions;

import org.testing.uitestobjects.pages.SendPasswordReset;
import org.testing.utils.DriverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SendPasswordResetPage {
    SendPasswordReset sendPasswordReset = null;

    // private static Logger logger = LogManager.getLogger();
    public SendPasswordResetPage() {
        this.sendPasswordReset = new SendPasswordReset(DriverFactory.getInstance());
    }

    public String getSendPasswordResetSuccessMessage() {
        return sendPasswordReset.sendPasswordResetSuccessMessage.getText();
    }
}
