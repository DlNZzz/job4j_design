package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write("Hello, world!".getBytes());
            out.write(System.lineSeparator().getBytes());
            for (int i = 1; i < 6; i++) {
                for (int j = 1; j < 6; j++) {
                    out.write((i * j + " ").getBytes());
                }
                out.write(System.lineSeparator().getBytes());
            }
            out.write(System.lineSeparator().getBytes());
            out.write(10);
            out.write(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}