package org.skypro.skyshop.product;

import org.skypro.skyshop.searchable.Searchable;

public abstract class Product implements Searchable {
    protected String name;


    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getSearchTerm() {
        return name;  // search term — имя продукта
    }

    @Override
    public String getType() {
        return "PRODUCT";
    }


    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public abstract String toString();
}

