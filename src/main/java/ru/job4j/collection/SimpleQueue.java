package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int count;

    public T poll() {
        if (count == 0) {
            throw new NoSuchElementException();
        }
        for (int i = 0; i < count; i++) {
            out.push(in.pop());
        }
        T save = out.pop();
        count--;
        for (int i = 0; i < count; i++) {
            in.push(out.pop());
        }
        return save;
    }

    public void push(T value) {
        in.push(value);
        count++;
    }
}
