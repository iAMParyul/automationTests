package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ClickableEvents;

import javax.inject.Inject;

public class LoginPage {

    @Inject
    private WebDriver webDriver;
    @FindBy(xpath = "//input[@id='input-email']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@id='input-password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement LoginButton;

    @Inject
    ClickableEvents clickableEvents;

    @Inject
    LaunchPage launchPage;

    @Inject
    public LoginPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public void login( String username, String password) throws InterruptedException {
        Thread.sleep(5000);
        clickableEvents.click(launchPage.myAccountTab);
        Thread.sleep(5000);
        clickableEvents.click(launchPage.loginTab);
        Thread.sleep(5000);
        usernameInput.sendKeys(username);
        Thread.sleep(5000);
        passwordInput.sendKeys(password);
        Thread.sleep(5000);
        clickableEvents.click(LoginButton);
        Thread.sleep(5000);
    }
}
