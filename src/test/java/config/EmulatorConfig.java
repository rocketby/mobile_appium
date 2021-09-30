package config;
import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/emulator.properties"
})
public interface EmulatorConfig extends Config{
    @Key("appium_url")
    String appium_url();

    @Key("platformName")
    String platformName();

    @Key("deviceName")
    String deviceName();

    @Key("version")
    String version();

    @Key("appPackage")
    String appPackage();

    @Key("appActivity")
    String appActivity();

    @Key("app")
    String app();

}
