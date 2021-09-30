package config;
import org.aeonbits.owner.ConfigFactory;

public class Project {
    public static LocalConfig localConfig =
            ConfigFactory.create(LocalConfig.class, System.getProperties());
    public static EmulatorConfig emulatorConfig =
            ConfigFactory.create(EmulatorConfig.class, System.getProperties());
    public static BrowserstackConfig browserstackConfig =
            ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
    public static SelenoidConfig selenoidConfig =
            ConfigFactory.create(SelenoidConfig.class, System.getProperties());

}
