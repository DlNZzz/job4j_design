package ru.job4j.test.task.two.four;

public class Person {

    private String name;
    private String surname;

    public Person() {
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public static void main(String[] args) {
        Worker worker = new Worker("name", "surname", 30000, 160);
        System.out.println("Почасовая оплата " + worker.timeWages());
    }
}