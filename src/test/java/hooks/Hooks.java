package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import javax.inject.Inject;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Hooks {
    @Inject
    private WebDriver webDriver;

    @Inject
    LoginPage loginPage;

    @Before("@Login")
    public void getLogin() {
        System.out.println("Run Before Scenario");
        Properties properties = new Properties();
        try {
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/config/env.config");
            properties.load(file);
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            webDriver.get(properties.getProperty(System.getProperty("env") + ".URL"));
            loginPage.login(properties.getProperty(System.getProperty("env") + ".Username"), properties.getProperty(System.getProperty("env") + ".Password"));
        } catch (
                IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Before("@Launch")
    public void getLaunch() {
        System.out.println("Run Before Scenario");
        Properties properties = new Properties();
        try {
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/config/env.config");
            properties.load(file);
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            webDriver.get(properties.getProperty(System.getProperty("env") + ".URL"));
        } catch ( IOException e) {
            throw new RuntimeException(e);
        }
    }

    @After("@end")
    public void End() {
        webDriver.quit();
    }
}
