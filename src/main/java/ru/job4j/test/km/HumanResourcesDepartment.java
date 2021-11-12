package ru.job4j.test.km;

import java.util.ArrayList;
import java.util.List;

/*
1. Разработать класс «Отдел кадров».
В классе хранить информацию о наименовании предприятия,
в числе работников норме выработки часов в месяц ( одинаковая для всех работников),
оплата за час, подоходном налоге.
реализовать метод для подсчета общей выплаты по подоходному налогу
 */
public class HumanResourcesDepartment {

    private String nameCompany;
    private List<Human> employees;

    public HumanResourcesDepartment() {
    }

    public HumanResourcesDepartment(String nameCompany, List<Human> employees) {
        this.nameCompany = nameCompany;
        this.employees = employees;
    }

    public static void main(String[] args) {
        new HumanResourcesDepartment().start();
    }

    public void start() {
        List<Human> employees = new ArrayList<>();
        employees.add(new Human(200, 13));
        employees.add(new Human(350, 33));
        employees.add(new Human(250, 50));
        employees.add(new Human(2000, 0));
        employees.add(new Human(100, 53));
        employees.add(new Human(600, 15));
        HumanResourcesDepartment humanRD = new HumanResourcesDepartment("roga i kopita", employees);
        System.out.println(humanRD.nameCompany);
        calculationOfTaxes(humanRD);
    }

    public void calculationOfTaxes(HumanResourcesDepartment humanRD) {
        humanRD.employees.stream().map((h) -> h.payment * h.getWorkingHours() * (1 - (float) h.tax / 100)).forEach(System.out::println);
    }

    private class Human {

        static final int WORKING_HOURS = 160;

        int payment;
        int tax;

        public Human(int payment, int tax) {
            this.payment = payment;
            this.tax = tax;
        }

        public int getWorkingHours() {
            return WORKING_HOURS;
        }
    }
}
