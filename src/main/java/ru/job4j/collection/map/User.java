package ru.job4j.collection.map;

import java.util.*;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar();
        User user = new User("qwe", 12, calendar);
        User user2 = new User("qwe", 12, calendar);
        Map<User, Object> map = new HashMap<>();
        map.put(user, new Object());
        map.put(user2, new Object());
        System.out.println(map);
    }

    @SuppressWarnings("checkstyle:EqualsHashCode")
    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }
}
