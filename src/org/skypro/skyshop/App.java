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

import java.util.ArrayList;
import java.util.List;


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
        basket.add(apple);
        basket.add(bread);
        basket.add(milk);
        basket.add(cheese);
        basket.add(butter);
        basket.add(orange);
        basket.add(apple);

        System.out.println("Перед удалением:");
        basket.printBasket();

// Удаляем существующие яблоки ("Яблоко")
        List<Product> deletedProducts = basket.removeByName("Яблоко");
        System.out.println("\\nУдалены продукты:");
        for (Product p : deletedProducts) {
            System.out.println(p.toString());
        }

        System.out.println("\\nПосле удаления Apple:");
        basket.printBasket();

        // Проверяем удаление несуществующего продукта
        deletedProducts.clear();
        deletedProducts = basket.removeByName("Melon"); // Нет в корзине
        if (deletedProducts.isEmpty()) {
            System.out.println("\\nСписок удалённых продуктов пуст.");
        }

        System.out.println("\\nФинальное состояние корзины:");
        basket.printBasket();


        // Поиск (SearchEngine)
        // Добавляем товары в поисковик
        SearchEngine engine = new SearchEngine();
        engine.addToCatalog(new Product("Яблоко"));
        engine.addToCatalog(new Product("Хлеб"));
        engine.addToCatalog(new Product("Молоко"));
        engine.addToCatalog(new Product("Масло"));

// Поиск всех подходящих товаров
        System.out.println("\nРезультаты поиска по запросу 'Молоко':");
        List<Product> foundProducts = engine.search("Молоко");
        for (Product p : foundProducts) {
            System.out.println(p.toString());
        }

    }
}

