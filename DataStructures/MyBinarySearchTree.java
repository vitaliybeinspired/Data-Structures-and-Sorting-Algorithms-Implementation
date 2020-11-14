package DataStructures;


import java.util.Comparator;

/**
 * BinaryTree is a data structure which is also used as BinarySearchTree
 *
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
 *
 * so wrapper classes like Integer and String are final, immutable
 *  * so passing to parameters doesn't affect outside of parameter
 *  * so is Node immutable, final? i didn't make it or it's static? or private?
 *
 *  /**
 *      * this was embarassing, confused with c++, also still vague when it makes a copy in parameter
 *      *
 *      *
 *
 *
 *      maybe too hard on myself, look at how many AND at what depth I implemented data structures
 *      in a week and first time in java and not understanding in c++
 *
 *      still so much more to do, searching and sorting algorithms
 *      and revisiting and timing god dam
 *
 *
 *      */


public class MyBinarySearchTree<T extends Comparable<T>> {

    private static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        public Node(T data) {
            this.data = data;
        }
    }

    Node<T> root;

    public void insert(T data) {
        root = insert(data, root);
    }


    private Node<T> insert(T data, Node<T> root) {
        if (root == null) { // if i insert same it will insert here
            return new Node<>(data);
        } else if (root.data.compareTo(data) > 0) { // root.data is 4 data is 1. 4 - 1 > 0 so root.data is bigger, put data left
            root.left = insert(data, root.left);
        } else if (root.data.compareTo(data) < 0) { // root.data - data < 0 then root.data is smaller so go right with data
            root.right = insert(data, root.right);
        }
        return root;
    }

    public boolean contains(T data) {
        return contains(data, root);
    }

    private boolean contains(T data, Node<T> root) {
        if (root == null) {
            return false;
        } else if (root.data.compareTo(data) == 0) {
            return true;
        } else if (root.data.compareTo(data) > 0) {
            return contains(data, root.left);
        } else {
            return contains(data, root.right);
        }
    }

    public void delete(T data) {
        if (!contains(data)) return;

        // find it
        // change connections
        // if leaf, just go to parent and set child to null
        // if on top
        // if in middle
        // wow is this worth it?
    }
}





