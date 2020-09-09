public class LinkedList<E> {

    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
            next = null;
        }
    }

    private Node<E> head = null;
    private int size = 0;

    // insert last
    public void insert(E element) {
        Node<E> newNode = new Node<>(element);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node<E> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }

    public void insertAt(E element, int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> newNode = new Node<>(element);
        if (index == size) {
            insert(element);
        } else if (isEmpty()) {
            head = newNode;
        } else if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<E> temp = head;
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

    public boolean search(E element) {
        Node<E> temp = head;
        while (temp.next != null) {
            if (temp.data == element) {
                return true;
            }
        }
        return false;
    }

    public E getFirst() {
        if (isEmpty()) {
            throw new NullPointerException();
        }
        return head.data;
    }

    public E getLast() {
        Node<E> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp.data;
    }

    public E getAt(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }


    public void delete() {
        if (isEmpty()) throw new NullPointerException();
        if (size == 1) {
            head = null;
        } else {
            Node<E> temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }
        size--;
    }

    public void deleteAt(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0 || index == size) {
            delete();
        } else {
            Node<E> temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            size--;
        }
    }

    public int getSize() {
        return size;
    }


}
