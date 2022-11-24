package org.makovoz.driver;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public abstract class DriverManager {
    protected AppiumDriver driver;
    protected DesiredCapabilities capabilities;
    protected URL url;

    protected DriverManager(DesiredCapabilities capabilities, URL url) {
        this.capabilities = capabilities;
        this.url = url;
    }

    protected abstract void createDriver();

    public AppiumDriver getDriver() {
        if (null == driver) {
            createDriver();
        }
        return driver;
    }
}
