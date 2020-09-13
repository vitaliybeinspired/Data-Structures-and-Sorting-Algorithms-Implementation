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

    public static class TreeNode {
        int val;
        Solution.TreeNode left;
        Solution.TreeNode right;

        TreeNode() {

        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, Solution.TreeNode left, Solution.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
//        MyHashtable<String, Integer> ht = new MyArrayLinearProbingHashtable<>();
//        ht.put("hi", 2);
//        ht.put("bye", 3);
//        ht.put("again", 4);
//        ht.put("yoyo", 18);
//        ht.put("ih", 2);
//        ht.put("yeb", 3);

        String ab = "ab";
        int a = ab.hashCode();

        String ba = "ba";
        int b = ba.hashCode();




    }
}
