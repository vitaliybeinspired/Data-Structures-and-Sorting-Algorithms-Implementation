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
 */

public class HashTableArrayLinkedList<Key, Value> implements HashTable<Key, Value> {
    private static class Node<Key, Value> {
        Key key;
        Value value;
        Node<Key, Value> next; // why is this not U next like U data?

        private Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size; // if linkedlist gets too long
    private int capacity;
    private Key[] keys;
    private Value[] values;

    private Object[] hashTable =  new Object[10];

    // so i need an array that stores keys and linkedlists
    // wait i need two parameters

    public void put(Key key, Value value) {

        if (key == null || value == null) throw new IllegalArgumentException();

        // 1 get hashCode(key) to find which index to put into
        // then see if that index is null, if not, traverse linedlist until null then add new node <K, V>


        int probe = hashCode(key);

        for (probe = hashCode(key); keys[probe] != null; probe = (probe + 1) % capacity) { // start at index of hashkey, stop until no collisions at null, linear probing +1 and loop around with mod capacity


        }
        Node<Key, Value> newValue = new Node<>(key, value);
        keys[probe] = key;
        hashTable[0] = newValue; // but instead of replacing i need to traverse linkedlist until null
                //values[probe] = newValue;
        size++;
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

    public boolean isEmpty() {
        return true;
    }


}
