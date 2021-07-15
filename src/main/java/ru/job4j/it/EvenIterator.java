package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
it.next() - возвращают только четные числа. В этом примере - это 4 и 2.

it.hasNext() - возвращает true, только если в массиве есть четные перед указателем.
 */
public class EvenIterator implements Iterator<Integer> {
    private final int[] data;
    private int row = 0;

    public EvenIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (((row) != data.length)) {
            if (data[row] % 2 == 0) {
                return true;
            }
            row++;
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row++];
    }
}
