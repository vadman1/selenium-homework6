package org.example.framework.steps;

import io.cucumber.java.ru.И;
import org.example.framework.managers.PageManager;

public class HomePageSteps {

    PageManager pageManager = PageManager.getPageManager();

    @И("^Выполнить поиск \"(.+)\"$")
    public void searchProduct(String productName) {
        pageManager.getHomePage().searchProduct(productName);
    }
}
