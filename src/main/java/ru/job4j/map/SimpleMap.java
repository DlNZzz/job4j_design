package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        expand();
        int hash = hash(key.hashCode());
        int index = indexFor(hash);
        if (table[index] == null) {
            table[index] = new MapEntry<>(key, value);
            count++;
            modCount++;
            return true;
        }
        return false;
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> 4);
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private void expand() {
        if ((float) count / capacity >= LOAD_FACTOR) {
            modCount++;
            capacity *= 2;
            MapEntry<K, V>[] tableCopy = new MapEntry[capacity];
            for (int i = 0; i < table.length; i++) {
                if (table[i] != null) {
                    K key = table[i].key;
                    MapEntry<K, V> mapEntry = table[i];
                    tableCopy[indexFor(hash(key.hashCode()))] = mapEntry;
                }
            }
            table = tableCopy;
        }
    }

    @Override
    public V get(K key) {
        int hash = hash(key.hashCode());
        int index = indexFor(hash);
        if (Objects.equals(table[index], new MapEntry<>(key, ""))) {
            return table[index].value;
        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        int hash = hash(key.hashCode());
        int index = indexFor(hash);
        if (Objects.equals(table[index], new MapEntry<>(key, ""))) {
            table[index] = null;
            count--;
            modCount++;
            return true;
        }
        return false;
    }

    @Override
    public Iterator<K> iterator() {

        int expectedModCount = modCount;

        Iterator<K> iterator = new Iterator<K>() {

            int count = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                for (; count < table.length; count++) {
                    if (table[count] != null) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[count++].key;
            }
        };
        return iterator;
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            MapEntry<?, ?> mapEntry = (MapEntry<?, ?>) o;
            return Objects.equals(key, mapEntry.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }
}