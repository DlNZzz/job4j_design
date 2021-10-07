package ru.job4j.serialization.java;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class A {

    String s = "new String(\"s\");";
    private int num = 123;
    private B b = new B();
    private byte[] array = new byte[] {1, 2, 3};

    @Override
    public String toString() {
        return "A{"
                + "s='" + s + '\''
                + ", num=" + num
                + ", b=" + b
                + ", array=" + Arrays.toString(array)
                + '}';
    }

    public class B {

        private boolean b;

        @Override
        public String toString() {
            return "B{"
                    + "b=" + b
                    + '}';
        }
    }

    public static void main(String[] args) {
        A a = new A();
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(a));
        final String aJson =
            "{"
                + "\"s\":\"new String(\\\"s\\\");\","
                + "\"num\":123,"
                + "\"b\":{"
                    + "\"b\":false"
                + "},"
                + "\"array\":[1, 2, 3]"
            + "}";
        final A aMod = gson.fromJson(aJson, A.class);
        System.out.println(aMod);
    }
}
