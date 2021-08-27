package org.example.framework.pages;

import org.example.framework.dataobject.Product;
import org.example.framework.dataobject.datamanagers.DataManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.catalog.Catalog;
import java.util.List;

public class CartPage extends BasePage{

    @FindBy(xpath = "//div[contains(text(),'Корзина')]")
    private WebElement cartTitle;

    @FindBy(xpath = "//div[@id='split-Main-0']/div/div/a/span")
    private List<WebElement> cartProductList;

    @FindBy(xpath = "//div[@class='b4k5']")
    private WebElement cartQuantityOnPage;

    @FindBy(xpath = "//span[contains(text(), 'Удалить выбранные')]")
    private WebElement btnDeleteSelected;

    @FindBy(xpath = "//div[contains(text(), 'Удалить')]")
    private WebElement btnConfirmDelete;

    @FindBy(xpath = "//h1[contains(text(), 'Корзина пуста')]")
    private WebElement titleCartIsEmpty;

    public CartPage checkCartPageOpen() {
        waitUtilElementToBeVisible(cartTitle);
        Assertions.assertTrue(cartTitle.getText().equals("Корзина"), "Мы не в корзине");

        return this;
    }

    public CartPage checkProductInCart(){
        List<Product> productList = DataManager.getDataManager().getProductList();
        StringBuilder productNameToString = new StringBuilder();
        for(Product product : productList) {
            productNameToString.append(product.getName()).append(" ");
        }

        for(WebElement cartProduct : cartProductList) {
            Assertions.assertTrue(productNameToString.toString().contains(cartProduct.getText()),
                    "Товар с названием " + cartProduct.getText() + " не найден в списке productNameToString");
        }

        return this;
    }

    public CartPage checkQuantityInCart() {
        String cartQuantity = cartQuantityOnPage.getText().trim();

        Assertions.assertTrue(Product.getCountProduct() == Integer.parseInt(cartQuantity) ,
                "Количество товара на странице и в переменной countProduct не совпадает");

        return this;
    }

    public CartPage deleteAllProductFromCart() {
        btnDeleteSelected.click();
        waitUtilElementToBeClickable(btnConfirmDelete).click();
        waitUtilElementToBeVisible(titleCartIsEmpty);

        return this;
    }

    public CartPage checkCartIsEmpty() {
        Assertions.assertTrue(titleCartIsEmpty.getText().contains("Корзина пуста"),
                "Корзина не пуста");

        return this;
    }
}
