public class BinaryTree<T> {

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

    public BinaryTree() {
        root = null;
    }

    // how do i choose which side to add if it's not a search tree?
    // why would i create a binaryTree?

}
