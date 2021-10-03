package ru.job4j.encoding;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConsoleChat {

    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        boolean stop = false;
        boolean isAnswer = true;
        List<String> listPhrases = readPhrases();
        List<String> log = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (!stop) {
                String phrase = reader.readLine();
                if (OUT.equals(phrase)) {
                    stop = true;
                    log.add(phrase);
                    saveLog(log);
                } else if (STOP.equals(phrase)) {
                    isAnswer = false;
                    log.add(phrase);
                } else if (CONTINUE.equals(phrase)) {
                    isAnswer = true;
                    log.add(phrase);
                }
                if (!stop && isAnswer) {
                    String answer = listPhrases.get((int) (Math.random() * listPhrases.size()));
                    log.add(phrase);
                    log.add(answer);
                    System.out.println(answer);
                } else if (!stop) {
                    log.add(phrase);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private List<String> readPhrases() {
        List<String> phrases = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(botAnswers))) {
            reader.lines().forEach(phrases::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return phrases;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path))) {
            log.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ConsoleChat cc = new ConsoleChat("./src/data/log.txt", "./src/data/botAnswers.txt");
        cc.run();
    }
}
