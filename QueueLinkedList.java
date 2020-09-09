import java.util.NoSuchElementException;

/***
 *  VISUALIZE. BELIEVE IMPLEMENTATION. QUICK ACCURACY. MY CODE.

 *  This is unlimited capacity queue using nodes that tracks size.
 *
 *  Visualize front pointer on the left and back pointer on the right. Enqueue by ADDING node to the back.
 *  Dequeue by MOVING front pointer to the right.
 *
 *  what is the point of this queue? it's just a linkedlist
 *  cuz this doesn't allow removing/adding to middle
 *  just uses some linkedlist methods
 */

public class QueueLinkedList<T> implements Queue<T> {
    LinkedList<T> queue = new LinkedList<>();

    public void enqueue(T item) {
        queue.insert(item);
    }
   
    public void dequeue() {
        queue.delete();
    }

    public T getFront() {
        return queue.getFirst();
    }

    public T getBack() {
        return queue.getLast();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.getSize();
    }
}
