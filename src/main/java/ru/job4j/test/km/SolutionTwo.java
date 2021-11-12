package ru.job4j.test.km;

import java.util.Arrays;

/*
2. Дан одномерный массив размерности N^2(N в квадрате)
Написать программу для преобразования его в двумерный массив размерности N на N в диапазоне от минимального до максимального и деленного на два.
 */
public class SolutionTwo {

    public static void main(String[] args) {
        new SolutionTwo().arrayTwoDimensional(new int[] {9, 12, -21, 32, 15, 1, -21, 23, -42});
    }

    public void arrayTwoDimensional(int[] array) {
        int len = (int) Math.sqrt(array.length);
        int min = Arrays.stream(array).min().getAsInt() / 2;
        int max = Arrays.stream(array).max().getAsInt() / 2;
        int[][] arrayTD = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                arrayTD[i][j] = array[i * len + j] >= min && array[i * len + j] < max ? array[i * len + j] : 0;
                System.out.println(arrayTD[i][j]);
            }
        }
    }
}
