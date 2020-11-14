import DataStructures.MyBinarySearchTree;
import DataStructures.MyTreeNode;

import java.util.ArrayList;
import java.util.List;

import java.util.Arrays;
import java.util.Hashtable;

/**
 *
 * Data Structures to implement:
 *
 * LinkedList so then I can use it in HashTableArrayLinkedList
 * Heap ADT, implement heap in array AND nodes?
 * Arraylist (obv array only)
 * BinaryTree
 * Graph
 * implement my own stringbuilder like book recommends
 *
 *
 */

public class Client {

    public static void main(String[] args) {

//
//        MyBinarySearchTree a = new MyBinarySearchTree();
//        a.insert("a");
//        a.insert("d");

        MyBinarySearchTree<Integer> a = new MyBinarySearchTree<>();
        a.insert(4);
        a.insert(1);
        a.insert(9);
        a.insert(-4);
        a.insert(232);
        a.insert(7);
        a.insert(6);
        a.insert(1);
        if (a.contains(-4)) {
            System.out.println("da");
        } else {
            System.out.println("net");
        }
        if (a.contains(234)) {
            System.out.println("da");
        } else {
            System.out.println("net");
        }










        MyTreeNode<String> root = new MyTreeNode<>("Root");

        MyTreeNode<String> child1 = new MyTreeNode<>("Child1");
        child1.addChild("Grandchild1");
        child1.addChild("Grandchild2");

        MyTreeNode<String> child2 = new MyTreeNode<>("Child2");
        child2.addChild("Grandchild3");

        root.addChild(child1);
        root.addChild(child2);
        root.addChild("Child3");

        root.addChildren(Arrays.asList(
                new MyTreeNode<>("Child4"),
                new MyTreeNode<>("Child5"),
                new MyTreeNode<>("Child6")
        ));

        for (MyTreeNode<String> node : root.getChildren()) {
            System.out.println(node.getData());
        }
    }
}
