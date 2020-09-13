package DataStructures;


/**
 *
 * @param <E> genertic
 *
 *  core operations on a stack that can be implementd using array or linkedlist using FIFO
 *
 *           wouldn't a user want to know size of stack? how is that not core?
 *           or does size not matter?
 *
 *           i have to follow convention
 *           it might be an exception to the rule just here so be flexible
 *
 */

public interface MyStack<E> {
    void push(E element);
    E pop();
    E peek();
    boolean isEmpty();
}
