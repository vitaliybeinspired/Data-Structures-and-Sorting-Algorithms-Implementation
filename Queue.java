

public interface Queue<T> {
    void enqueue(T item);
    void dequeue();
    boolean isEmpty();
    T front();
    T back();

}
