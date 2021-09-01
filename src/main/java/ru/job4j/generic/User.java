package ru.job4j.generic;

public class User<T extends Base> extends Base {
    public User(String id) {
        super(id);
    }
}
