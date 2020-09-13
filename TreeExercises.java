
public class TreeExercises {

    private static class Node {
        int data;
        Node left;
        Node right;
    }

    /**
     * to build a tree, when i dequeue, set the root to the temp(getFront)
     *
     * then
     *
     */

    // visualize it traverse like slanted E to the right
    // starts at root then goes left to right then next row

//    public int countNodesIteratively(Node root){
//        if(root == null)
//            return 0;
//
////        QueueLinkedList<Node> queue = new QueueLinkedList<>();
////        int count = 0;
////
////        queue.enqueue(root);
////        while(!queue.isEmpty()){
////            count++;
////            Node temp = queue.getFront(); // root = queue.getFront()
////            // how does temp work if i didn't construct it?
////            // Node temp = new Node();
////            // temp = queue.getFront();
////            queue.dequeue(); // set root to this to build tree
////            if(temp.left != null)
////                queue.enqueue(temp.left); // root.left is this
////            if(temp.right != null)
////                queue.enqueue(temp.right); // root.right is this
////        }
////        return count;
//    }

    public int countNodesRecursively(Node pnode){
        if(pnode != null){
            return 1 + countNodesRecursively(pnode.left)
                    + countNodesRecursively(pnode.right);
        }
        return 0;
    }

    public int countInternalNodes(Node root){
        if(root == null)
            return 0;
        else if(root.left != null || root.right != null)
            return 1 + countLeaves(root.left) + countLeaves(root.right);
        else
            return countLeaves(root.left) + countLeaves(root.right);
    }

    public int countLeaves(Node root){
        if(root == null)
            return 0;
        else if(root.left == null && root.right == null)
            return 1;
        else
            return countLeaves(root.left) + countLeaves(root.right);

    }
}
