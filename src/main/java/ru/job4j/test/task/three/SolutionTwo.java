package ru.job4j.test.task.three;

//2. Найти корни квадратного уравнения с проверкой дискриминанта. Вывести если одинаковые корни - сообщение «Корни одинаковые»

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SolutionTwo {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a, b, c;
        a = Integer.parseInt(reader.readLine());
        if (a == 0) {
            throw new IllegalArgumentException("я антон и написал 0");
        }
        b = Integer.parseInt(reader.readLine());
        c = Integer.parseInt(reader.readLine());
        int d = b * b - 4 * a * c;
        if (d < 0) {
            System.out.println("корней нет");
        } else {
            double x1, x2;
            x1 = (-b + Math.sqrt(d)) / (2 * a);
            if (d == 0) {
                System.out.printf("x1 = %s", x1);
            } else {
                x2 = (-b - Math.sqrt(d)) / (2 * a);
                System.out.printf("x1 = %s\nx2 = %s", x1, x2);
            }
        }
    }
}
