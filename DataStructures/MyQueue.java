package DataStructures;

// java names it like this so I have to otherwise I won't solve in interview or tests using javas
// no reason to get back, only insert to it
// i like these names better anyways
// i'm going to get dummer if i don't follow java's naming conventions and return values
// i'm having a huge conflict with what i learn in class vs whats in the real world
// professor teaching me names and different return values.

// SO THIS IS A ADT THAT USES DT
// when it uses DT, it only uses part of those methods, weird

public interface MyQueue<E> {
    void add(E item); // boolean to see if i can add, limit
    E remove();
    boolean isEmpty();
    E peek();
}
