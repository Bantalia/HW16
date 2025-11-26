package org.skypro.skyshop.product;
import org.skypro.skyshop.searchable.Searchable;

public  class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(String name, int price) {
        super(name);
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return name + ": " + price;
    }
}


