package ru.job4j.io.search;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    private void parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException();
        }
        for (String str : args) {
            if (!str.startsWith("-") || !str.contains("=")) {
                throw new IllegalArgumentException();
            }
            str = str.substring(1);
            String[] array = str.split("=");
            if (array.length != 2 || str.startsWith("=") || str.endsWith("=")) {
                throw new IllegalArgumentException();
            }
            values.put(array[0], array[1]);
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }
}