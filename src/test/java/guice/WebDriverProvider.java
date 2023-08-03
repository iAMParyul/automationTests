package guice;

import com.google.inject.Provider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Browser;

import java.util.ServiceLoader;

public class WebDriverProvider implements Provider<WebDriver> {

    public static final String BROWSER_CONF = "browser";

    public WebDriver webDriver;
    @Override
    public WebDriver get() {
        return initBrowser();
    }

    private WebDriver initBrowser() {
        String browser = System.getProperty(BROWSER_CONF);
        if (browser == null) {
            return initChrome();
        } else {
            return initChrome();

        }
    }

    private WebDriver initChrome() {
        System.setProperty("webdriver.chrome.driver","/Users/paryuljain/chromeDriver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver webDriver = new ChromeDriver(options);
        return webDriver;
    }
}
