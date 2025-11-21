package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.basket.ProductBasket;

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
        basket.addProduct(apple);
        basket.addProduct(bread);
        basket.addProduct(milk);
        basket.addProduct(cheese);
        basket.addProduct(butter);

        // Попытка добавить продукт в заполненную корзину
        basket.addProduct(orange);  // Выведет "Невозможно добавить продукт"

        // Печать содержимого корзины
        basket.printReceipt();

    }
}


