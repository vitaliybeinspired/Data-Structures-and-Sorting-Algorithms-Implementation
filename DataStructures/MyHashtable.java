package DataStructures;


/**
 * When using a Hashtable, you specify an object that is used as a key, and the value that you want
 * linked to that key. The key is then hashed, and the resulting hash code is used as the index at
 * which the value is stored within the table.

 */

public interface MyHashtable<Key, Value> {
    void put(Key key, Value value);
    Value getValue(Key value);
    boolean containsKey(Key key);
    void delete(Key key);
    int size();
    boolean isEmpty();
}


/**
 what can i use to implement? what does from scratch mean? can i use java linkedlist???
 */