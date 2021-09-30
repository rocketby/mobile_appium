package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import config.Project;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {
    public static URL getBrowserstackUrl() {
        try {
            return new URL(Project.browserstackConfig.browserstack_url());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        // Set your access credentials
        desiredCapabilities.setCapability("browserstack.user", Project.browserstackConfig.username());
        desiredCapabilities.setCapability("browserstack.key", Project.browserstackConfig.password());

        // Set URL of the application under test
        desiredCapabilities.setCapability("app", Project.browserstackConfig.app());

        // Specify device and os_version for testing
        desiredCapabilities.setCapability("device", Project.browserstackConfig.device());
        desiredCapabilities.setCapability("os_version", Project.browserstackConfig.os_version());

        // Set other BrowserStack capabilities
        desiredCapabilities.setCapability("project", "Wiki Java Project");
        desiredCapabilities.setCapability("build", "Java Android");
        desiredCapabilities.setCapability("name", "wiki_test");

        return new AndroidDriver(getBrowserstackUrl(), desiredCapabilities);
    }
}
