package ru.job4j.collection.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {
    private transient int modCount;
    private transient int size;
    private transient Node<E> first;
    private transient Node<E> last;
    private transient Node<E> element;

    @Override
    public void add(E value) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, value, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        element = first;
        if (size == index) {
            return last.item;
        }
        for (int i = 0; i < size; i++) {
            if (index == i) {
                return element.item;
            } else {
                element = element.next;
            }
        }
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        element = first;
        return new Iterator<E>() {
            int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return element != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (element.equals(last)) {
                    Node<E> save = element;
                    element = null;
                    return save.item;
                }
                element = element.next;
                return element.prev.item;
            }
        };
    }
}