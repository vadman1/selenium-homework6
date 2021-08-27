package org.example.framework.tests;


import org.example.framework.basetestclass.BaseTests;
import org.junit.jupiter.api.Test;


public class FirstTest extends BaseTests {


    @Test
    public void startTest() {

        app.getHomePage()
                .searchProduct("iphone")
                .checkOpenResultSearchPage()
                .selectPriceRangeTo("100000")
                .clickHighRate()
                .selectWirelessInterfaces("NFC")
                .addToCartEvenProduct(8)
                .goToCart()
                .checkCartPageOpen()
                .checkProductInCart()
                .checkQuantityInCart()
                .deleteAllProductFromCart()
                .checkCartIsEmpty();
    }
}
