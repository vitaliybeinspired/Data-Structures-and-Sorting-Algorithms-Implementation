/**
 * Quick interview refresher
 *
 * Visual array stack vertically, 0 index on bottom and top is highest index
 *
 * Don't need to delete elements, just move pointer down.
 *
 * Resizing is optional, I can just initiate a large size array
 *
 * if i didn't know this simple implementation from CtCI, I would have done next and prev! so how do i know
 *  * I made array stack good?
 *
 *
 *  users can call stack.length built in to check size??? or that won't give amount of elements...
 */

import java.util.EmptyStackException; // i would need to remember to write this in docs or online code

public class StackArray<T> implements Stack<T> {
    int top;
    int max;
    T[] stack;

    public StackArray() {
        stack = (T[]) new Object[10]; // this was an hour long barrier, drained energy, excitment, momentum
        max = 10;
        top = 0;
    }

    public void push(T data) {
        if (isFull()) {
            resize();
        }
        stack[top++] = data;
    }

    private void resize() { // resize is optional during interview or quickly do it?
        T[] temp = (T[]) new Object[max * 2];
        for (int i = 0; i < stack.length; i++) {
            temp[i] = stack[i];
        }
        stack = temp;
    }

    public void pop() {
        if (isEmpty()) throw new EmptyStackException();
        top--;
    }

    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return stack[top];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public boolean isFull() {
        return top == max;
    }

}
