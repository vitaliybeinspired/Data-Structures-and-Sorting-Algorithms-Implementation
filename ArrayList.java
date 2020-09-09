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
 * size word is ambiguous, can mean capacity? or is it just me. when i was learning it was confusing.
 *
 * even though i like elements instead of size, the real arraylist uses size so i need to get used to it
 * but this is my own, how i understand it. but then i will have to think and might get confused
 * when i use the real one. so i have to follow convention to understand cuz then i will know concepts
 * but not when people use a different name for it
 *
 * when people call size() they want number of elements not lenght/capacity of arraylist
 * so what about capcity? should it be length? both good
 * length makes sense cuz thats what method names are in java
 *
 * E for element offical but does it make senese to me? E is for Integer, String objects
 * those are elements? or types? or objects
 * wait can't do primitive types with generics
 * is it good i'm learning this way?
 *
 * Theres a reason why java uses T and E sometimes
 *
 * // i'm trying too hard, wasting time. It's all convention, make E or T go with E like java
 * element makes sense cuz element can be any type.
 * but this is called generic... element is generic
 *
 * client will be able to use comparision operators right? cuz client will declare element type
 *
 * all examples i see online who primitive especially int
 * in interview or leetcode, what will they show?
 * like hackerrank will give questions and i will have to do ints
 * might forget if i work with generics all the time.
 * what is the trade off of generics? why do i ALWAYS need them? i don't, objects expensive
 *
 * i will have muscle quick memory which every way i choose so choose wisely don't try to be too clever
 * or it will backfire.
 *
 * but it's weird to create arraylist of type ints what about String thats object can be E
 */
public class ArrayList<E> {
    private E[] arrayList;
    private int size;
    private int capacity;

    public ArrayList() {
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
        for (int i = 0; i < arrayList.length; i++) {
            temp[i] = arrayList[i];
        }
        arrayList = temp;
    }

    public void deleteLast() {
        if (isEmpty()) throw new NoSuchElementException();
        size--; // just move size pointer
    }

    // must shift all right of index to left
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

















