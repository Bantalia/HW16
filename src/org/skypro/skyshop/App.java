package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {
        System.out.println("Интернет-магазин!");

        ProductBasket basket = new ProductBasket();

        // Создаем продукты
        Product apple = new Product("Яблоко", 50,5);
        Product bread = new Product("Хлеб", 30,1);
        Product milk = new Product("Молоко", 70,2);
        Product cheese = new Product("Сыр", 100,200);
        Product butter = new Product("Масло", 80,3);
        Product orange = new Product("Апельсин", 60,4);

        // Добавляем продукты в корзину
        basket.addProduct(apple);
        basket.addProduct(bread);
        basket.addProduct(milk);
        basket.addProduct(cheese);
        basket.addProduct(butter);

        // Попытка добавить продукт в заполненную корзину
        basket.addProduct(orange);  // Выведет "Невозможно добавить продукт"

        // Печать содержимого корзины
        basket.printProducts();

        // Получение стоимости корзины
        System.out.println("Общая стоимость: " + basket.getTotalPrice());

        // Поиск товара, который есть в корзине
        System.out.println("Есть ли хлеб? " + basket.containsProduct("Хлеб"));

        // Поиск товара, которого нет в корзине
        System.out.println("Есть ли апельсин? " + basket.containsProduct("Апельсин"));

        // Очистка корзины
        basket.clear();

        // Печать пустой корзины
        basket.printProducts();

        // Получение стоимости пустой корзины
        System.out.println("Общая стоимость: " + basket.getTotalPrice());

        // Поиск товара в пустой корзине
        System.out.println("Есть ли хлеб? " + basket.containsProduct("Хлеб"));
    }
}


