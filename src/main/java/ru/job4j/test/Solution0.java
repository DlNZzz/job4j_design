package ru.job4j.test;

import java.io.*;

public class Solution0 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\main\\java\\ru\\job4j\\test\\123"));
        String line = bufferedReader.readLine();
        String[] array = line.split(" ");
        int sum = Integer.parseInt(array[0]) + Integer.parseInt(array[1]);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src\\main\\java\\ru\\job4j\\test\\123"));
        bufferedWriter.write(sum + "\n");
        bufferedWriter.flush();
    }
}
