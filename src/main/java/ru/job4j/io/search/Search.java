package ru.job4j.io.search;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/*
1. Создать программу для поиска файла. Все классы, относящиеся к этому заданию должны быть в отдельном пакете
Важно! Допускается использование ранее созданных вами классов.
2. Программа должна искать данные в заданном каталоге и подкаталогах.
3. Имя файла может задаваться, целиком, по маске, по регулярному выражению(не обязательно).
4. Программа должна собираться в jar и запускаться через java -jar find.jar -d=c:/ -n=*.txt -t=mask -o=log.txt
Ключи
-d - директория, в которой начинать поиск.
-n - имя файла, маска, либо регулярное выражение.
-t - тип поиска: mask искать по маске, name по полному совпадение имени, regex по регулярному выражению.
-o - результат записать в файл.
5. Программа должна записывать результат в файл.
6. В программе должна быть валидация ключей и подсказка.

mask - * и ?
name - полное имя без пути
regex - рег выражения
 */
public class Search {

    public static void main(String[] args) throws IOException {
        ArgsName argsName = ArgsName.of(args);
        Path path = Path.of(argsName.get("d"));

        String nameFile = argsName.get("n");
        String searchType = argsName.get("t");
        //Path output = Path.of(argsName.get("o"));
        Files.walkFileTree(path, new Visitor(nameFile, searchType));
        List<Path> list = Visitor.getList();

    }
}
