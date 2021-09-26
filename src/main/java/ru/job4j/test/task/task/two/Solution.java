package ru.job4j.test.task.task.two;

public class Solution {
    public static void main(String[] args) {
        int[] array = new int[] {1, 23, 3, 9, 10, 3};
        int count = 0;
        for (int num : array) {
            count += num;
        }
        System.out.println((float) count / array.length);
    }
}
