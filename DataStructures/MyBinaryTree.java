package DataStructures;

/**
 *
 *
 * any name can work, it's a convention (feels so good i learned that fucking word convention)
 *
 * T is meant to be a Type
 * E is meant to be an Element (List<E>: a list of Elements)
 * K is Key (in a Map<K,V>)
 * V is Value (as a return value or mapped value)
 *
 * E good in arraylist
 * T good in link list
 *
 * so if it's in array its E
 * if it's a node its T
 *
 */
public class MyBinaryTree<T extends Comparable<T>> {

    private static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        public Node(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    Node<T> root;

    public MyBinaryTree() {
        root = null;
    }

    // how do i choose which side to add if it's not a search tree?
    // why would i create a binaryTree?

}
