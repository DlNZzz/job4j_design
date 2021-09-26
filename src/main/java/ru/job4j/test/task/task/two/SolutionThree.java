package ru.job4j.test.task.task.two;

import java.util.Objects;

public class SolutionThree {
    public static void main(String[] args) {
        String[] array = new String[] {"qwe", "4321", "qaz", "qaz", "2", "qwe", "qaz", "2", "qaz", "123", "qwe"};
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            boolean is = false;
            for (int j = i + 1; j < array.length; j++) {
                if (Objects.equals(array[i], array[j])) {
                    array[j] = null;
                    is = true;
                }
            }
            if (is) {
                array[i] = null;
            }
        }
        for (String str : array) {
            count = str == null ? ++count : count;
        }
        System.out.println(count);
    }
}
