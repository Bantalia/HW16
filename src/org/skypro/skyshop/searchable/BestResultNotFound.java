package org.skypro.skyshop.searchable;

public class BestResultNotFound extends Exception {
    public BestResultNotFound(String searchQuery) {
        super("Не найден подходящий продукт для запроса: " + searchQuery);
    }
}

