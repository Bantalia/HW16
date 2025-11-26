package org.skypro.skyshop.product;

import org.skypro.skyshop.searchable.Searchable;

public class DiscountedProduct extends Product {
    private int basePrice;
    private int discountPercent; // 0..100
    public DiscountedProduct(String name, int basePrice, int discountPercent) {
        super(name);
        this.basePrice = basePrice;
        this.discountPercent = discountPercent;
    }
    @Override
    public int getPrice() {
        return basePrice * (100 - discountPercent) / 100;
    }
    @Override
    public boolean isSpecial() {
        return true;
    }
    @Override
    public String toString() {
        return name + ": " + getPrice() + " (" + discountPercent + "%)";
    }
}