package org.example.framework.pages;


import org.example.framework.dataobject.Product;
import org.example.framework.dataobject.datamanagers.DataManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


/**
 * Страница с результатами поиска
 */
public class ResultSearchPage extends BasePage {

    @FindBy(xpath = "//div[@data-widget='searchResultsFiltersActive']")
    private WebElement filters;

    @FindBy(xpath = "//div[@data-widget='fulltextResultsHeader']")
    private WebElement resultHeader;

    @FindBy(xpath = "//div[contains(text(), 'Цена')]/..//input[@qa-id='range-to']")
    private WebElement inputPriceRangeTo;

    @FindBy(xpath = "//div[@value='Высокий рейтинг']")
    private WebElement highRate;

    @FindBy(xpath = "//span[contains(text(), 'NFC')]/../..//input/..")
    private WebElement checkNFC;

    @FindBy(xpath = "//span[contains(text(), 'Bluetooth')]/../..//input/..")
    private WebElement checkBluetooth;

    @FindBy(xpath = "//span[contains(text(), 'Wi-Fi')]/../..//input/..")
    private WebElement checkWIFI;

    @FindBy(xpath = "//div[@data-widget='searchResultsV2']/div/div")
    private List<WebElement> listProduct;

    @FindBy(xpath = "//a[contains(@href, '/cart')]/span[contains(@class, 'f-caption--bold')]")
    private WebElement cartQuantity;

    @FindBy(xpath = "//a[contains(@href, '/cart')]")
    private WebElement cartLink;

    public ResultSearchPage checkOpenResultSearchPage() {
        waitUtilElementToBeVisible(resultHeader);

        return this;
    }

    public ResultSearchPage selectPriceRangeTo(String priceRangeTo) {

        inputPriceRangeTo.sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        fillInputField(inputPriceRangeTo, priceRangeTo);
        inputPriceRangeTo.sendKeys(Keys.ENTER);

        WebElement filter = filters.findElement(By.xpath(".//span[contains(text(), 'до')]"));
        waitUtilElementToBeVisible(filter);

        Assertions.assertEquals(priceRangeTo, inputPriceRangeTo.getAttribute("value"),
                "Верхний потолок цены заполнен неверно");

        return this;
    }

    public ResultSearchPage clickHighRate() {
        highRate.click();

        WebElement filterHighRate = filters.findElement(By.xpath(".//span[contains(text(), 'Высокий рейтинг')]"));
        waitUtilElementToBeVisible(filterHighRate);

        return this;
    }

    public ResultSearchPage selectWirelessInterfaces(String nameInterface) {

        switch (nameInterface) {
            case "NFC":
                scrollWithOffset(checkNFC, 0, -150);
                checkNFC.click();
                waitUtilElementToBeVisible(filters.findElement(By.xpath(".//span[contains(text(), 'NFC')]")));
                break;
            case "bluetooth":
                scrollWithOffset(checkBluetooth, 0, -150);
                checkBluetooth.click();
                waitUtilElementToBeVisible(filters.findElement(By.xpath(".//span[contains(text(), 'Bluetooth')]")));
                break;
            case "wifi":
                scrollWithOffset(checkWIFI, 0, -150);
                checkWIFI.click();
                waitUtilElementToBeVisible(filters.findElement(By.xpath(".//span[contains(text(), 'Wi-Fi')]")));
                break;
            default:
                Assertions.fail("Беспроводной интерфейс с названием '" + nameInterface + "' отсутствует на странице");
        }
        return this;
    }

    public ResultSearchPage addToCartEvenProduct(int countProduct) {

        while(true) {
            for(int i = 1; i < listProduct.size(); i += 2) {
                WebElement buttonBuy = addToCart(listProduct.get(i));
                if(buttonBuy != null){
                    scrollWithOffset(buttonBuy, 0, -150);
                    buttonBuy.click();
                    Product.setCountProduct(Product.getCountProduct() + 1);
                    wait.until(ExpectedConditions.
                            textToBePresentInElement(cartQuantity, Product.getCountProduct() + ""));
                    addProductToList(listProduct.get(i));
                }
                if(DataManager.getDataManager().getProductList().size() == countProduct) {
                    return this;
                }
            }
            try {
                WebElement nextBtn = driverManager.getDriver().findElement(By
                        .xpath("//div[(contains(text(), 'Дальше'))]/../../."));
                nextBtn.click();
            }
            catch(NoSuchElementException e) {
                break;
            }
        }

        return this;
    }


    private WebElement addToCart(WebElement element) {
        WebElement elementBtn;
        try {
            elementBtn = element.findElement
                    (By.xpath(".//*[contains(text(), 'доставит') or contains(text(), 'Доставит')]/../..//button"));
        } catch (NoSuchElementException e) {
            return null;
        }

        return elementBtn;
    }

    private void addProductToList(WebElement element) {
        WebElement productName = element.findElement(By
                .xpath(".//div[contains(@style, 'max-width: 50')]//a[not(contains(text(), 'отзыв'))]/span/span"));
        WebElement productPrice = element.findElement(By
                .xpath(".//div[3]//span[@style='color: rgb(249, 17, 85);' or @style='color: rgb(0, 26, 52);'][1]"));
        int price = Integer.parseInt(productPrice.getText().replaceAll("[^\\d.]", ""));

        Product product = new Product(productName.getText(), price);
        DataManager.getDataManager().getProductList().add(product);

    }

    public ResultSearchPage printListProduct() {
        for(Product product : DataManager.getDataManager().getProductList()) {
            System.out.println(product);
        }

        return this;
    }

    public CartPage goToCart() {
        cartLink.click();

        return pageManager.getCartPage();
    }
}
