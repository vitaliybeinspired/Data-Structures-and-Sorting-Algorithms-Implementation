import java.util.*;

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
 */

public class StackLinkedList<T> implements Stack<T> {

    private static class Node<U> {
        U data;
        Node<U> next;

        private Node(U data) {
            this.data = data;
        }
    }

    private Node<T> top;

    // this is stack, head should be top, not at start/bottom
    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
    }

    public void pop() {
        if (isEmpty()) throw new EmptyStackException();
        top = top.next;
    }

    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}































