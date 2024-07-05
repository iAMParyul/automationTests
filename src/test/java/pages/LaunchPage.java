package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.inject.Inject;

public class LaunchPage {

    @Inject
    private WebDriver webDriver;

    @FindBy(xpath = "//span[text()='My Account']")
    public WebElement myAccountTab;

    @FindBy(xpath = "//a[text()='Login']")
    public WebElement loginTab;

    @FindBy(xpath = "//a[text()='Register']")
    public WebElement registerTab;


    @Inject
    public LaunchPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }
}
