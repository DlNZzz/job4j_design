package ru.job4j.iterator;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(Arrays.asList(0, 1, 2, 3), Is.is(input));
    }

    @Test
    public void whenRemoveIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(2, 0, 1, 2, 2, 1));
        ListUtils.removeIf(input, new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer == 2;
            }
        });
        assertThat(Arrays.asList(0, 1, 1), Is.is(input));
    }

    @Test
    public void whenReplaceIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(2, 0, 2, 1, 2));
        ListUtils.replaceIf(input, new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer == 2;
            }
        }, 3);
        assertThat(Arrays.asList(3, 0, 3, 1, 3), Is.is(input));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(2, 0, 4, 3, 4));
        List<Integer> remove = new ArrayList<>(Arrays.asList(4, 2));
        ListUtils.removeAll(input, remove);
        assertThat(Arrays.asList(0, 3), Is.is(input));
    }
}