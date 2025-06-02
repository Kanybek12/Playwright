package com.example.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePage{
    private final Page page;

    public HomePage(Page page) {
        this.page = page;
    }
    public String getPageTitle() {
        return page.locator(".product_label").textContent().trim();
    }

    public int getItemCount() {
        return page.locator(".inventory_item").count();
    }

    public String getFirstItemPrice() {
        return page.locator(".inventory_item_price").first().textContent();
    }

    public void addFirstItemToCart() {
        page.locator("button:has-text('ADD TO CART')").first().click();

    }// Get all prices
    public void addAllItemsToCartAlternative() {
        page.locator("button:has-text('ADD TO CART')").all()
                .forEach(Locator::click);
    }

    public String getFirstButtonText() {
        return page.locator("button:has-text('REMOVE')").first().textContent().trim();
    }

    public String getCartBadgeText() {
        return page.locator(".shopping_cart_badge").textContent();
    }
}
