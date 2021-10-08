package ru.job4j.test.task.task.two.four;

public class Worker extends Person {

    private int wage;
    private int hours;

    public Worker(int wage, int hours) {
        super();
        this.wage = wage;
        this.hours = hours;
    }

    public Worker(String name, String surname, int wage, int hours) {
        super(name, surname);
        this.wage = wage;
        this.hours = hours;
    }

    public double timeWages() {
        return (double) wage / hours;
    }
}
