package DataStructures;

/**
 * Quick Interview refresher
 * Visualize nodes stacked and the next goes down not up like in array! It's reversed.
 *
 * top
 * top.next (is bellow top, goes down)
 *
 * after i understand this, code it from scratch
 * look how short the code is but visualizing and understanding takes time to learn and refreshing
 * i can code this in 5 min
 *
 *
 * // the convention is that pop returns data so its risky i go this route even
 *         // if it makes since. others will try to use this method expecting return value.
 *
 *         explain to interviewer how void pop is better than T pop?
 *
 *   LinkedList implementation no blocking? why would i want to block?
 *
 *   StackLinkedList for capacity unlimited.
 *   I need to track size
 *
 *   Reason why node is not a class by itself is because a class can't be a data holder
 *   a class is a data holder AND behaviors as methods
 */

public class MyStackLinkedList<T> implements MyStack<T> {
    private static class Node<T> {
        T data;
        Node<T> next;

        private Node(T data) {
            this.data = data;
        }
    }

    private Node<T> top;
    private int size = 0;

    // this is stack, head should be top, not at start/bottom
    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T pop() {
        if (isEmpty()) throw new NullPointerException();
        T temp = top.data;
        top = top.next;
        return temp;
    }

    public T peek() {
        if (isEmpty()) throw new NullPointerException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }
}































