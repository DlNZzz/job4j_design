package ru.job4j;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List rawList = new ArrayList();
        List<String> list = new ArrayList<>();
        rawList = list;
        rawList.add(8);
    }
}
