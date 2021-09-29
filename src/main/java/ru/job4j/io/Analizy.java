package ru.job4j.io;

import java.io.*;

public class Analizy {

    private boolean isEmpty = true;
    private boolean close = false;
    private String lastTime;

    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
                while (!close) {
                    String str = reader.readLine();
                    if (str == null) {
                        close = true;
                        if (!isEmpty) {
                            out.println(lastTime);
                        }
                    } else {
                        String[] array = str.split(" ");
                        if (isEmpty && ("400".equals(array[0]) || "500".equals(array[0]))) {
                            out.print(array[1] + ";");
                            isEmpty = false;
                            lastTime = array[1];
                        } else if ("400".equals(array[0]) || "500".equals(array[0])) {
                            lastTime = array[1];
                        } else if (!isEmpty) {
                            out.println(array[1]);
                            isEmpty = true;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}