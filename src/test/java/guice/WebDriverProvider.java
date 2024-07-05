package guice;

import com.google.inject.Provider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
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
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--incognito");  // Incognito mode
        options.addArguments("--disable-cache");  // Disable cache
        options.addArguments("--disable-extensions");  // Disable extensions
        options.addArguments("--start-maximized");  // Start maximized
        options.addArguments("--disable-popup-blocking");  // Disable popup blocking
        options.addArguments("--disable-infobars");  // Disable infobars
        options.addArguments("--disable-notifications");  // Disable notifications
        options.addArguments("--disable-gpu");

        // Performance options
        options.addArguments("--no-sandbox");  // Bypass OS security model, required for running inside Docker
        options.addArguments("--disable-dev-shm-usage");  // Overcome limited resource problems in Docker

        // Privacy options
        options.addArguments("--disable-geolocation");  // Disable geolocation
        options.addArguments("--disable-media-stream");  // Disable media stream
        options.addArguments("--disable-web-security");  // Disable web security
        options.addArguments("--disable-site-isolation-trials");  // Disable site isolation trials
//
        return new ChromeDriver(options);
    }
}
