package org.makovoz.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class HomeScreen extends BasePage {

    @iOSXCUITFindBy(id = "user_name")
    @AndroidFindBy(className = "[test-locator='user']")
    private WebElement username;


    public String getAuthorizedUser() {
        return username.getText();
    }
}
