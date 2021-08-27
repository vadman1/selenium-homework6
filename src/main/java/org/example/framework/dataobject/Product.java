package org.example.framework.dataobject;

public class Product {

    private String name;
    private int price;

    // общий счётчик продуктов
    private static int countProduct = 0;


    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public static int getCountProduct() {
        return countProduct;
    }

    public static void setCountProduct(int countProduct) {
        Product.countProduct = countProduct;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
