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
 *
 *
 *
 * THERE IS NO POINT IN USING DYNAMIC ARRAY IN STACK AND QUEUE!!!
 * purpose of array is instant access to any element but in stack it's only top
 * and in queue its front and back only.
 *
 * so i would use linked list for dynamic.
 *
 * ArrayList is dynamic because user wants to access any element in O(1)
 */

public class QueueArray<T> implements Queue<T> {
    private final T[] queue;
    private int rear;
    private int front;
    private int count;
    private final int capacity;

    public QueueArray(int capacity) {
        this.capacity = capacity;
        queue = (T[]) new Object[capacity];
        rear = capacity - 1;
        front = 0;
        count = 0;
    }

    public void enqueue(T item) {
        if (!isFull()) {
            rear = (rear + 1) % capacity;
            queue[rear] = item;
            count++;
        }
    }

    public void dequeue() {
        if (!isEmpty()) {
            front = (front + 1) % capacity;
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
        return count == capacity;
    }
}
