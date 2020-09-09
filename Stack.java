/**
 *
 * @param <E> genertic
 *
 *  core operations on a stack that can be implementd using array or linkedlist using FIFO
 *
 *           wouldn't a user want to know size of stack? how is that not core?
 *           or does size not matter?
 */

public interface Stack<E> {
    void push(E element);
    void pop();
    E peek();
    boolean isEmpty();
}
