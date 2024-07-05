package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.LaunchPage;
import pages.RegistrationPage;
import utils.ClickableEvents;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.inject.Inject;


public class BackgroundStepDefs {

    @Inject
    ClickableEvents clickableEvents;
    @Inject
    LaunchPage launchPage;

    @Inject
    RegistrationPage registrationPage;

    @Given("I'm on Opencart Registration Launch page")
    public void iAMOnOpenCartRegistrationLaunchPage() {
        clickableEvents.click(launchPage.myAccountTab);
        clickableEvents.click(launchPage.registerTab);
    }

    @And("I can see the details to fill page")
    public void iCanSeeFormToFillNewUserDetails() {
        assertEquals("Register Account", registrationPage.getPageHeading());
    }
}
