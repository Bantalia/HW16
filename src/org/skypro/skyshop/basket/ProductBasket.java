package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> products = new HashMap<>();

    // Метод добавления товара в корзину
    public void add(Product product) {
        String name = product.getName();
        products.computeIfAbsent(name, k -> new ArrayList<>()).add(product);
    }


    // Метод удаления товара по имени
    public void removeProduct(String name) {
        products.remove(name);
    }

    // Получение товаров по имени
    public List<Product> getProductsByName(String name) {
        return products.getOrDefault(name, Collections.emptyList());
    }

    public Collection<List<Product>> listAllProducts() {
        return products.values();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (var entry : products.entrySet()) {
            var key = entry.getKey();  // Имя товара
            var value = entry.getValue();  // Список товаров с данным именем

            sb.append(key + ": ");
            for (Product p : value) {
                sb.append(p.toString() + ", ");
            }
        }
        return sb.toString();
    }
}

