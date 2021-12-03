package ru.job4j.test.km.four;

import java.util.List;

public class Persons {

    private List<Person> people;

    public Persons(List<Person> people) {
        this.people = people;
    }

    public List<Person> getPeople() {
        return people;
    }

    public Persons setPeople(List<Person> people) {
        this.people = people;
        return this;
    }

    @Override
    public String toString() {
        return "Persons{"
                + "people="
                + people
                + '}';
    }
}
