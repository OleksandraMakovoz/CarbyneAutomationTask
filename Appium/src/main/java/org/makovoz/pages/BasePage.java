package org.makovoz.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.makovoz.driver.DriverManagerFactory;
import org.makovoz.driver.DriverType;
import org.openqa.selenium.support.PageFactory;

import java.net.URL;
import java.time.Duration;

public abstract class BasePage {
    @Getter
    protected static AppiumDriver driver;


    public static void initDriver(DriverType type, String hub, URL url) {
        driver = DriverManagerFactory.getManager(type, hub, url).getDriver();
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(2))
                .pageLoadTimeout(Duration.ofSeconds(2));
    }



    protected BasePage() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

}
