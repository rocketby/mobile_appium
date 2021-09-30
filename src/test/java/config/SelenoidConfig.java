package config;

import org.aeonbits.owner.Config;
@Config.Sources({
        "classpath:properties/selenoid.properties"
})
public interface SelenoidConfig extends Config {
    @Key("selenoid_url")
    String selenoid_url();

    @Key("username")
    String username();

    @Key("password")
    String password();

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

    @Key("enableVNC")
    Boolean enableVNC();

    @Key("enableVideo")
    Boolean enableVideo();

    @Key("appPackage")
    String appPackage();

    @Key("appActivity")
    String appActivity();

    @Key("app")
    String app();
}

