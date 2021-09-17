package ru.job4j.test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SolutionD {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\main\\java\\ru\\job4j\\test\\input.txt"));
        String[] arrayS = bufferedReader.readLine().split(" ");
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader("src\\main\\java\\ru\\job4j\\test\\" + arrayS[0]));
        BufferedReader bufferedReader3 = new BufferedReader(new FileReader("src\\main\\java\\ru\\job4j\\test\\" + arrayS[1]));
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        String line = bufferedReader2.readLine();
        while (line != null) {
            line = bufferedReader2.readLine();
            list.add(line);
        }

        String line3 = bufferedReader3.readLine();
        while (line3 != null) {
            line3 = bufferedReader3.readLine();
            list2.add(line3);
        }
        System.out.println("order_id,shop_name,shop_id,cost");
    }
}