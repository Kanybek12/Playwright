package com.example.tests;

import com.example.TestBase;
import com.example.pages.HomePage;
import com.example.pages.LoginPage;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeTest extends TestBase {
    @Test
    void shouldDisplayInventoryItems() {
        // Логин
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigate();
        loginPage.login("standard_user", "secret_sauce");

        // Тестирование страницы инвентаря
        HomePage inventoryPage = new HomePage(page);

        String pageTitle = page.locator(".product_label").textContent();
        assertEquals("Products", pageTitle.trim());

        assertEquals("Products", inventoryPage.getPageTitle());
           assertTrue(inventoryPage.getItemCount() > 0, "На странице должны быть товары");

        page.waitForTimeout(5000);
        inventoryPage.addFirstItemToCart();
        page.waitForTimeout(5000);
        assertEquals("REMOVE", inventoryPage.getFirstButtonText());
        assertEquals("1", inventoryPage.getCartBadgeText());
        System.out.println(inventoryPage.getFirstItemPrice());
   //     inventoryPage.addAllItemsToCartAlternative();

        page.waitForTimeout(5000);
    }
}