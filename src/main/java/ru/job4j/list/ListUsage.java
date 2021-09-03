package ru.job4j.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListUsage {
    public static void main(String[] args) {
        List<String> rsl = new ArrayList<>();
        rsl.add("one");
        rsl.add("two");
        rsl.add("three");
        System.out.println(rsl.remove(5));
    }
}