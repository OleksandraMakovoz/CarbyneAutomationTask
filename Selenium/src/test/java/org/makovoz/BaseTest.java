package org.makovoz;

import org.makovoz.pages.BasePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    static {
        BasePage.initDriver();
    }

    @BeforeMethod
    public void openHomePage() {
        BasePage.getDriver().get("https://www.demoblaze.com/");
    }

    @AfterMethod
    public void tearDownDriver() {
        BasePage.getDriver().quit();
    }
}
