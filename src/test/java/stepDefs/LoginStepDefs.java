package stepDefs;

import org.openqa.selenium.WebDriver;
import pages.LaunchPage;
import utils.ClickableEvents;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

import javax.inject.Inject;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoginStepDefs {

    @Inject
    private ClickableEvents clickableEvents;

    @Inject
    private LoginPage loginPage;

    @Inject
    private WebDriver webDriver;

    @Inject
    private LaunchPage launchPage;

    @Given("We are at login Page of Demo cart app")
    public void weAreAtLoginPageOfDemoCartApp() throws InterruptedException {
        clickableEvents.click(launchPage.myAccountTab);
        clickableEvents.click(launchPage.loginTab);
    }

    @When("User enters the username : {string}")
    public void userEntersTheUsername(String username) {
        loginPage.usernameInput.sendKeys(username);
    }

    @And("enters the password : {string}")
    public void entersThePassword(String password) {
        loginPage.passwordInput.sendKeys(password);
    }

    @And("click on login button")
    public void clickOnLoginButton() {
        loginPage.LoginButton.click();
    }

    @Then("user able to login")
    public void userAbleToLogin() {
    }
}
