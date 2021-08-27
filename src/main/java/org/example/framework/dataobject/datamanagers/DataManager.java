package org.example.framework.dataobject.datamanagers;

import org.example.framework.dataobject.Product;

import java.util.ArrayList;
import java.util.List;

public class DataManager {

    private List<Product> productList = new ArrayList<>();

    public List<Product> getProductList() {
        return productList;
    }

    private static DataManager INSTANCE = null;

    private DataManager() {
    }

    /**
     * Ленивая инициализация DataManager
     *
     * @return DataManager
     */
    public static DataManager getDataManager() {
        if (INSTANCE == null) {
            INSTANCE = new DataManager();
        }
        return INSTANCE;
    }

}
