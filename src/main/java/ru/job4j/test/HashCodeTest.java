package ru.job4j.test;

public class HashCodeTest {
    public static void main(String[] args) {
        Object object = new Object();
        Object object2 = new Object();
        int hCode = object2.hashCode();
        System.out.println("hashCode = 1452126962");
        System.out.println("hashCode = " + hCode);
        hCode = object.hashCode();
        System.out.println("hashCode = " + hCode);
    }
}