package DataStructures;


/**
 *  Blocking vs Static naming. Interviewer needs to know concept but if I name it differently...
 *
 *  throwing exceptions is required for edge cases, can't ignore it.
 *
 *  Stack array for capacity limit.
 */






/**
 * Quick interview refresher.
 *
 * Visualize. Formulas. Design Choice. Pro knowledge.
 *
 * Visual array stack vertically, 0 index on bottom and top is highest index
 *
 * Don't need to delete elements, just move pointer down.
 *
 * Resizing is optional, I can just initiate a large size array
 *
 * if i didn't know this simple implementation from CtCI, I would have done next and prev! so how do i know
 *  * I made array stack good?
 * I HAVE TO MAKE POP REMOVE FOR OPERATOINS LIKE queue.add(stack.pop) in while look or for loop
 *
 * queue.add(stack.peek)
 * stack.pop()
 *
 * pro knowledge: initialize array with 16 elements (size 15) because computer memeory one line is 8 byes
 * so 2 integers per line and takes up 8 lines
 *
 *  users can call stack.length built in to check size??? or that won't give amount of elements...
 *
 *  blocking queue means there is a limit to queue?
 *  if it dynamically resizes then user can't set queue limit.
 *
 *  pro knowledge: write and explain how this is faster, directly moving bits
 *  max = max << 1; same as max = max * 2
 *  max = max >> 1; same as max = max / 2
 *  max = max << 1; "max shifted left once, multiplity value by 2
 *  max = max >> 1; "max shifted right once, dividing the value by 2
 *
 *
 *  Design choice trade offs: Allow limit or dynamically resize?
 *  if user knows limit like only 16 can be queued then allow limit
 *  if user wants limit like 16 max people in line then allow limit
 *  if user just wants to use stack for efficency, then dynamically resize
 *
 *  if limit, i need isFull()
 *  in limitless, i need resize()
 *
 *  WAIT IF LIMITLESS SIZE THEN USE LINKEDLIST???
 *
 *  pro knowledge interview: ask interviewer which one and explain trade offs.
 *
 *  can i combine both using boolean? 2 constructors, defaul dynamic, parameter limit
 *
 *
 *  don't understand calling constructers from constructors
 *  this(); calls itself or same constructor with same paramters?
 *  super(); calls default constuer?? syntax difference vs calling super class method?
 *
 *  this is going off track, i'll get demotivated if i don't finish implementing
 *
 * why blocking not static?
 *
 * IF USER KNOWS SIZE WHY NOT ARRAY BLOCKING?
 * IF USER DOESN'T KNOW SIZE WHY NOT LINKEDLISTS?
 *
 * WHY DO I EVEN HAVE BLOCKING ARRAY?
 *
 * THESE ARE DESIGN CHOICE TRADE OFF QUESTIONS.
 *
 * dynamic array seems really inefficent. resizing is not good.
 *
 */

/**
 *
 * was i doing all these generics wrong? is it T in c++ but Object in java?
 * do i replace all T with object? no cuz arraylist had E but E is for element not object!!!!
 */

import java.util.EmptyStackException; // i would need to remember to write this in docs or online code

public class MyStackArray<E> implements MyStack<E> {
    private int top;
    private final int capacity;
    private final E[] stack;

    public MyStackArray(int capacity) {
        stack = (E[]) new Object[capacity];
        this.capacity = capacity;
        top = 0;
    }

    public void push(E element) {
        if (isFull()) throw new ArrayIndexOutOfBoundsException();
        stack[top++] = element;
    }

    public E pop() {
        if (isEmpty()) throw new EmptyStackException();
        return stack[--top];
    }

    public E peek() {
        if (isEmpty()) throw new EmptyStackException();
        return stack[top - 1];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public boolean isFull() {
        return top == capacity;
    }

}
