package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {
    private Container<Integer> container;
    @BeforeEach
    void setUp() {
        container = new Container<>();
        container.add(1);
        container.add(2);
        container.add(3);
    }

    @Test
    void add() {
        container.add(0);
        assertEquals(Arrays.toString(new int[]{ 1,2,3,0 }), container.toString());
    }

    @Test
    void get() {
        assertEquals(3,container.get(2));
    }

    @Test
    void removeIndex() {
        container.removeIndex(1);
        assertEquals(Arrays.toString(new int[]{ 1,3 }), container.toString());
    }

    @Test
    void removeValue() {
        container.removeValue(3);
        assertEquals(Arrays.toString(new int[]{ 1,2 }), container.toString());
    }

    @Test
    void testToString() {
        assertEquals("[1, 2, 3]",container.toString());
    }

    @Test
    void size() {
        assertEquals(3,container.size());
    }
}