package DataStructures;


/**
 * pro knowledge interview: explain how this implementation doesn't shift elements but
 * moves front and rear pointers
 *
 * This is an array queue which means it has capacity limit.
 * It uses front and back pointers instead of shifting all elements.
 * Front pointer to remove goes right, back pointer to add goes right.
 * Visualize the front start at the left and back starting at the end element. But they can loop around.
 */

import java.util.*;

public class MyArrayBlockingQueue<E> implements MyQueue<E> {
    private final E[] queue;
    private int front, back, count;
    private final int capacity;

    public MyArrayBlockingQueue(int capacity) {
        this.capacity = capacity;
        queue = (E[]) new Object[capacity];
        front = 0;
        back = capacity - 1;
        back = 0;
        count = 0;
    }

    public void add(E item) {
        if (isFull()) throw new IndexOutOfBoundsException();
        back = (back + 1) % capacity;
        queue[back] = item;
        count++;
    }

    public E remove() {
        if (isEmpty()) throw new NoSuchElementException();
        E temp = queue[front];
        front = (front + 1) % capacity;
        count--;
        return temp;
    }

    public E peek() {
        return queue[front];
    }

    public E getBack() {
        return queue[back];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacity;
    }
}
