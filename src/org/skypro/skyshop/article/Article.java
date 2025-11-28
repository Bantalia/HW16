package org.skypro.skyshop.article;
import org.skypro.skyshop.searchable.Searchable;
public final class Article implements Searchable {
    private final String title;
    private final String text;

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
// Метод toString возвращает формат:
    // Название статьи
    // Текст статьи

    @Override
    public String toString() {
        return title + "\n" + text;
    }
    // Реализация интерфейса Searchable
    @Override
    public String getSearchTerm() {
        return toString(); // название + текст
    }

    @Override
    public String getType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return title;
    }
}
