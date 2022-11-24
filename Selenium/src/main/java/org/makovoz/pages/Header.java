package org.makovoz.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public final class Header extends BasePage<Header> {
    public Header() {
        super();
    }

    @FindAll({
            @FindBy(id = "cartur"),
            @FindBy(css = "a[onclick='showcart()']")})
    private WebElement cart;

    public Cart openCart() {
        wait.until(visibilityOf(cart)).click();
        return new Cart();
    }
}
