package com.app.additional;

/**
 * Stack (LIFO policy)
 * <p>
 * - fixed size
 * - based on array
 * - all operations are performed in O(1)
 */
public class Stack {
    private final int[] store;
    private int top;

    public Stack(int stackSize) {
        top = 0;
        store = new int[stackSize];
    }

    public void push(int item) {
        if (isFull())
            throw new IllegalStateException("stack is full");

        store[top++] = item;
    }

    public int pop() {
        if (isEmpty())
            throw new IllegalStateException("stack is empty");

        return store[--top];
    }

    private boolean isFull() {
        return top == store.length;
    }

    private boolean isEmpty() {
        return top == 0;
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException("stack is empty");

        return store[top - 1];
    }
}
