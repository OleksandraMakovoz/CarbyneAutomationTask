package org.makovoz.driver;

import org.makovoz.config.CapabilitiesConfig;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public final class DriverManagerFactory {
    private DriverManagerFactory() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    public static DriverManager getManager(DriverType type, String hub, URL url) {
        DesiredCapabilities capabilities = CapabilitiesConfig.getCapabilities(type.name(), hub);
        return switch (type) {
            case ANDROID -> new AndroidDriverManager(capabilities, url);
            case IOS -> new IOSDriverManager(capabilities, url);
        };
    }

}
