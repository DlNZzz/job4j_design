package ru.job4j;

import ru.job4j.collection.set.Set;
import ru.job4j.collection.set.SimpleSet;

import java.util.HashSet;
import java.util.Queue;
import java.util.Stack;

public class B extends A {
    public static void main(String[] args) {
        B b1 = null;
        B b2 = null;
        Stack<String> stack = new Stack<>();
        HashSet<B> set = new HashSet<>();
        set.add(b1);
        set.add(b2);
        System.out.println(set.size());
    }
}
