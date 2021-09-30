package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import config.Project;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LocalDriver implements WebDriverProvider {

    public static URL getAppiumServerUrl() {
        try {
            return new URL(Project.localConfig.appium_url());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        desiredCapabilities.setCapability("platformName", Project.localConfig.platformName());
        desiredCapabilities.setCapability("deviceName", Project.localConfig.deviceName());
        desiredCapabilities.setCapability("version", Project.localConfig.version());
        desiredCapabilities.setCapability("locale", Project.localConfig.locale());
        desiredCapabilities.setCapability("language", Project.localConfig.language());
        desiredCapabilities.setCapability("appPackage", Project.localConfig.appPackage());
        desiredCapabilities.setCapability("appActivity", Project.localConfig.appActivity());
        desiredCapabilities.setCapability("app", getAbsolutePath(Project.localConfig.app()));

        return new AndroidDriver(getAppiumServerUrl(), desiredCapabilities);
    }

    private String getAbsolutePath(String filePath) {
        File file = new File(filePath);
        assertTrue(file.exists(), filePath + " not found");
        return file.getAbsolutePath();
    }
}
