/**
 * so a tree contains an array of children and a binary tree has left and right pointers insted of array
 *
 * i have to understand this it looks so simple and efficent
 */

package DataStructures;

import java.util.List;
import java.util.ArrayList;

public class MyTreeNode<T>{

    private T data;
    private List<MyTreeNode<T>> children = new ArrayList<>();
    private MyTreeNode<T> parent;

    public MyTreeNode(T data) {
        this.data = data;
    }

    public void addChild(MyTreeNode<T> child) {
        child.setParent(this);
        this.children.add(child);
    }

    public void addChild(T data) {
        MyTreeNode<T> newChild = new MyTreeNode<>(data);
        this.addChild(newChild);
    }

    public void addChildren(List<MyTreeNode<T>> children) {
        for(MyTreeNode<T> t : children) {
            t.setParent(this);
        }
        this.children.addAll(children);
    }

    public List<MyTreeNode<T>> getChildren() {
        return children;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private void setParent(MyTreeNode<T> parent) {
        this.parent = parent;
    }

    public MyTreeNode<T> getParent() {
        return parent;
    }
}