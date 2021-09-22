package ru.job4j.test.task;

public class Solution2 {
    public static void main(String[] args) {
        sol(0.5, 0.5);
        sol(-0.6, -1.1);
        sol(2, 0);
        sol(-6, -1.1);
        sol(0, 1);
    }
    private static void sol(double x, double y) {
        if (y <= 1 && x >= -1 && x <= 1 && y >= -1 || x - 2 - y <= 0 && x >= 0 && y <= 0) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}
