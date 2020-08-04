package by.shirokaya.tasks.javafundamentals.monthapp;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Language {
    ENGLISH(Stream.of(new String[][]{
            {"1", "January"},
            {"2", "February"},
            {"3", "March"},
            {"4", "April"},
            {"5", "May"},
            {"6", "June"},
            {"7", "July"},
            {"8", "August"},
            {"9", "September"},
            {"10", "October"},
            {"11", "November"},
            {"12", "December"},
    }).collect(Collectors.toMap(data -> data[0], data -> data[1]))),

    RUSSIAN(Stream.of(new String[][]{
            {"1", "Январь"},
            {"2", "Февраль"},
            {"3", "Март"},
            {"4", "Апрель"},
            {"5", "Май"},
            {"6", "Июнь"},
            {"7", "Июль"},
            {"8", "Август"},
            {"9", "Сентябрь"},
            {"10", "Октябрь"},
            {"11", "Ноябрь"},
            {"12", "Декабрь"},
    }).collect(Collectors.toMap(data -> data[0], data -> data[1])));

    private final Map<String, String> matching;

    Language(Map<String, String> matching) {
        this.matching = matching;
    }

    public Map<String, String> getMatching() {
        return matching;
    }
}
