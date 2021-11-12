package ru.job4j.test.task.two;

public class SolutionTwo {
    public static void main(String[] args) {
        int[] array = new int[] {1, 4, 3, 9, 10, 3};
        int max = array[0], min = array[0];
        for (int num : array) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        System.out.println("max " + max + "\n" + "min " + min);
    }
}
