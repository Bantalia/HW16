package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.searchable.BestResultNotFound;
import org.skypro.skyshop.searchable.SearchEngine;
import org.skypro.skyshop.searchable.Searchable;

import java.util.*;
import java.util.stream.Collectors;


public class App {
    public static void main(String[] args) {
        System.out.println("Интернет-магазин!");

        ProductBasket basket = new ProductBasket();

        // Создаем продукты

        Product apple = new SimpleProduct("Яблоко", 50);
        Product bread = new DiscountedProduct("Хлеб", 30, 20);
        Product milk = new FixPriceProduct("Молоко");
        Product cheese = new DiscountedProduct("Сыр", 100, 20);
        Product butter = new FixPriceProduct("Масло");
        Product orange = new SimpleProduct("Апельсин", 60);

        // Добавляем продукты в корзину
        basket.add(new SimpleProduct("Яблоко", 50));
        basket.add(new DiscountedProduct("Хлеб", 30, 20));
        basket.add(new FixPriceProduct("Молоко"));
        basket.add(new DiscountedProduct("Сыр", 100, 20));
        basket.add(new FixPriceProduct("Масло"));
        basket.add(new SimpleProduct("Апельсин", 60));
        // Дублирование товара
        basket.add(new SimpleProduct("Яблоко", 80));
        basket.add(new DiscountedProduct("Хлеб", 50, 0));
        basket.add(new SimpleProduct("Апельсин", 100));

        // Поиск и сортировка
        SearchEngine engine = new SearchEngine();
        List<Searchable> allItems = new ArrayList<>(basket.listAllProducts().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList()));

        TreeMap<String, Searchable> sortedResult = engine.search(allItems);

        // Печать отсортированного результата
        for (var entry : sortedResult.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}


