package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        Info info = new Info(0, 0, 0);
        Map<Integer, String> mapPrevious = new HashMap<>();
        Map<Integer, String> mapCurrent = new HashMap<>();
        for (User user : previous) {
            mapPrevious.put(user.getId(), user.getName());
        }
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
        for (User user : current) {
            if (mapPrevious.get(user.getId()) == null) {
                info.setAdded(info.getAdded() + 1);
            }
        }
        return info;
    }
}