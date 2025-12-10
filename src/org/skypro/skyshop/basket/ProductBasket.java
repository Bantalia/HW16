package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class ProductBasket {
    private List<Product> products = new ArrayList<>();

    // Метод добавления товара в корзину
    public void add(Product product) {
        this.products.add(product);
    }

    public List<Product> removeByName(String name) {
        List<Product> removed = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                removed.add(product);
                iterator.remove();
            }
        }
        return removed;
    }

    // Метод вывода содержимого корзины
    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("Корзина пустая");
            return;
        }
        System.out.println("Текущие товары в корзине:");
        for (Product p : products) {
            System.out.println(p.toString());
        }
    }

}

