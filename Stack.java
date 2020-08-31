public interface Stack<T> {
    void push(T data);
    void pop();
    T peek();
    boolean isEmpty();
}
