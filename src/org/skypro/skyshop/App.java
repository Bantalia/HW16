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

import java.util.Comparator;
import java.util.*;


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

        // Добавляем продукты
        engine.addProduct(new SimpleProduct("Яблоко", 50));
        engine.addProduct(new DiscountedProduct("Хлеб", 30, 20));
        engine.addProduct(new FixPriceProduct("Молоко"));
        engine.addProduct(new FixPriceProduct("Молоко")); // дубликат по имени, не добавится


        // Поиск по тексту "продукт"
        Set<Searchable> resultsProduct = engine.search("Хлеб");
        System.out.println("Результаты поиска по 'продукт':");
        for (Searchable s : resultsProduct) {
            // Печать через toString без вывода имени из Searchable (имя есть в toString)
            System.out.println(s);
        }

        System.out.println();

        // Поиск по тексту "статья"
        Set<Searchable> resultsArticle = engine.search("Молоко");
        System.out.println("Результаты поиска по 'статья':");
        for (Searchable s : resultsArticle) {
            System.out.println(s);
        }
    }
}


