package ru.job4j.test.km.three.two;

import java.util.Objects;

/*
2.Разработать программу картотека сотрудников .
Создать список объектов «Сотрудники» .
Пользователь указывает свое имя в качестве ввода, а затем приложение показывает сообщение «Добро пожаловать (и его имя)».

Леонид и Юрий запрещены для организации.
Итак, когда какой-либо пользователь вводит имя пользователя Леонид или Юрий , приложение генерирует событие и выводится сообщение «Проход запрещён»
 */
public class Employees {

    String name;

    public Employees(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employees employees = (Employees) o;
        return Objects.equals(name, employees.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
