package ru.job4j.io.search;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;

/*
//if ("mask".equals(searchType)) {

        //}
 */

public class Visitor extends SimpleFileVisitor<Path> {

    private String nameFile;
    private String searchType;
    private static List<Path> list = new LinkedList<>();

    public Visitor(String nameFile, String searchType) {
        this.nameFile = nameFile;
        this.searchType = searchType;
    }

    public static List<Path> getList() {
        return list;
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attributes) throws IOException {
        comparison(path);
        return super.visitFile(path, attributes);
    }

    private void comparison(Path path) {
        if ("name".equals(searchType)) {
            if (path.getFileName().equals(nameFile)) {
                list.add(path);
            }
        }
    }
}
