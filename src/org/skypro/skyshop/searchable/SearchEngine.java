package org.skypro.skyshop.searchable;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.Product;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.*;
import java.util.Comparator;


public class SearchEngine {

    // Храним продукты и статьи в HashSet, чтобы избежать дубликатов
    private Set<Product> products = new HashSet<>();
    private Set<Article> articles = new HashSet<>();

    // Компаратор для сортировки результатов поиска
    private final Comparator<Searchable> comparator = (s1, s2) -> {
        int lengthCompare = Integer.compare(s2.getName().length(), s1.getName().length());
        if (lengthCompare != 0) {
            return lengthCompare;
        }
        return s1.getName().compareTo(s2.getName());
    };

    // Добавление продукта
    public boolean addProduct(Product product) {
        return products.add(product);
    }

    // Добавление статьи
    public boolean addArticle(Article article) {
        return articles.add(article);
    }

    // Метод поиска по вхождению текста в имя (регистр игнорируем)
    public Set<Searchable> search(String text) {
        String lower = text.toLowerCase();
        Set<Searchable> results = new TreeSet<>(comparator);

        for (Product p : products) {
            if (p.getName().toLowerCase().contains(lower)) {
                results.add(p);
            }
        }
        for (Article a : articles) {
            if (a.getName().toLowerCase().contains(lower)) {
                results.add(a);
            }
        }

        return results;
    }
}

