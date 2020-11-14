import java.util.Arrays;

/**
 * // buffer is a temporary memory area in which data is stored
 * // while it is being processed or transferred. since this IS temporary used for strings
 * // thats why it's called buffer! makes sense once i know definition like auxillary is support also temp?
 * // so yes it is capacify but the capacity is temp, it then returns or makes a string at the end
 * <p>
 * public void append(Object item) { // what is object?
 * String string = item.toString();
 * while (resizeRequired(string)) {
 * resizeBuffer();
 * }
 * addString(string);
 * updateCharCount(string.length());
 * }
 * <p>
 * // 3 constructuers, empty capacity, intialize then append array, intialize then append string
 * // 2 ways to add, char array or string so 2 methods for each type
 * <p>
 * // learn the parameters of arraycopy it's common and useful. prevents for loop manual.
 * <p>
 * is this class being append just good enough?
 */

public class MyStringBuilder {

    private char[] charArray;
    private int capacity;
    private int size;

    public MyStringBuilder() {
        capacity = 16;
        charArray = new char[capacity];
    }

    public MyStringBuilder(int capacity) {
        this.capacity = capacity;
        charArray = new char[capacity];
    }

    public MyStringBuilder(char[] str) {
        this();
        append(str);
    }

    public MyStringBuilder(String str) {
        this();
        append(str);
    }

    public void append(String string) {
        append(string.toCharArray());
    }

    public void append(char[] stringArray) {
        while (isFull(stringArray)) {
            resize();
        }
        System.arraycopy(stringArray, 0, charArray, size, stringArray.length);
        size += stringArray.length;
    }

    private boolean isFull(char[] stringArray) {
        return size + stringArray.length > capacity;
    }

    private void resize() {
        capacity *= 2;
        char[] temp = new char[capacity];
        System.arraycopy(charArray, 0, temp, 0, size);
        charArray = temp;
    }

    @Override
    public String toString() {
        char[] temp = new char[size];
        System.arraycopy(charArray, 0, temp, 0, size); // to make length same as concatenating
        return String.valueOf(temp);
    }

    public void delete(int start, int end) { // end is exclusive cuz if one char then 0 1
        if (start > size || end < 0 || end == size + 1 || end > start) throw new IndexOutOfBoundsException();
        // end can equal size cuz one extra for end is exclusive
        if (start == 0 || end == size) {
            // i can shift all at once
            // otherwise i have to shift one at a time or make 2 big shifts and add together?
        }
        for (int i = 0; i < end - start; i++) {
            deleteCharAt(start);
        }
    }

    public void deleteCharAt(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if (size != 1 && index != size - 1) { // need first or last char edge cases otherwise arraycopy will through out of bounds if i try to shift from capacity + 1 or to -1 index by deleting first char
            System.arraycopy(charArray, index + 1, charArray, index, size - index);
        }
        size--;
    }
}

