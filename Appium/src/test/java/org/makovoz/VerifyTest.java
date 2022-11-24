package org.makovoz;

import org.makovoz.entity.User;
import org.makovoz.pages.LoginPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class VerifyTest extends BaseTest {
    private final LoginPage loginPage = new LoginPage();

    @Test
    public void login() {
        User user = User.builder()
                .login("login")
                .password("pass").build();
        String actual = loginPage.login(user).getAuthorizedUser();

        assertEquals(actual, user.getLogin());
    }
}
