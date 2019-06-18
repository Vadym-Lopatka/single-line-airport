package com.app.additional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class QueueTest {

    private Queue queue;

    @BeforeEach
    public void before() {
        queue = new Queue(3);
    }

    @Test
    public void pushTest() {
        queue.push(1);
        queue.push(2);
        queue.push(3);

        assertThrows(IllegalStateException.class, () -> queue.push(4));
    }

    @Test
    public void peekTest() {
        assertThrows(IllegalStateException.class, queue::peek); //empty

        queue.push(1);
        assertEquals(1, queue.peek());

        queue.push(2);
        assertEquals(1, queue.peek()); // 1 - is  the first

        queue.push(3);
        assertEquals(1, queue.peek()); // repeat, the same behavior expected
    }

    @Test
    public void popTest() {
        assertThrows(IllegalStateException.class, queue::pop); //empty

        queue.push(1);
        queue.push(2);
        queue.push(3);

        assertThrows(IllegalStateException.class, () -> queue.push(4)); //full

        assertEquals(1, queue.pop());
        assertEquals(2, queue.pop());
        assertEquals(3, queue.pop());

        assertThrows(IllegalStateException.class, queue::pop); //already empty
    }

}