package org.example.framework.steps;

import io.cucumber.java.ru.И;
import org.example.framework.managers.PageManager;


public class CartPageSteps {
    PageManager pageManager = PageManager.getPageManager();

    @И("^Проверяем открытие страницы корзины$")
    public void checkCartPageOpen() {
        pageManager.getCartPage().checkCartPageOpen();
    }

    @И("^Проверяем наличие ранее добавленных товаров в корзине$")
    public void checkProductInCart(){
        pageManager.getCartPage().checkProductInCart();
    }

    @И("^Проверяем количество товаров в корзине$")
    public void checkQuantityInCart() {
        pageManager.getCartPage().checkQuantityInCart();
    }

    @И("^Удаляем все товары из корзины$")
    public void deleteAllProductFromCart() {
        pageManager.getCartPage().deleteAllProductFromCart();
    }

    @И("^Проверяем, что корзина пуста$")
    public void checkCartIsEmpty() {
        pageManager.getCartPage().checkCartIsEmpty();
    }
}
