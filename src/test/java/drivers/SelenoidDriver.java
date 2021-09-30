package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import config.Project;

import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.String.format;

public class SelenoidDriver implements WebDriverProvider {

    public static URL getSelenoidUrl() {
        try {
            return new URL(format("https://%s:%s@" + Project.selenoidConfig.selenoid_url(),
                    Project.selenoidConfig.username(),
                    Project.selenoidConfig.password()));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        desiredCapabilities.setCapability("platformName", Project.selenoidConfig.platformName());
        desiredCapabilities.setCapability("deviceName", Project.selenoidConfig.deviceName());
        desiredCapabilities.setCapability("version", Project.selenoidConfig.version());
        desiredCapabilities.setCapability("locale", Project.selenoidConfig.locale());
        desiredCapabilities.setCapability("language", Project.selenoidConfig.language());
        desiredCapabilities.setCapability("enableVNC", Project.selenoidConfig.enableVNC());
        desiredCapabilities.setCapability("enableVideo", Project.selenoidConfig.enableVideo());
        desiredCapabilities.setCapability("appPackage", Project.selenoidConfig.appPackage());
        desiredCapabilities.setCapability("appActivity", Project.selenoidConfig.appActivity());
        desiredCapabilities.setCapability("app", apkUrl());

        return new AndroidDriver(getSelenoidUrl(), desiredCapabilities);
    }

    private URL apkUrl() {
        try {
            return new URL(Project.selenoidConfig.app());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
