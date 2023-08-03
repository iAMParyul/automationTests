package guice;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;
import io.cucumber.guice.ScenarioScoped;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.ClickableEvents;
@Slf4j
public class ProjectModule extends AbstractModule {
    private Injector injector;
    private static ThreadLocal<Injector> instances = new ThreadLocal<Injector>();

    public Injector getInjector() {
        if(this.injector == null) {
            injector = Guice.createInjector(Stage.PRODUCTION, this);
            instances.set(injector);
        }
        return  instances.get();
    }

    public <T> T get(Class<T> klass) { return getInjector().getInstance(klass);}

    @Override
    public void configure() {
        try {
            bind(WebDriver.class)
                    .toProvider(WebDriverProvider.class)
                    .in(ScenarioScoped.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
