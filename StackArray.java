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
 */

import java.util.EmptyStackException; // i would need to remember to write this in docs or online code

public class StackArray<T> implements Stack<T> {
    int top;
    int max;
    T[] stack;

    public StackArray() {
        stack = (T[]) new Object[15];
        max = 10;
        top = 0;
    }

    public StackArray(int max) {
        super(); // everything in default gets excuted then goes bellow???
        this.max = max;
    }

    public void push(T data) {
        if (isFull()) {
            resize();
        }
        stack[top++] = data;
    }

    // or make a size in constructor?
    // either fixed size at constructer with full method or dynamic resize with no full limit
    private void resize() { // resize is optional during interview or quickly do it?
        T[] temp = (T[]) new Object[max << 1];
        for (int i = 0; i < stack.length; i++) {
            temp[i] = stack[i];
        }
        stack = temp;
    }


    public void pop() {
        if (isEmpty()) throw new EmptyStackException();
        top--;
    }

    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return stack[top - 1];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public boolean isFull() {
        return top == max;
    }

}
