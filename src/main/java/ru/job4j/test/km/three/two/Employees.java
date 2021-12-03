package ru.job4j.test.km.three.two;

import java.util.Objects;

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
