package ru.job4j.test.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Solution4 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Random random = new Random();
        int x = random.nextInt(101);
        boolean isEmpty = false;
        while (!isEmpty) {
            int randomInt = Integer.parseInt(reader.readLine());
            if (x > randomInt) {
                System.out.println("Меньше");
            } else if (x < randomInt) {
                System.out.println("Больше");
            } else {
                System.out.println("Угадали");
                isEmpty = true;
            }
        }
    }
}
