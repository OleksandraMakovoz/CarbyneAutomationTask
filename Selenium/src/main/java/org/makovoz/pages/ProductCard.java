package org.makovoz.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public final class ProductCard extends BasePage {

    public ProductCard(WebElement container) {
        super(container);
    }

    @FindBy(css = "a.hrefch")
    private WebElement name;

    public String getName() {
        return name.getText();
    }

    public ProductDetailsPage open() {
        name.click();
        return new ProductDetailsPage();
    }
}
