package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

public class CSVReader {
    public static void handle(ArgsName argsName) {
        Path source = Path.of(argsName.get("path"));
        String delimiter = argsName.get("delimiter");
        String target = argsName.get("out");
        String[] filter = argsName.get("filter").split(",");
        StringBuilder builder = new StringBuilder();
        String[] nameLine = null;
        try (Scanner scanner = new Scanner(source).useDelimiter(System.lineSeparator())) {
            if (scanner.hasNext()) {
                nameLine = scanner.nextLine().split(delimiter);
            }
            assert nameLine != null;
            int[] positions = new int[filter.length];
            int count = 0;
            for (String s : filter) {
                builder.append(s + ";");
                for (int j = 0; j < nameLine.length; j++) {
                    if (s.equals(nameLine[j])) {
                        positions[count++] = j;
                    }
                }
            }
            builder.deleteCharAt(builder.length() - 1);
            builder.append(System.lineSeparator());
            while (scanner.hasNext()) {
                String[] array = scanner.nextLine().split(delimiter);
                for (int position : positions) {
                    builder.append(array[position] + ";");
                }
                builder.deleteCharAt(builder.length() - 1);
                builder.append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        save(builder, target);
    }

    private static void save(StringBuilder builder, String target) {
        if (target.equals("stdout")) {
            System.out.println(builder);
        } else {
            try (PrintWriter printWriter = new PrintWriter(new FileOutputStream(target))) {
                printWriter.print(builder);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        if (args.length != 4) {
            throw new IllegalArgumentException(args.length + "");
        }
        ArgsName argsName = ArgsName.of(args);
        handle(argsName);
    }
}