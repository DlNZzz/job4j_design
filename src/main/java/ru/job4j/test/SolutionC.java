package ru.job4j.test;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SolutionC {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\main\\java\\ru\\job4j\\test\\123.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src\\main\\java\\ru\\job4j\\test\\output.txt"));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String[] arrayStr = bufferedReader.readLine().split(" ");
        int t = Integer.parseInt(arrayStr[0]);
        int e = Integer.parseInt(arrayStr[1]);
        ArrayList<Long> list = new ArrayList<>(8000);
        String line = bufferedReader.readLine();
        while (line != null) {
            arrayStr = line.split(" ");
            if (arrayStr.length >= 4 && (arrayStr[0] + " " + arrayStr[1]).length() == 21 && "ERROR".equals(arrayStr[2])) {
                list.add((format.parse(arrayStr[0].replaceFirst("\\[", "") + " " + arrayStr[1]).getTime() / 1000) - 1500000000);
            }
            line = bufferedReader.readLine();
        }
        long dateLong = -1;
        for (int i = 0; i < list.size(); i++) {
            long tk = list.get(i) + t - 1;
            if (i + e - 1 < list.size() && tk >= list.get(i + e - 1)) {
                dateLong = (list.get(i + e - 1) + 1500000000);
                break;
            }
        }
        System.out.println(list);
        if (dateLong != -1) {
            Date date = new Date(dateLong * 1000);
            bufferedWriter.write(format.format(date));
        } else {
            bufferedWriter.write("-1");
        }
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
