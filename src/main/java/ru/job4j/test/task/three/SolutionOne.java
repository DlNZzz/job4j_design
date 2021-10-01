package ru.job4j.test.task.three;
//1. Даны два целочисленных массива размера N. Найти сумму четных элементов первого массива и всех элементов кратных пяти второго массива.

public class SolutionOne {

    private static int[] arrayOne = new int[]{1, 2, 3, 4, 5};
    private static int[] arrayTwo = new int[]{1, 2, 15, 4, 5};

    public static void main(String[] args) {
        int sum = 0;
        for (int num : arrayOne) {
            if (num % 2 == 0) {
                sum += num;
            }
        }
        System.out.println(sum);
        sum = 0;
        for (int num : arrayTwo) {
            if (num % 5 == 0) {
                sum += num;
            }
        }
        System.out.println(sum);
    }
}
