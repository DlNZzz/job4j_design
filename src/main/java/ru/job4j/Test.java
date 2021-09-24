package ru.job4j;

import ru.job4j.map.Map;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "123");
        map.put(2, "222");
        System.out.println(map);
    }
}
