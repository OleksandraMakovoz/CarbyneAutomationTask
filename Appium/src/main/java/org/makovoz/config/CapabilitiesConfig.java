package org.makovoz.config;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class CapabilitiesConfig {
    public static DesiredCapabilities getCapabilities(String platform, String hub) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platform", platform);
        for (Map.Entry<Object, Object> e : getConfigProperties(platform, hub).entrySet()) {
            capabilities.setCapability(e.getKey().toString(), e.getValue());
        }
        return capabilities;
    }

    private static Properties getConfigProperties(String platform, String hub) {
        String file = CapabilitiesConfig.class.getClassLoader().getResource("/%s/%s.properties" .formatted(platform, hub)).getFile();
        Properties properties = new Properties();

        try (FileInputStream stream = new FileInputStream(file)) {
            properties.load(stream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }
}
