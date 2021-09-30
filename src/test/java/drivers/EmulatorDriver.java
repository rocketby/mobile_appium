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

public class EmulatorDriver implements WebDriverProvider {

    public static URL getAppiumServerUrl() {
        try {
            return new URL(Project.emulatorConfig.appium_url());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        desiredCapabilities.setCapability("platformName", Project.emulatorConfig.platformName());
        desiredCapabilities.setCapability("deviceName", Project.emulatorConfig.deviceName());
        desiredCapabilities.setCapability("version", Project.emulatorConfig.version());
        desiredCapabilities.setCapability("appPackage", Project.emulatorConfig.appPackage());
        desiredCapabilities.setCapability("appActivity", Project.emulatorConfig.appActivity());
        desiredCapabilities.setCapability("app", getAbsolutePath(Project.emulatorConfig.app()));

        return new AndroidDriver(getAppiumServerUrl(), desiredCapabilities);
    }

    private String getAbsolutePath(String filePath) {
        File file = new File(filePath);
        assertTrue(file.exists(), filePath + " not found");

        return file.getAbsolutePath();
    }
}
