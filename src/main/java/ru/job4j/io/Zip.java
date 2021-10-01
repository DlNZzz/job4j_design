package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public static void packFiles(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream((new BufferedOutputStream(new FileOutputStream(target))))) {
            for (File source : sources) {
                zip.putNextEntry(new ZipEntry(source.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException("args.length != 3");
        }
        ArgsName argsName = ArgsName.of(args);
        Path source = Path.of(argsName.get("d"));
        String str = argsName.get("e");
        File target = new File(argsName.get("o"));
        if (source == null || !source.isAbsolute() || !target.isFile() || str == null) {
            throw new IllegalArgumentException("no absolute or null");
        }
        Predicate<Path> predicate = path -> !path.toFile().getName().endsWith(str);
        try {
            List<File> list = Search.search(source, predicate).stream().map(Path::toFile).collect(Collectors.toList());
            packFiles(list, target);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}