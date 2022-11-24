package org.makovoz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public final class ProductDetailsPage extends BasePage<ProductDetailsPage> {
    @FindBy(css = "a.btn.btn-success")
    private WebElement addToCartButton;

    @FindBy(css = ".price-container")
    private WebElement price;

    public int getPrice() {
        String small = wait.until(visibilityOf(price)).findElement(By.cssSelector("small")).getText();
        return Integer.parseInt(price.getText().replace(small, "").replace("$", "").trim());
    }

    public ProductDetailsPage addProductToCart() {
        wait.until(visibilityOf(addToCartButton)).click();
        wait.until(alertIsPresent()).accept();
        return this;
    }
}
