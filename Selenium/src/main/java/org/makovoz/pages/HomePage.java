package org.makovoz.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public final class HomePage extends BasePage<HomePage> {

    public HomePage() {
        super();
    }

    @FindBy(css = ".card")
    private List<WebElement> productCards;

    private List<ProductCard> getProductCards() {
        wait.until(ExpectedConditions.visibilityOfAllElements(productCards));
        return productCards.stream().map(ProductCard::new).toList();
    }

    public ProductDetailsPage openProductDetailsPage(final String productName) {
        return getProductCards()
                .stream().filter(card -> card.getName().equals(productName))
                .findFirst()
                .orElseThrow()
                .open();
    }

    public Header getHeader() {
        return new Header();
    }
}
