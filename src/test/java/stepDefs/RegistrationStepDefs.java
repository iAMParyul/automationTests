package stepDefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import lombok.Getter;
import lombok.Setter;
import pages.RegistrationPage;
import utils.ClickableEvents;
import utils.RandomDataGenerator;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RegistrationStepDefs {

    @Inject
    ClickableEvents clickableEvents;

    @Inject
    RegistrationPage registrationPage;

    @Inject
    RandomDataGenerator randomPasswordGenerator;

    @When("I fill following details on the registration page")
    public void iFillFollowingDetailsOnTheRegistrationPage(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        registrationPage.inputFirstName.sendKeys(data.get(0).get("Firstname") + randomPasswordGenerator.generateRandomFDNumber());
        registrationPage.inputLastName.sendKeys(data.get(0).get("Lastname") + randomPasswordGenerator.generateRandomFDNumber());
        registrationPage.inputEmail.sendKeys(data.get(0).get("Email") + randomPasswordGenerator.generateRandomFDNumber() + "@gmail.com");
        registrationPage.inputPassword.sendKeys(randomPasswordGenerator.generateRandomPassword(10));
        clickableEvents.click(registrationPage.checkboxAgree);
    }

    @And("click on continue button")
    public void clickOnContinueButton() {
        clickableEvents.click(registrationPage.buttonContinue);
    }

    @And("I got message of account has been created")
    public void iGotMessageOfAccountHasBeenCreated() {
        assertEquals("Your Account Has Been Created!", registrationPage.textAccountHasBeenCreated.getText());
        assertEquals("Your Account Has Been Created!", registrationPage.textCongratulations.getText());
    }

    @And("I click on continue button")
    public void iClickOnContinueButton() {
        clickableEvents.click(registrationPage.linkContinue);
    }

}
