package org.makovoz.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public final class Cart extends BasePage<Cart> {
    public Cart() {
        super();
    }

    @FindBy(id = "totalp")
    private WebElement total;

    @FindBy(css = "tr.success")
    private List<WebElement> products;

    public Deque<ProductInCart> getProducts() {
        wait.until(ExpectedConditions.visibilityOfAllElements(products));
        return products.stream().map(ProductInCart::new).collect(Collectors.toCollection(LinkedList::new));
    }

    public int getTotal() {
        return Integer.parseInt(wait.until(visibilityOf(total)).getText());
    }

    public int getProductsCount() {
        return products.size();
    }
}
