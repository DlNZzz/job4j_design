package ru.job4j.test;

import java.io.*;

public class SolutionB {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bufferedReader.readLine());
        int[][] arrayT = new int[count][count];
        int[] arrayC = new int[count];
        for (int i = 0; i < count; i++) {
            String[] str = bufferedReader.readLine().split(" ");
            for (int j = 0; j < count; j++) {
                arrayT[i][j] = Integer.parseInt(str[j]);
            }
            for (int j = 0; j < count; j++) {
                if (arrayT[i][j] != -1) {
                    arrayC[i] |= arrayT[i][j];
                }
            }
        }
        for (int j = 0; j < count; j++) {
            System.out.println(arrayC[j]);
        }
    }
}
