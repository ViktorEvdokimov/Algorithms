public interface DequeForm<E> {
    void insertLeft (E value);
    E removeLeft ();
    void insertRight (E value);
    E removeRight ();
    E peekLeft();
    E peekRight();
    boolean isEmpty ();
    boolean isFull ();
    int size();
    void display();
}
