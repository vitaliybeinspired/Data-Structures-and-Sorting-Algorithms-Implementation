/**
 *
 * visualize the queue front on the left and the back on the right
 * this visualizing can change later on
 *
 * visualize dequeing from the front so front variable changes
 * visualize queuing to the back so back varabile changes
 *
 * <<<<<<<< direction rotates that way, so front can loop around f<<<<<b then <<<<bf
 *
 * This implementation is genius. It doesn't shift ALL elements in queue
 * if I dequeue, it just moves rear or front pointer! Few interviewrs can do this!
 * I have to communicate how its done and how its efficent to interviewr.
 *
 * Decided, dynamic resize or limit size set by user?
 *
 * pro knowledge interview: explain how this implementation doesn't shift elements but
 * moves front and rear pointers
 */

public class QueueArray<T> implements Queue<T> {
    private T[] queue;
    private int rear;
    private int front;
    private int count;
    private int size;

    public QueueArray(int size) {
        this.size = size;
        queue = (T[]) new Object[size];
        rear = size - 1;
        front = 0;
        count = 0;
    }

    public void enqueue(T item) {
        if (!isFull()) {
            rear = (rear + 1) % size;
            queue[rear] = item;
            count++;
        }
    }

    public void dequeue() {
        if (!isEmpty()) {
            front = (front + 1) % size;
            count--;
        }
    }

    public T front() {
        return queue[front];
    }

    public T back() {
        return queue[rear];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == size;
    }
}
