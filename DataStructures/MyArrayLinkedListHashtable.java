package DataStructures;


/**
 *
 * Visualize this as 2 columns, key left column, value right column.
 * The way it puts the key, value into a row is it uses a hashfunction of the key to generate
 * which row index to place the key , value!!!
 *
 * keys are unique but if two same keys then make a list of values of that key?
 *
 * <key, value> or <key, list of values>
 *
 *
 *      * so in linkedlists, there is no collision, i add the collision to end of linked list!
 *
 * aka seperarte chanining! i knew concept but not by this name.
 * seperate chaining is a chain of linkedlists in each array
 *
 *      // oh can't use | because then it would keep the 1 negative lol
 *         // ^ xor will also keep so i have to use & to turn it off
 *         // key.hashCode() can contains all negative numbers too so can't use negative for index
 *         // and using Math.abs(key.hashCode()) can return 1 in a billion negative number -2^31
 *         // so masking with the 0 in front turns off negative numbers
 *         // if i make my own hashCode then i don't need masking since my won't be negative
 *         // but it can cause overflow so then i have to check for that
 *         // to do it by hand i have to know asci values of a-z and A-Z and 0-10
 *         // just know a and A and 0, 3 numbers
 *             // h = 31 * h + (v & 0xff); how java gets int
 *         // h = 31 * h + is familiar forumla
 *         // i have to be able to get hashCode by hand on whiteboard
 *         // which would require gett ASCII values of characters
 */

public class MyArrayLinkedListHashtable<Key, Value> implements MyHashtable<Key, Value> {

    // this is what is stored inside a LinkedList node which has a next pointer
    // i could just make a linkedlist with this kind of node and add next pointer
    // storing objects inside objects is costly.
    private static class Node<Key, Value> {
        Key key;
        Value value;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    private int keyValuePairs; //
    private int capacity; // of array, not linkedlist
    private MyLinkedList[] hashtable;

    public MyArrayLinkedListHashtable() {
        keyValuePairs = 0;
        capacity = 10;
        hashtable = new MyLinkedList[capacity];
    }

    public void put(Key key, Value value) {
        if (key == null || value == null) throw new IllegalArgumentException();
        if (keyValuePairs >= capacity * 10) { // it will always be max 10 average in all linkedlists! keyValuePairs / capacity * 10 will always = 10
            resize(2 * capacity);
        }
        Node<Key, Value> newNode = new Node<>(key, value);
        hashtable[hashCode(key)].add(newNode);
        keyValuePairs++;
    }

    private int hashCode(Key key) {
        return (key.hashCode() & 0x7fffffff) % capacity; // // returns the integer hash code value of the object. the and operator masking is to prevent -2^31 negative number bug
    }

    public Key getKey(Key key) {
        return null;
    }
    public Value getValue(Key value) {
        return null;
    }
    public boolean containsKey(Key key) {
        return true;
    }

    public void delete(Key key) {

    }

    public int size() {
        return 0;
    }

    private void resize(int capacity) {

    }

    public boolean isEmpty() {
        return true;
    }
}
