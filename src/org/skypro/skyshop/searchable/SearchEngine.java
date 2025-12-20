package org.skypro.skyshop.searchable;

import org.skypro.skyshop.product.Product;

import java.util.List;
import java.util.ArrayList;
import java.util.TreeMap;

public class SearchEngine {

    public TreeMap<String, Searchable> search(List<Searchable> items) {
        TreeMap<String, Searchable> sortedResults = new TreeMap<>();

        for (Searchable item : items) {
            sortedResults.put(item.getName(), item);
        }
        return sortedResults;
    }
}


