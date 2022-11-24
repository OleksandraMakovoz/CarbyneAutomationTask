package org.makovoz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ProductInCart extends BasePage {
    public ProductInCart(WebElement context) {
        super(context);
    }

    @FindBy(css = "a[onclick^='deleteItem']")
    private WebElement deleteButton;

    @FindBy(css = "td:nth-child(2)")
    private WebElement title;

    public void deleteProduct() throws InterruptedException {
        wait.until(visibilityOf(deleteButton)).click();
        waitForPageToLoad();
        TimeUnit.SECONDS.sleep(1);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".")));
    }
}
