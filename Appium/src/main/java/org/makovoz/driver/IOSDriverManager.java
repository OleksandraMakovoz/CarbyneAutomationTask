package org.makovoz.driver;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class IOSDriverManager extends DriverManager {
    public IOSDriverManager(DesiredCapabilities capabilities, URL url) {
        super(capabilities, url);
    }

    @Override
    protected void createDriver() {
        driver = new IOSDriver(url, capabilities);
    }
}
