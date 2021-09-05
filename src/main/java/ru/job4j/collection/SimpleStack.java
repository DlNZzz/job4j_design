package ru.job4j.collection;

public class SimpleStack<T> {

    private ForwardLinked<T> linked = new ForwardLinked<T>();
    private int size;

    public T pop() {
        size--;
        for (int i = 0; i < size; i++) {
            push(linked.deleteFirst());
            size--;
        }
        return linked.deleteFirst();
    }

    public void push(T value) {
        size++;
        linked.add(value);
    }
}