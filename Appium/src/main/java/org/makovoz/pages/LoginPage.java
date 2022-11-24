package org.makovoz.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.makovoz.entity.User;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    @iOSXCUITFindBy(id = "login")
    @AndroidFindBy(className = "[test-locator='login']")
    private WebElement loginInput;

    @iOSXCUITFindBy(id = "pass")
    @AndroidFindBy(className = "[test-locator='pass']")
    private WebElement passwordInput;

    @iOSXCUITFindBy(id = "pass")
    @AndroidFindBy(className = "[test-locator='pass']")
    private WebElement loginButton;

    public HomeScreen login(User user) {
        return setLogin(user.getLogin())
                .setPassword(user.getPassword())
                .clickLoginButton();
    }

    public LoginPage setLogin(String login) {
        loginInput.sendKeys(login);
        return this;
    }

    public LoginPage setPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public HomeScreen clickLoginButton() {
        loginButton.click();
        return new HomeScreen();
    }
}
