package ua.mycompany.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static java.util.Optional.of;
import static java.util.Optional.ofNullable;
import static org.junit.Assert.*;

public class ArrayListTest {
    ArrayList<Integer> tests;

    @Before
    public void setUp() {
        tests = new ArrayList<>();
        tests.add(4);
        tests.add(3);
        tests.add(7);
    }

    @Test
    public void shouldAddToEndList() {
        tests.add(5);
        assertEquals(of(5), ofNullable(tests.get(3)));
        assertEquals(4, tests.size());
    }

    @Test
    public void shouldAddToListByIndex() {
        tests.add(2, 5);
        assertEquals(of(5), ofNullable(tests.get(2)));
        assertEquals(4, tests.size());
    }

    @Test
    public void shouldRemoveElementFromList() {
        tests.remove(1);
        assertEquals(of(7), ofNullable(tests.get(1)));
        assertEquals(2, tests.size());
    }

    @Test
    public void shouldGetElementFromList() {
        assertEquals(of(3), ofNullable(tests.get(1)));
    }

    @Test
    public void shouldSetElementToList() {
        tests.set(0, 6);
        assertEquals(of(6), ofNullable(tests.get(0)));
        assertEquals(3, tests.size());
    }

    @Test
    public void shouldReturnSizeOfList() {
        assertEquals(3, tests.size());
        tests.add(5);
        assertEquals(4, tests.size());
    }

    @Test
    public void shouldReturnTrueForEmptyList() {
        assertFalse(tests.isEmpty());
        tests.clean();
        assertTrue(tests.isEmpty());
    }

    @Test
    public void shouldCleanList() {
        tests.clean();
        assertTrue(tests.isEmpty());
    }

    @Test
    public void shouldReturnCorrectIterator() {

        Iterator<Integer> iterator = tests.iterator();
        iterator.next();
        while (iterator.hasNext()) {
            iterator.remove();
        }
        assertEquals(tests.size(), 1);
    }
}
