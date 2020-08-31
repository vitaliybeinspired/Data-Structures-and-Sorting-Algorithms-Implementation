import java.util.NoSuchElementException;

/**
 *   // so Node<U> is generic U and in the generic U i'm replacing it with another generic T!!!!!
 *     // good to understand but should I just write T for both?
 *     // or is that why QueueLinkedList should be <E> for element and node <T> for type???
 *     // without IDE, I would have gotten that wrong or mixed up and wrote Node<U> front;
 *     // people don't realize whats happening when both are T, T gets replaced with another T!
 *  i understand but i might make mistake in interview so just write both as T, its convention too CtCI
 *
 *
 *
 *  enqueue:
 *   // maybe it is good to return element because when i pop or dequeue, it means i want to process
 *     // that data! why would I want to remove an element without doing anything to it?
 *     // i would want to remove it and add it to some other data structure.
 *     // still this method is doing 2 things. 1 returns element AND 2 removes element
 *
 *  visualize
 *
 *  front node left side and back node is on right side
 *  so next is going >>>>>>>>>>>
 *
 *  queuearray is  <<<<<<<< direction rotates that way, so front can loop around f<<<<<b then <<<<bf
 *
 *  can i make them all same to visualize easier?
 *  whatever makes the word "next" seem easy to visualize, usually next is to the right
 *  in stack next is going down, so i should use different word or implement it going right but then
 *  its not a stack visually. but interviewer must know concept by word
 *
 *
 *
 *
 *  make sure the code matches what i visualiy see. vision is more powerful then code.
 *  i can turn my vision to code.
 *
 *  whats naturally order?
 *
 *  front <<<<<<<< back movement? rotates left?
 *
 *  how does back.next and front.next both work same visually?
 *
 *  3rd day in a row, getting tired. this isn't even practicing to implement in 10 min but learning.
 *  cuz i never learned it. just knew concept. and wrote in c++
 *  and have design questions that i had to resolve :)
 *
 *  but look how quick and simple it is. i just need to BELIEVE it first.
 *
 *  VISUALIZE. BELIEVE IMPLEMENTATION. QUICK ACCURACY. MY CODE.
 *
 *
 *  visualize means the order is natural, the movement is natural, and i can see how it changes
 *  believe means i know this is the best way to write the code
 *  quicky qccuracy means write it in 5 to 10 min with no compile errors or bugs and edge cases and exceptions
 *  my code means how it makes sense to me so i can remember forever and write in other languages,
 *  if i memorize concie elegant code from others but not understand how it works, i wont know how to
 *  implement it in interviews
 *
 *
 *  code is easy simple fast but took a lot of time to visualize and believe implementation and
 *  write my own style and tried to modify others to change my style like variable names and sometimes
 *  i thought i did better but made it worst so now i understand.
 */



public class QueueLinkedList<T> implements Queue<T> {

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> front, back;
    private int size = 0;


    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);
        if (back != null) {
            back.next = newNode;
        }
        back = newNode;
        if (front == null) { // for first node
            front = back;
        }
        size++;
    }
   
    public void dequeue() {
        if (front == null) throw new NoSuchElementException();
        front = front.next;
        if (front == null) { // for last node
            back = null;
        }
        size--;
    }

    public T front() {
        return front.data;
    }

    public T back() {
        return back.data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }
}
