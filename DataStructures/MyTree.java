package DataStructures;

public class MyTree<T> {

    private static class Node<T> {
        public T data;
        public Node<T>[] children;

        public Node(T data) {
            this.data = data;
            children = (Node<T>[]) new Object[10]; // resize if full
            // why create array? why not nodes?
            // how will i traverse further down? array inside array inside array???
        }

    }

    public Node<T> root;

    public void add(T item) {

    }


}
