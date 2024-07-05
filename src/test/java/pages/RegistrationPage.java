package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ClickableEvents;

import javax.inject.Inject;

public class RegistrationPage {

    @Inject
    ClickableEvents clickableEvents;

    @FindBy(xpath="//div[@id='content']/h1")
    public WebElement textRegisterAccount;
    @FindBy(xpath="//input[@name='firstname']")
    public WebElement inputFirstName;
    @FindBy(xpath="//input[@name='lastname']")
    public WebElement inputLastName;
    @FindBy(xpath="//input[@name='email']")
    public WebElement inputEmail;
    @FindBy(xpath="//input[@name='password']")
    public WebElement inputPassword;
    @FindBy(xpath="//input[@name='agree']")
    public WebElement checkboxAgree;
    @FindBy(xpath="//button[text()='Continue']")
    public WebElement buttonContinue;
    @FindBy(xpath="//div[@id='content']/h1")
    public WebElement textAccountHasBeenCreated;
    @FindBy(xpath="//div[@id='content']/p")
    public WebElement textCongratulations;

    @FindBy(linkText = "Continue")
    public WebElement linkContinue;

    @Inject
    public RegistrationPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public String getPageHeading(){
        return clickableEvents.getText(textRegisterAccount);
    }



}
