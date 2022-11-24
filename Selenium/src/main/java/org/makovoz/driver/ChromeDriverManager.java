package org.makovoz.driver;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {

    @Override
    protected void createDriver() {
        driver = new ChromeDriver();
    }
}
