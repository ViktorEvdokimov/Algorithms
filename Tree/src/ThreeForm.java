public interface ThreeForm<E extends Comparable<? super E>> {
    enum TraversMode {
        IN_ORDER,
        PRE_ORDER,
        POST_ORDER
    }
    void add (E value);
    boolean remove (E value);
    boolean isEmpty();
    boolean contains (E value);
    int size ();
    void display();
    void travers (TraversMode mode);
}
