package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        Info info = new Info(0, 0, 0);
        Map<Integer, String> mapCurrent = new HashMap<>();
        for (User user : current) {
            mapCurrent.put(user.getId(), user.getName());
        }
        for (User user : previous) {
            if (mapCurrent.get(user.getId()) != null) {
                if (!user.getName().equals(mapCurrent.get(user.getId()))) {
                    info.setChanged(info.getChanged() + 1);
                }
            } else {
                info.setDeleted(info.getDeleted() + 1);
            }
        }
        info.setAdded(Math.abs(Math.abs(current.size() - previous.size()) - info.getDeleted()));
        return info;
    }
}