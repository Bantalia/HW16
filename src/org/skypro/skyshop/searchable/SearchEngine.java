package org.skypro.skyshop.searchable;

public class SearchEngine {
    private final Searchable[] elements;
    private int currentIndex = 0;

    public SearchEngine(int size) {
        elements = new Searchable[size];
    }

    // Добавление нового объекта в массив, если есть место
    public void add(Searchable item) {
        if (currentIndex < elements.length) {
            elements[currentIndex++] = item;
        }
        else System.out.println("Невозможно добавить");
    }

    // Поиск по поисковому термину, возвращает максимум 5 результатов
    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int found = 0;
        for (int i = 0; i < currentIndex && found < 5; i++) {
            if (elements[i] != null && elements[i].getSearchTerm().contains(query)) {
                results[found++] = elements[i];
                if (found == 5) {
                    break;
                }
            }
        }
        return results;
    }
}