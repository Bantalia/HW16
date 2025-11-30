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

        SearchEngine searchEngine = new SearchEngine(10);

        ProductBasket basket = new ProductBasket();


        // Создаем продукты

        Product apple = new SimpleProduct("Яблоко", 50);
        Product bread = new DiscountedProduct("Хлеб", 30, 20);
        Product milk = new FixPriceProduct("Молоко");
        Product cheese = new DiscountedProduct("Сыр", 100, 20);
        Product butter = new FixPriceProduct("Масло");
        Product orange = new SimpleProduct("Апельсин", 60);


        // Добавляем продукты в корзину
        basket.addProduct(apple);
        basket.addProduct(bread);
        basket.addProduct(milk);
        basket.addProduct(cheese);
        basket.addProduct(butter);
        basket.addProduct(orange);

// Тестируем ошибку
        try {
            Product meet = new DiscountedProduct("Мясо", -100, 30);
            System.out.println("Добавлен продукт " + meet);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка у продукта " + e.getMessage());
        }
        try {
            Product juice = new SimpleProduct(" ", -100);
            System.out.println("Добавлен продукт " + juice);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка у продукта " + e.getMessage());
        }

        try {
            // Тестируем ошибку с ценой
            SimpleProduct simpleProduct = new SimpleProduct("Яблоко", 0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Ожидаемый вывод: Цена продукта должна быть положительной величиной.
        }

        try {
            // Тестируем ошибку с неправильной скидкой
            DiscountedProduct discountedProduct = new DiscountedProduct("Сыр", 100, 150);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Ожидаемый вывод: Процент скидки должен находиться в пределах от 0 до 100 включительно.
        }


        // Попытка добавить продукт в заполненную корзину
        basket.addProduct(orange);  // Выведет "Невозможно добавить продукт"

        // Печать содержимого корзины
        basket.printReceipt();

        // Добавляем продукты в поисковик

        searchEngine.add(apple);
        searchEngine.add(bread);
        searchEngine.add(milk);
        searchEngine.add(cheese);
        searchEngine.add(butter);
        searchEngine.add(orange);


        //Создаем статьи

        Article a1 = new Article("Страна производитель", "Казахстан ");
        Article a2 = new Article("Страна производитель", "Россия ");
        Article a3 = new Article("Страна производитель", "Турция");
        Article a4 = new Article("Страна производитель", "Белорусия");
        Article a5 = new Article("Страна производитель", "США");
        Article a6 = new Article("Страна производитель", "Китай");

        // Добавляем статьи в поисковик

        searchEngine.add(a1);
        searchEngine.add(a2);
        searchEngine.add(a3);
        searchEngine.add(a4);
        searchEngine.add(a5);
        searchEngine.add(a6);


        // Поиск


        searchAndPrint(searchEngine, "Яблоко");
        searchAndPrint(searchEngine, "Хлеб");
        searchAndPrint(searchEngine, "Молоко");
        searchAndPrint(searchEngine, "Сыр");
        searchAndPrint(searchEngine, "Масло");
        searchAndPrint(searchEngine, "Апельсин");
        searchAndPrint(searchEngine, "Гвозди"); // ничего не найдется
    }

    private static void searchAndPrint(SearchEngine engine, String query) {
        System.out.println("Поиск по запросу: \"" + query + "\"");
        Searchable[] results = engine.search(query);
        boolean foundAny = false;
        for (Searchable s : results) {
            if (s != null) {
                System.out.println(s.getStringRepresentation());
                foundAny = true;
            }
        }
        if (!foundAny) {
            System.out.println("Результатов не найдено");
        }
        System.out.println();


// Создаём список для поиска
        ArrayList<Searchable> productList = new ArrayList<>();
        productList.add (new SimpleProduct("Яблоко", 50));
        productList.add (new DiscountedProduct("Хлеб", 30, 20));
        productList.add (new FixPriceProduct("Молоко"));
        productList.add (new DiscountedProduct("Сыр", 100, 20));
        productList.add (new FixPriceProduct("Масло"));
        productList.add (new SimpleProduct("Апельсин", 60));

        SearchEngine searchEngine = new SearchEngine (productList);

        // 1) Поиск с успешным результатом
        try {
            Searchable found = searchEngine.findBestMatch("Мол");
            System.out.println("Найден лучший объект: " + found.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка поиска: " + e.getMessage());
        }

        // 2) Поиск без результатов - вызовет исключение
        try {
            Searchable found = searchEngine.findBestMatch("Йогурт");
            System.out.println("Найден лучший объект: " + found.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка поиска: " + e.getMessage());
        }
    }
}

