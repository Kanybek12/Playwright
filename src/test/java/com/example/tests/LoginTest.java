package com.example.tests;

import com.example.TestBase;
import com.example.pages.LoginPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends TestBase {
    @Test
    void shouldLoginSuccessfully() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigate();
        loginPage.login("standard_user", "secret_sauce");
        page.waitForTimeout(5000);
        assertTrue(loginPage.isLoggedIn());
    }
}
