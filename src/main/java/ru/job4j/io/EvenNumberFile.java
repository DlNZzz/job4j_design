package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {

    private static final int LINE_FEED = 10;
    private static final int CARRIAGE_RETURN = 13;

    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int num;
            int read;
            while ((read = in.read()) != -1) {
                if (read == CARRIAGE_RETURN) {
                    num = Integer.parseInt(String.valueOf(text));
                    if (num % 2 == 0) {
                        System.out.println(num);
                    }
                    text.setLength(0);
                } else if (read != LINE_FEED) {
                    text.append((char) read);
                }
            }
            num = Integer.parseInt(String.valueOf(text));
            if (num % 2 == 0) {
                System.out.println(num);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}