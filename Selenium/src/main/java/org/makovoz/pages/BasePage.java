package org.makovoz.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.makovoz.driver.DriverManagerFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage<T> {
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    public T navigateBack() {
        driver.navigate().back();
        return (T) this;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void initDriver() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        driver = DriverManagerFactory.getManager(DriverManagerType.CHROME).getDriver();
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(2))
                .pageLoadTimeout(Duration.ofSeconds(2));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected BasePage() {
        PageFactory.initElements(driver, this);
    }

    protected BasePage(WebElement searchContext) {
        PageFactory.initElements(new DefaultElementLocatorFactory(searchContext), this);
    }

    protected void waitForPageToLoad() {
        wait.until(dr -> ((JavascriptExecutor) dr).executeScript("return document.readyState").toString().equals("complete"));
    }

}
