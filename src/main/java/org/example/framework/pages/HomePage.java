package org.example.framework.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Стартовая страница приложения
 */
public class HomePage extends BasePage{

    @FindBy(xpath = "//input[@placeholder='Искать на Ozon']")
    private WebElement inputSearch;


    public ResultSearchPage searchProduct(String productName) {

        inputSearch.click();
        inputSearch.sendKeys(productName);
        inputSearch.sendKeys(Keys.ENTER);

        return pageManager.getResultSearchPage();
    }

}
