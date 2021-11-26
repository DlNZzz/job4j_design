package ru.job4j.test.km.three.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    List<Employees> list = List.of(new Employees("Леонид"), new Employees("Юрий"));

    public static void main(String[] args) {
        new Main().start();
    }

    public void start() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Введите имя: ");
            String name = reader.readLine();
            Employees employees = new Employees(name);
            if (list.contains(employees)) {
                System.out.println("Проход запрещен");
            } else {
                System.out.println("Добро пожаловать " + name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
