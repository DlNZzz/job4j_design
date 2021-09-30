package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    Set<FileProperty> set = new HashSet<>();
    HashMap<FileProperty, Path> map = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(file.toFile().length(), file.getFileName().toString());
        if (!map.containsKey(fileProperty)) {
            map.put(fileProperty, file);
        } else {
            System.out.println(map.get(fileProperty));
            System.out.println(file);
        }
        return super.visitFile(file, attrs);
    }
}