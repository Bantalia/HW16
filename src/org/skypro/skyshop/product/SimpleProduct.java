package org.skypro.skyshop.product;
import org.skypro.skyshop.searchable.Searchable;

public  class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(String name, int price) {
        super(name); // вызывает конструктор родительского класса
        if(price <= 0) { // Цена должна быть строго больше нуля
            throw new IllegalArgumentException("Цена продукта должна быть положительной величиной.");
        }

        this.price = price;
    }


    @Override
    public int getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return name + ": " + price;
    }
}


