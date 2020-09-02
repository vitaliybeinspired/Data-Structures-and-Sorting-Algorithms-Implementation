///**
// *
// * Visualize this as 2 columns, key left column, value right column.
// * The way it puts the key, value into a row is it uses a hashfunction of the key to generate
// * which row index to place the key , value!!!
// *
// * keys are unique but if two same keys then make a list of values of that key?
// *
// * <key, value> or <key, list of values>
// *
// *
// *      * so in linkedlists, there is no collision, i add the collision to end of linked list!
// *
// *
// */
//
//public class HashTableArrayLinkedList<K, V> implements HashTable<K, V> {
//
//    // <Generic Type, LinkedList>
//
//    Object[][] hashTable = new Object[2][100]; // first is row then column?
//
//    // doesn't make sense to store linkedlists of keys and values....
//    private static class Node<K, V> {
//        K key;
//        V value;
//        Node<K, V> next; // why is this not U next like U data?
//
//        private Node(K key, V value) {
//            this.key = key;
//            this.value = value;
//        }
//    }
//
//    // so i need an array that stores keys and linkedlists
//    // wait i need two parameters
//
//    public void put(K key, V value) {
//
//    }
//    public K getKey(K key) {
//        return null;
//    }
//    public V getValue(V value) {
//        return null;
//    }
//    public boolean containsKey(K key) {
//        return true;
//    }
//    public boolean containsValue(V value) {
//        return true;
//    }
//
//
//
//}
