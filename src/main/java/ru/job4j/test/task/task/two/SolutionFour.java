package ru.job4j.test.task.task.two;

import java.util.Arrays;

public class SolutionFour {
    public static void main(String[] args) {
        int[] array = new int[] {11, 1, 4, 3, 9, 10, 3};
        int[] arrayMin = array.clone();
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int save = array[j];
                    array[j] = array[i];
                    array[i] = save;
                }
                if (arrayMin[i] > arrayMin[j]) {
                    int save = arrayMin[j];
                    arrayMin[j] = arrayMin[i];
                    arrayMin[i] = save;
                }
            }
        }
        System.out.println(Arrays.toString(array) + "\n" + Arrays.toString(arrayMin));
    }
}
