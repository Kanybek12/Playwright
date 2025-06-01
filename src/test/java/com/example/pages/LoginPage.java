package com.example.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    private final Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    public void navigate() {
        page.navigate("https://saucedemo.com/v1/index.html");
    }

    public void login(String username, String password) {
        page.fill("#user-name", username);
        page.fill("#password", password);
        page.click("#login-button");
    }

    public boolean isLoggedIn() {
        try {
            // Wait up to 10 seconds for the element to appear
            return page.waitForSelector(".product_label",
                    new Page.WaitForSelectorOptions().setTimeout(10000) // 10 seconds
            ).isVisible();
        } catch (Exception e) {
            return false; // Return false if element doesn't appear within timeout
        }
    }
}
