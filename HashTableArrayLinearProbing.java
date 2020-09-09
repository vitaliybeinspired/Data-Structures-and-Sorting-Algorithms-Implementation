/**
 * so thats how it works, if i try to put a key, value at index 2 and it's taken, i have to place it below!
 *
 *
 * This casting T on object is new to me why? it worked in c++
 * and why haven't i seen it elsewhere? everyone uses ints?
 *
 * in interview it would be better to use generic?
 *
 *
 *     /**
 *      * 31x + y rule
 *      *
 *      * private int has(String string) {
 *      *     int hash = 0;
 *      *     for (int i = 0; i < string.length(); i++) {
 *      *         hash += 31 * hash + string.charAt(i);
 *      *
 *      *     }
 *      *
 *      *     // no overflow protectin??
 *      * }
 *      *
 *         private int hashString(String key){
 *         int hashVal = 0;
 *         for (int i = 0; i < key.length(); i++) {
 *             hashVal += 37 * key.charAt(i);
 *         }
 *         hashVal %= capacity;
 *         if (hashVal < 0) {  // in case overflows occurs
 *             hashVal += capacity;
 *         }
 *         return hashVal;
 *     }
 *
 *
 *
 *  make this dynamic?
 *
 *  if this accepts keys as null then it's a hashmap? no if key == null throw exception fool
 *
 *         // start at hash(key) index. if i find that key then replace the value, why?
 *         // so if key already exists it replaces the value
 *         // but if there is another key in that spot it looks for a different spot.
 *         // so saying ("key1, 10") then ("key1, 15") relaces key1 with 15
 *         // because keys must be unique
 *
 *         // it keeps going until a null value key, means no collision
 *
 *         // linear probing increments, i = (i + 1) and to loop around mod capacity
 *
 *             // prove that 16 elements is best initalie capacity.
 *     // what about 4? that would require frequent resizing and who would want only to put 2 elements!?!?
 *     // this is object so depending on what user selects will affect memory like
 *     // char type vs int
 *     // but for readability say 10? thats for newbs im a pro with memory address knowledge
 *     // do by 8's or 4's or 2's.
 *
 *             // isn't hashCode same for similar letters, how is this effective?
 *         // will cause lots of collisions.
 *         // the and operator masking is only for one case or changes many?
 *
 *         // what will the one in a billion bug do if i don't mask?
 *         // understand it don't just memorize it
 *         // can't use hashCode() on primitivate date type
 *         // but user will have to say Integer object
 *
 *
 // people say resizing should be multiplied by prime number for least collisions
 // also hashCode should be multiplied by prime
 // PRIME IS REQUIRED LIKE RESIZING. i learn a lot about primes so use knowledge to show interviewers
 */

public class HashTableArrayLinearProbing<Key, Value> implements HashTable<Key, Value> {
    private int size;
    private int capacity;
    private Key[] keys;
    private Value[] values;

    public HashTableArrayLinearProbing() {
        this(16);
    }

    public HashTableArrayLinearProbing(int capacity) {
        this.capacity = capacity;
        size = 0;
        keys = (Key[]) new Object[capacity];
        values = (Value[]) new Object[capacity];
    }

    public void put(Key key, Value value) {
        if (key == null || value == null) throw new IllegalArgumentException();

        if (size >= capacity / 2) {
            resize(2 * capacity); // resizing is mandatoring in hashtable
        }

        int probe;
        for (probe = hashCode(key); keys[probe] != null; probe = (probe + 1) % capacity) { // start at index of hashkey, stop until no collisions at null, linear probing +1 and loop around with mod capacity
            if (keys[probe].equals(key)) { // isn't this
                values[probe] = value;
                return;
            }
        }
        keys[probe] = key;
        values[probe] = value;
        size++;
    }

    // hash function for keys - returns value between 0 and capacity - 1
    private int hashCode(Key key) {
        return (key.hashCode() & 0x7fffffff) % capacity; // // returns the integer hash code value of the object. the and operator masking is to prevent -2^31 negative number bug
        // doesn't java have the mask implemented so it won't return bug?
    }

    public boolean containsKey(Key key) {
        return getValue(key) != null;
    }

    public Value getValue(Key key) {
        if (key == null) throw new IllegalArgumentException();
        for (int probe = hashCode(key); keys[probe] != null; probe = (probe + 1) % capacity) {
            if (keys[probe].equals(key)) {
                return values[probe];
            }
        }
        return null;
    }

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException();
        if (!containsKey(key)) return; // why check if key exists?

        // find position i of key
        int probe = hashCode(key);
        while (!key.equals(keys[probe])) {
            probe = (probe + 1) % capacity;
        }

        // delete key and associated value
        keys[probe] = null;
        values[probe] = null;
        size--;

        // halves size of array if it's 12.5% full or less
        if (size > 0 && size <= capacity / 8) resize(capacity / 2);

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // smart to do resize with parameter cuz then i can upsize it or downsize it
    private void resize(int capacity) {
        this.capacity = capacity;
    }
}
