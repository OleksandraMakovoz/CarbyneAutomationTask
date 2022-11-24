package org.makovoz.driver;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class AndroidDriverManager extends DriverManager {
    public AndroidDriverManager(DesiredCapabilities capabilities, URL url) {
        super(capabilities, url);
    }

    @Override protected void createDriver() {
        driver = new AndroidDriver(url, capabilities);
    }
}
