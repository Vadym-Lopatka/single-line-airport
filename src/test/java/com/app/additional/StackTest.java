package com.app.additional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StackTest {
    private Stack stack;

    @BeforeEach
    public void before() {
        stack = new Stack(3);
    }

    @Test
    void pushTest() {

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertThrows(IllegalStateException.class, () -> stack.push(4)); //full
    }

    @Test
    void peekTest() {
        assertThrows(IllegalStateException.class, stack::peek); //empty

        stack.push(1);
        assertEquals(1, stack.peek());

        stack.push(2);

        assertEquals(2, stack.peek()); // 2 is on the top
        assertEquals(2, stack.peek()); // repeat, the same behavior expected
    }

    @Test
    void popTest() {
        assertThrows(IllegalStateException.class, stack::pop); //empty

        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());

        stack.push(30);
        stack.push(40);
        stack.push(50);
        assertThrows(IllegalStateException.class, () -> stack.push(60)); //full

        assertEquals(50, stack.pop());
        assertEquals(40, stack.pop());
        assertEquals(30, stack.pop());
        assertThrows(IllegalStateException.class, stack::pop); //already empty
    }
}