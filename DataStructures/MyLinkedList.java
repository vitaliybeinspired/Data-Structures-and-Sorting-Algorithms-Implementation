/***
 *  queue linkedlist
 *  VISUALIZE. BELIEVE IMPLEMENTATION. QUICK ACCURACY. MY CODE.

 *  This is unlimited capacity queue using nodes that tracks size.
 *
 *  Visualize front pointer on the left and back pointer on the right. Enqueue by ADDING node to the back.
 *  Dequeue by MOVING front pointer to the right.
 *
 *  what is the point of this queue? it's just a linkedlist
 *  cuz this doesn't allow removing/adding to middle
 *  just uses some linkedlist methods
 */

package DataStructures;


public class MyLinkedList<T> implements MyQueue<T> {

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            next = null;
        }
    }

    private Node<T> head = null;
    private int size = 0;

    // insert last
    public void add(T element) {
        if (element == null) throw new NullPointerException();
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }

    public void insertAt(T element, int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> newNode = new Node<>(element);
        if (index == size) {
            add(element);
        } else if (isEmpty()) {
            head = newNode;
        } else if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next.next;
            temp.next = newNode;
        }
        size++;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean search(T element) {
        Node<T> temp = head;
        while (temp.next != null) {
            if (temp.data == element) {
                return true;
            }
        }
        return false;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NullPointerException();
        }
        return head.data;
    }

    public T getLast() {
        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp.data;
    }

    public T getAt(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }


    public T remove() {
        if (isEmpty()) throw new NullPointerException();
        if (size == 1) {
            head = null;
        } else {
            Node<T> temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }
        size--;
        return null;
        // TODO return and remove
    }

    public void deleteAt(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0 || index == size) {
            remove();
        } else {
            Node<T> temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            size--;
        }
    }

    public int size() {
        return size;
    }


}
