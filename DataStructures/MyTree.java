/**
 * this way is interesting, doesn't use arraylist
 */

package DataStructures;

public class MyTree<T> {

    private static class Node<T> {
        public T name;
        Node<T> firstChild; // null of no kids goes down
        Node<T> nextSibling; // sideways
    }

    public Node<T> root;

    // the this thing might be preventing the traverse cuz it will get parent and set it.
    // addChild of what parent, thats why i need to use this?
    public void addChild(T name, T parentOf) {
        Node<T> child = new Node<>();
        child.name = name;
        // traverse tree looking for parent then addChild
    }


}
