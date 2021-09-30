package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/local.properties"
})
public interface LocalConfig extends Config {
    @Key("appium_url")
    String appium_url();

    @Key("platformName")
    String platformName();

    @Key("deviceName")
    String deviceName();

    @Key("version")
    String version();

    @Key("locale")
    String locale();

    @Key("language")
    String language();

    @Key("appPackage")
    String appPackage();

    @Key("appActivity")
    String appActivity();

    @Key("app")
    String app();

}
