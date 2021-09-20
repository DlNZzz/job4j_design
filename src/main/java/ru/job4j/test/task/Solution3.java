package ru.job4j.test.task;

import java.util.Scanner;

public class Solution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();
        System.out.println("day - " + seconds / 86400);
        seconds %= 86400;
        System.out.println("hour - " + seconds / 3600);
        seconds %= 3600;
        System.out.println("min - " + seconds / 60);
        seconds %= 60;
        System.out.println("sec - " + seconds);
    }
}
