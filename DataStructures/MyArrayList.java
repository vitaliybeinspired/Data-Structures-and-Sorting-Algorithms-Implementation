package DataStructures;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Visiulize
 *
 * core operations in interview vs extra
 *
 * Explain to interviewer all the elegant performance tricks like
 *for (int i = index; i < size - index - 1; i++) { // better than i < list.length! explain in interview
 * because don't need to move empty element all the way on the right
 *
 * Theres a reason why java uses T and E sometimes
 *
 *
 * i will have muscle quick memory which every way i choose so choose wisely don't try to be too clever
 * or it will backfire.
 *
 * E for array, T for nodes
 *
 * innstance Variables (Non-Static Fields) Technically speaking, objects store their individual
 * states in "non-static fields", that is, fields declared without the static keyword.
 * Non-static fields are also known as instance variables because their values are unique
 * to each instance of a class (to each object, in other words); the currentSpeed of one bicycle
 * is independent from the currentSpeed of another.
 *
 * Class Variables (Static Fields) A class variable is any field declared with the static modifier;
 * this tells the compiler that there is exactly one copy of this variable in existence,
 * regardless of how many times the class has been instantiated. A field defining the number
 * of gears for a particular kind of bicycle could be marked as static since conceptually the
 * same number of gears will apply to all instances. The code static int numGears = 6;
 * would create such a static field. Additionally, the keyword final could be added to
 * indicate that the number of gears will never change.
 */

public class MyArrayList<E> {
    // finals are in all caps?
    // private static final int SIZE = 2;

    private E[] arrayList; // this should be all caps??
    private int size;
    private int capacity;

    public MyArrayList() {
        arrayList = (E[]) new Object[10]; // prove how much space generic type takes before initlizing
        size = 0;
        capacity = 10;
    }

    public void add(E element) {
        if (size == capacity) {
            resize(capacity *= 2);
        }
        arrayList[size++] = element;
    }

    public void add(E element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == capacity) {
            resize(capacity *= 2);
        }
        for (int i = size; i >= index; i--) {
            arrayList[i + 1] = arrayList[i];
        }
        arrayList[index] = element;
        size++;
    }

    public void replaceAt(E element, int index) {
        if (index < 0 || index > size) { // why can't i add at end? why does it have to be in order?
            throw new IndexOutOfBoundsException();
        }
        arrayList[index] = element;
    }

    private void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        System.arraycopy(temp, 0, arrayList, 0, arrayList.length);
        arrayList = temp;
    }

    public void deleteLast() {
        if (isEmpty()) throw new NoSuchElementException();
        size--; // just move size pointer
    }

    public void deleteAt(int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();

        for (int i = index; i < size - index - 1; i++) {
            arrayList[index] = arrayList[index + 1];
        }
        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int index) {
        return arrayList[index];
    }
}

















