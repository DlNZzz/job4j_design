package ru.job4j;

public class TestTwo {

    public static boolean same(String first, String second) {
        byte[] f = first.getBytes();
        byte[] s = second.getBytes();
        if (f.length != s.length) {
            return false;
        }
        for (int i = 0; i < f.length; i++) {
            if (f[i] != s[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String first = "av";
        String second = "av";
        System.out.println(same(first, second));
    }
}
