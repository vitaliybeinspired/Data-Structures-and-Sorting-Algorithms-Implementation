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

public class QueueBlockingArray<T> implements Queue<T> {
    private final T[] queue;
    private int front, back, count;
    private final int capacity;

    public QueueBlockingArray(int capacity) {
        this.capacity = capacity;
        queue = (T[]) new Object[capacity];
        front = 0;
        back = capacity - 1;
        back = 0;
        count = 0;
    }

    public void enqueue(T item) {
        if (isFull()) throw new IndexOutOfBoundsException();
        back = (back + 1) % capacity;
        queue[back] = item;
        count++;
    }

    public void dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        front = (front + 1) % capacity;
        count--;
    }

    public T getFront() {
        return queue[front];
    }

    public T getBack() {
        return queue[back];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacity;
    }
}
