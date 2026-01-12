package org.skypro.skyshop.product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.skypro.skyshop.searchable.Searchable;

public abstract class Product implements Searchable {
    protected String name;

    public Product(String name) {
        if (name == null || name.isBlank()) { // проверка, что название не является null или пустой строкой
            throw new IllegalArgumentException("Название продукта не может быть пустым.");
        }

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

    public int getPrice() {
        return 0;
    }

    @Override
    public String toString() {
        return null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}

