package ru.job4j.test;

public class Solution {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4};
        int answer = 35;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                switch (j) {
                    case 0:
                        sum(array[j], array[j + 1]);
                        break;
                    case 1:
                        diff(array[j], array[j + 1]);
                        break;
                    case 2:
                        mult(array[j], array[j + 1]);
                        break;
                    default:
                }

            }
        }
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static int diff(int a, int b) {
        return a - b;
    }

    public static int mult(int a, int b) {
        return a * b;
    }
}
