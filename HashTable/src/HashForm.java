public interface HashForm<K, V> {

    boolean put (K key, V value);
    V remove (K key);
    V get (K key);
    boolean isEmpty();
    int size ();
    void display();

    interface ItemForm<K, V> {
        K getKey();
        V getValue();
    }

}
