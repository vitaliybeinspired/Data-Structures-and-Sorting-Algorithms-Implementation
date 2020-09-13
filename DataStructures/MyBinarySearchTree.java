package DataStructures;


import java.util.Comparator;

/**
 * why am i doing it the hard way? but i need to know how to compare objects
 *
 * this isn't interview preparing. this is learning extra
 *
 * why am i doing this? why am i making it harder? is that good? top 10%
 * noobs will create ints, i want to stand out
 * but i'm more likely to make mistakes, takes longer to code, so can backfire
 * like if i implement this and asked to use it, then how do i interate through it? comparision?
 *
 *
 * // is this a data strcture or searching alogirthm or both?
 *
 * extends means E has more methods now like E.compareTo(other)
 *
 * what did fatma put for compareTo? and she implemented comprator?
 *
 * then T element isn't correct
 * T data or T item or T type convention is?
 */

// generic element type E extends Comprable NOT implmentes comparable???!?!
    // i was stuck for days on this???????
    // did the professor fuck me up?
    // didn't she say implements comprable or was that implements comprator?!?!
// so why do i need comprator?
    // extends

public class MyBinarySearchTree<T extends Comparable<T>> {

    private static class Node<T> {
        T data; // if int i would say int data, but E element?
        Node<T> left;
        Node<T> right;

        public Node(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    Node<T> root;

    public MyBinarySearchTree() {
        root = null;
    }

    public void insert(T data) {
        insert(data, root);
    }

    public void insert(T data, Node<T> root) {
        Node<T> newNode = new Node<>(data);

        if (data.compareTo(newNode.data) < 0) { // it's smaller left side
            insert(data, root.left);
        } else if (data.compareTo(newNode.data) > 0) {
            insert(data, root.right);
        }
        // so how do i insert this node to this tree???
        // how is it connected???
        // no duplicates
    }


}





