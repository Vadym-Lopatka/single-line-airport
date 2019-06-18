package com.app.additional;

/**
 * Queue (FIFO policy)
 * <p>
 * - fixed size
 * - based on array
 * - all operations are performed in O(1)
 */
public class Queue {
    private final int[] store;
    private int head;
    private int tail;

    public Queue(int size) {
        if (size == 0)
            throw new IllegalStateException("the size cannot be 0");

        store = new int[size];
        final int positionForStart = size / 2;
        head = positionForStart;
        tail = positionForStart;
    }

    public void push(int item) {
        if (isFull())
            throw new IllegalStateException("the queue is full");

        store[getTailIndex()] = item;
    }

    private int getTailIndex() {
        final int thePos;

        if (tail == store.length) {
            thePos = 0;
            tail = 0;
        } else {
            thePos = tail;
            tail++;
        }

        return thePos;
    }

    private int getHeadIndex() {
        final int thePos;

        if (head == store.length) {
            thePos = 0;
            head = 0;
        } else {
            thePos = head;
            head++;
        }

        return thePos;
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException("the queue is empty");

        return store[head];
    }

    public int pop() {
        if (isEmpty())
            throw new IllegalStateException("the queue is empty");

        return store[getHeadIndex()];
    }

    private boolean isEmpty() {
        return head == tail;
    }

    private boolean isFull() {
        return head == tail + 1;
    }
}
