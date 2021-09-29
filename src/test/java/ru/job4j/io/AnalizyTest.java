package ru.job4j.io;

import org.junit.Test;

public class AnalizyTest {

    @Test
    public void whenPairWithoutComment() {
        String sourse = "./data/sourse.csv";
        String target = "./data/target.txt";
        Analizy analizy = new Analizy();
        analizy.unavailable(sourse, target);
    }
}