package ru.job4j.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import ru.job4j.io.serialization.xml.Contact;
import ru.job4j.io.serialization.xml.Person;
import ru.job4j.serialization.json.B;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlRootElement(name = "a")
@XmlAccessorType(XmlAccessType.FIELD)
public class A {

    @XmlAttribute
    String s = "new String(\"s\");";
    @XmlAttribute
    private int num = 123;
    private B b = new B(false);
    @XmlElementWrapper
    @XmlElement(name = "num")
    private String[] array = new String[] {"1", "2", "3"};

    @Override
    public String toString() {
        return "A{"
                + "s='" + s + '\''
                + ", num=" + num
                + ", b=" + b
                + ", array=" + Arrays.toString(array)
                + '}';
    }

    public String getS() {
        return s;
    }

    public int getNum() {
        return num;
    }

    public B getB() {
        return b;
    }

    public String[] getArray() {
        return array;
    }

    @XmlRootElement(name = "b")
    static public class B {

        @XmlAttribute
        private boolean b;

        public B(boolean b) {
            this.b = b;
        }

        public boolean getB() {
            return b;
        }

        @Override
        public String toString() {
            return "ru.job4j.B{"
                    + "b=" + b
                    + '}';
        }
    }

    public static void main(String[] args) {
        final A a = new A();
        JSONObject jsonB = new JSONObject(new B(true));
        List<String> list = new ArrayList<>();
        list.add("Student");
        list.add("Free");
        JSONArray jsonArray = new JSONArray(list);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("s", a.getS());
        jsonObject.put("num", a.getNum());
        jsonObject.put("b", jsonB);
        jsonObject.put("array", jsonArray);
        System.out.println(jsonObject.toString());
        System.out.println(new JSONObject(a));
    }
}
