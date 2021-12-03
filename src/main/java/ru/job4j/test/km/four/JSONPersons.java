package ru.job4j.test.km.four;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JSONPersons {

    public static final String PEOPLE = "people";
    public static final String NAME = "name";
    public static final String AGE = "age";

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Anton", 20),
                new Person("Baxmutski", 20)
        );
        String personJson = saveJSON(new Persons(people), "src\\main\\java\\ru\\job4j\\test\\km\\four\\Persons.json");
        System.out.println(personJson);
        Persons persons = downloadJSON("src\\main\\java\\ru\\job4j\\test\\km\\four\\Persons.json");
        System.out.println(persons);
    }

    public static String saveJSON(Persons persons, String path) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(PEOPLE, persons.getPeople());
        String personJson = jsonObject.toString();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write(personJson);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personJson;
    }

    public static Persons downloadJSON(String path) {
        Persons persons = null;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            List<Person> list = new ArrayList<>();
            String personsJson = bufferedReader.readLine();
            JSONObject jsonObject = new JSONObject(personsJson);
            JSONArray jsonArray = jsonObject.getJSONArray(PEOPLE);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject personJson = (JSONObject) jsonArray.get(i);
                Person person = new Person(personJson.get(NAME).toString(), Integer.parseInt(personJson.get(AGE).toString()));
                list.add(person);
            }
            persons = new Persons(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return persons;
    }
}
