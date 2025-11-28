package org.skypro.skyshop.searchable;

public interface Searchable {

    // Возвращает термин поиска
    String getSearchTerm();

    // Возвращает тип найденного контента
    String getType();

    // Возвращает имя Searchable-объекта
    String getName();

    //Преобразует Searchable-объект в строку

    @Override
    String toString();

    // Представление объекта (default-метод)
    default String getStringRepresentation() {
        return getName() + " — тип " + getType();
    }

}
