package org.skypro.skyshop.searchable;
import java.util.List;
public class SearchEngine {
    public Searchable[] elements;
    private int currentIndex = 0;

    public SearchEngine(int size) {
        elements = new Searchable[size];
    }

    // Добавление нового объекта в массив, если есть место
    public void add(Searchable item) {
        if (currentIndex < elements.length) {
            elements[currentIndex++] = item;
        }
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
    private List<Searchable> items;

    public SearchEngine(List<Searchable> items) {
        this.items = items;
    }
    public  Searchable findBestMatch(String search) throws BestResultNotFound {
        if (search == null || search.isEmpty()) {
            throw new BestResultNotFound(search);
        }

        Searchable bestItem = null;
        int maxCount = 0;

        for (Searchable item : items) {
            int count = countOccurrences(item.getSearchTerm(), search);
            if (count > maxCount) {
                maxCount = count;
                bestItem = item;
            }
        }

        if (bestItem == null || maxCount == 0) {
            throw new BestResultNotFound(search);
        }

        return bestItem;
    }

    // Подсчет вхождений подстроки в строке
    private int countOccurrences(String str, String substring) {
        if (str == null || substring == null || substring.isEmpty())
            return 0;
        int count = 0;
        int index = 0;
        while ((index = str.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }
        return count;
    }
}
