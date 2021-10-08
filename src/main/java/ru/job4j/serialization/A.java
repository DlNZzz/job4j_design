package ru.job4j.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "a")
@XmlAccessorType(XmlAccessType.FIELD)
public class A {

    @XmlAttribute
    String s = "new String(\"s\");";
    @XmlAttribute
    private int num = 123;
    private B b = new B();
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

    @XmlRootElement(name = "b")
    static public class B {

        @XmlAttribute
        private boolean b;

        @Override
        public String toString() {
            return "B{"
                    + "b=" + b
                    + '}';
        }
    }
}
