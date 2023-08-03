package stepDefs;

import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;

import javax.inject.Inject;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Hooks {
    private WebDriver webDriver;

    @Inject
    LoginPage loginPage;

    @Inject
    public Hooks (WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    @Before("@Login")
    public void getUrl() {
        System.out.println("Run Before Scenario");
        Properties properties = new Properties();
        try {
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/config/env.config");
            properties.load(file);
            webDriver.get(properties.getProperty(System.getProperty("env") + ".URL"));
            loginPage.login(properties.getProperty(System.getProperty("env") + ".Username"), properties.getProperty(System.getProperty("env") + ".Password"));
        } catch (
                IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
