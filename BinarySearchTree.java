/**
 * why am i doing it the hard way? but i need to know how to compare objects
 *
 * this isn't interview preparing. this is learning extra
 *
 * why am i doing this? why am i making it harder? is that good? top 10%
 * noobs will create ints, i want to stand out
 * but i'm more likely to make mistakes, takes longer to code, so can backfire
 * like if i implement this and asked to use it, then how do i interate through it? comparision?
 */

public class BinarySearchTree<E> implements Comparable<E>{

    // how does comparable really do this, just need it for objects
    @Override
    public int compareTo(E element) {

        return 0;
    }

    private static class Node<E> {
        E element; // if int i would say int data, but E element?
        Node<E> left;
        Node<E> right;

        public Node(E element) {
            this.element = element;
            left = null;
            right = null;
        }
    }

    Node<E> root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(E element) {
        Node<E> newNode = new Node<>(element);
        if (isEmpty()) {
            root = newNode;
        } else if (compareTo(element) < 0) { // it's smaller left side

        }

    }


    public boolean isEmpty() {
        return root == null;
    }

}
