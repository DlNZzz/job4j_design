package ru.job4j.map;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMapTest {

    @Test
    public void testPut() {
        SimpleMap<String, String> simpleMap = new SimpleMap<>();
        assertTrue(simpleMap.put("12", "123"));
        assertFalse(simpleMap.put("12", "123"));
        assertTrue(simpleMap.put("a", "123"));
        assertTrue(simpleMap.put("b", "123"));
        assertFalse(simpleMap.put("a", "123"));
        assertFalse(simpleMap.put("b", "123"));
    }

    @Test
    public void testPut2() {
        SimpleMap<Integer, String> simpleMap = new SimpleMap<>();
        assertTrue(simpleMap.put(0, "123"));
        assertTrue(simpleMap.put(1, "123"));
        assertTrue(simpleMap.put(2, "123"));
        assertTrue(simpleMap.put(3, "123"));
        assertTrue(simpleMap.put(4, "123"));
        assertTrue(simpleMap.put(5, "123"));
        assertTrue(simpleMap.put(6, "123"));
        assertTrue(simpleMap.put(7, "123"));
        assertTrue(simpleMap.put(8, "123"));
        assertTrue(simpleMap.put(9, "123"));
        assertTrue(simpleMap.put(10, "123"));
        assertTrue(simpleMap.put(11, "123"));
        assertTrue(simpleMap.put(12, "123"));
        assertTrue(simpleMap.put(13, "123"));
        assertTrue(simpleMap.put(14, "123"));
        assertTrue(simpleMap.put(15, "123"));
        assertTrue(simpleMap.put(16, "123"));
        assertTrue(simpleMap.put(17, "123"));
        assertTrue(simpleMap.put(18, "123"));
        assertTrue(simpleMap.put(19, "123"));
        assertTrue(simpleMap.put(20, "123"));
        assertFalse(simpleMap.put(0, "123"));
        assertFalse(simpleMap.put(1, "123"));
        assertFalse(simpleMap.put(2, "123"));
        assertFalse(simpleMap.put(3, "123"));
        assertFalse(simpleMap.put(4, "123"));
        assertFalse(simpleMap.put(5, "123"));
        assertFalse(simpleMap.put(6, "123"));
        assertFalse(simpleMap.put(7, "123"));
        assertFalse(simpleMap.put(8, "123"));
        assertFalse(simpleMap.put(9, "123"));
        assertFalse(simpleMap.put(10, "123"));
        assertFalse(simpleMap.put(11, "123"));
        assertFalse(simpleMap.put(12, "123"));
        assertFalse(simpleMap.put(13, "123"));
        assertFalse(simpleMap.put(14, "123"));
        assertFalse(simpleMap.put(15, "123"));
        assertFalse(simpleMap.put(16, "123"));
        assertFalse(simpleMap.put(17, "123"));
        assertFalse(simpleMap.put(18, "123"));
        assertFalse(simpleMap.put(19, "123"));
        assertFalse(simpleMap.put(20, "123"));
    }

    @Test
    public void testGet() {
        SimpleMap<String, String> simpleMap = new SimpleMap<>();
        simpleMap.put("12", "123");
        simpleMap.put("a", "345");
        simpleMap.put("a", "445");
        simpleMap.put("b", "453");
        assertThat(simpleMap.get("a"), is("345"));
        assertThat(simpleMap.get("12"), is("123"));
        assertThat(simpleMap.get("b"), is("453"));
    }

    @Test
    public void testGet2() {
        SimpleMap<Integer, String> simpleMap = new SimpleMap<>();
        simpleMap.put(0, "123");
        simpleMap.put(1, "223");
        simpleMap.put(0, "432");
        assertNull(simpleMap.get(2));
        assertThat(simpleMap.get(0), is("123"));
    }

    @Test
    public void testRemove() {
        SimpleMap<Integer, String> simpleMap = new SimpleMap<>();
        simpleMap.put(0, "123");
        simpleMap.put(1, "223");
        assertTrue(simpleMap.remove(0));
        assertFalse(simpleMap.remove(0));
    }

    @Test
    public void testRemove2() {
        SimpleMap<Integer, String> simpleMap = new SimpleMap<>();
        simpleMap.put(10, "223");
        assertFalse(simpleMap.remove(0));
    }

    @Test
    public void testIterator() {
        SimpleMap<Integer, String> simpleMap = new SimpleMap<>();
        simpleMap.put(0, "123");
        simpleMap.put(1, "223");
        Iterator<Integer> iterator = simpleMap.iterator();
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(0));
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(1));
        assertFalse(iterator.hasNext());
    }

    @Test(expected = ConcurrentModificationException.class)
    public void testIterator2() {
        SimpleMap<Integer, String> simpleMap = new SimpleMap<>();
        Iterator<Integer> iterator = simpleMap.iterator();
        simpleMap.put(0, "123");
        simpleMap.put(1, "223");
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(0));
        simpleMap.put(2, "223");
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(1));
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(2));
        simpleMap.put(7, "123");
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(7));
        simpleMap.put(3, "123");
        assertTrue(iterator.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void testIterator3() {
        SimpleMap<Integer, String> simpleMap = new SimpleMap<>();
        Iterator<Integer> iterator = simpleMap.iterator();
        iterator.next();
    }
}