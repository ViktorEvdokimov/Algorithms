public interface QueueForm<E> {
    void insert (E value);
    E remove ();
    E peek();
    boolean isEmpty ();
    boolean isFull ();
    int size();
    void display();
}
