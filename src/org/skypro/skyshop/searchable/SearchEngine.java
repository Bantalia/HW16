package org.skypro.skyshop.searchable;

import org.skypro.skyshop.product.Product;

import java.util.List;
import java.util.ArrayList;

public class SearchEngine {
    private List<Product> catalog = new ArrayList<>();

    // Метод для добавления продукта в каталог
    public void addToCatalog(Product product) {
        catalog.add(product);
    }

    // Обновленный метод поиска
    public List<Product> search(String keyword) {
        List<Product> results = new ArrayList<>();
        for (Product p : catalog) {
            if (p.getName().contains(keyword)) { // Простое условие поиска по части названия
                results.add(p);
            }
        }
        return results;
    }

}
