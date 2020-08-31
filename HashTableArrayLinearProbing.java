/**
 * so thats how it works, if i try to put a key, value at index 2 and it's taken, i have to place it below!
 *
 *
 * This casting T on object is new to me why? it worked in c++
 * and why haven't i seen it elsewhere? everyone uses ints?
 *
 * in interview it would be better to use generic?
 *
 */

// writing this from scratch feels so good, i actually understand <K, V> generic parameterS!!!!

public class HashTableArrayLinearProbing<K, V> implements HashTable<K, V> {

    // so is it just array[]? every index has <K, V> ?
    // or array[][] thats 2 columsn, many rows? never seen 2d array


    Object[] hashTable = new Object[10];


    public void put(K key, V value) {

    }

    public K getKey(K key) {
        return null;
    }

    public V getValue(V value) {
        return null;
    }

    public boolean containsKey(K key) {
        return true;
    }

    public boolean containsValue(V value) {
        return true;
    }

}
