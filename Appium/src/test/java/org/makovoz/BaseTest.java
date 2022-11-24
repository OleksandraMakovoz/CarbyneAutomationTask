package org.makovoz;

import org.makovoz.driver.DriverType;
import org.makovoz.pages.BasePage;
import org.makovoz.service.AppiumService;
import org.testng.annotations.AfterSuite;

import java.net.MalformedURLException;
import java.net.URL;

import static org.makovoz.config.ProjectProperties.CAPABILITIES;
import static org.makovoz.config.ProjectProperties.PLATFORM;

public abstract class BaseTest {

    static {
        try {
            BasePage.initDriver(DriverType.valueOf(PLATFORM), CAPABILITIES, new URL(AppiumService.SERVICE.getUrl()));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }


    @AfterSuite
    public void tearDown() {

        AppiumService.SERVICE.stop();
    }
}
