package helpers;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config.properties"})
public interface BaseConfig extends Config{
    String url();
    String driverPath();
    String driverProperty();
}
