import java.util.NoSuchElementException;

/***
 *  VISUALIZE. BELIEVE IMPLEMENTATION. QUICK ACCURACY. MY CODE.

 *  This is unlimited capacity queue using nodes that tracks size.
 *
 *  Visualize front pointer on the left and back pointer on the right. Enqueue by ADDING node to the back.
 *  Dequeue by MOVING front pointer to the right.
 */

public class QueueLinkedList<T> implements Queue<T> {

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> front, back;
    private int size = 0;


    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);
        if (back != null) {
            back.next = newNode;
        }
        back = newNode;
        if (front == null) { // for first node
            front = back;
        }
        size++;
    }
   
    public void dequeue() {
        if (front == null) throw new NullPointerException();
        front = front.next;
        if (front == null) { // for last node
            back = null;
        }
        size--;
    }

    public T getFront() {
        if (front == null) throw new NullPointerException();
        return front.data;
    }

    public T getBack() {
        if (back == null) throw new NullPointerException();
        return back.data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }
}
