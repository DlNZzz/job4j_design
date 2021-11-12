package ru.job4j.test.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SolutionTwo {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a, b, c;
        a = Integer.parseInt(reader.readLine());
        b = Integer.parseInt(reader.readLine());
        c = Integer.parseInt(reader.readLine());
        if (a == 0) {
            if (b != 0) {
                System.out.printf("x1 = %s", -c / b);
            } else {
                System.out.println("корней нет");
            }
        } else {
            int d = b * b - 4 * a * c;
            if (d < 0) {
                System.out.println("корней нет");
            } else {
                double x1, x2;
                x1 = (-b + Math.sqrt(d)) / (2 * a);
                if (d == 0) {
                    System.out.printf("Корни одинаковые x1 = %s", x1);
                } else {
                    x2 = (-b - Math.sqrt(d)) / (2 * a);
                    System.out.printf("x1 = %s\nx2 = %s", x1, x2);
                }
            }
        }
    }
}
