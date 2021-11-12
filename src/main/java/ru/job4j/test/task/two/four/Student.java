package ru.job4j.test.task.two.four;

public class Student extends Person {

    private byte mark;

    public Student(String name, String surname, byte mark) {
        super(name, surname);
        this.mark = mark;
    }
}
