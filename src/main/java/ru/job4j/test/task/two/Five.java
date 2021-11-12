package ru.job4j.test.task.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Five {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[Integer.parseInt(reader.readLine())];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            int num = Integer.parseInt(reader.readLine());
            if (num % 2 == 0) {
                array[i - count] = num;
            } else {
                array[array.length - ++count] = num;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
