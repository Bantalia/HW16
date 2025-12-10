package org.skypro.skyshop.product;
import org.skypro.skyshop.searchable.Searchable;

public  class FixPriceProduct extends Product {
    private static final int FIXED_PRICE = 100; // пример фиксированной цены

    public FixPriceProduct(String name) {
        super(name);
    }


    @Override
    public String toString() {
        return name + ": Фиксированная цена " + FIXED_PRICE;
    }
}