package org.example.framework.steps;

import io.cucumber.java.ru.И;
import org.example.framework.managers.PageManager;


public class ResultSearchPageSteps {

    PageManager pageManager = PageManager.getPageManager();

    @И("^Ограничить цену до \"(.+)\"$")
    public void selectPriceRangeTo(String priceRangeTo) {
        pageManager.getResultSearchPage().selectPriceRangeTo(priceRangeTo);
    }

    @И("Отметить чекбокс - Высокий рейтинг")
    public void clickHighRate() {
        pageManager.getResultSearchPage().clickHighRate();
    }

    @И("^Отметить чекбокс - \"(.+)\"$")
    public void selectWirelessInterfaces(String nameInterface) {
        pageManager.getResultSearchPage().selectWirelessInterfaces(nameInterface);
    }

    @И("^Выбираем \"(.+)\" четных товаров$")
    public void addToCartEvenProduct(int countProduct) {
        pageManager.getResultSearchPage().addToCartEvenProduct(countProduct);
    }

    @И("^Переходим в корзину$")
    public void goToCart() {
        pageManager.getResultSearchPage().goToCart();
    }
}
