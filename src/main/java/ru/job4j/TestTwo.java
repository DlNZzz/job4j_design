package ru.job4j;

public class TestTwo {

    public static boolean same(String first, String second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
        byte[] f = first.getBytes();
        byte[] s = second.getBytes();
        if (f.length != s.length) {
            return false;
        }
        int count = 0;
        fi: for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < s.length; j++) {
                if (f[i] == s[j]) {
                    count++;
                    continue fi;
                }
            }
        }
        if (count == f.length) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String first = "vvvamavmsv";
        String second = "vvvmasmavvs";
        System.out.println(same(first, second));
    }
}
