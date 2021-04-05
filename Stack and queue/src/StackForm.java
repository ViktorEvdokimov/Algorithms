public interface StackForm<E> {
    void push (E value);
    E pop ();
    boolean isEmpty();
    int size();
    E peek();
    void display();
    boolean isFill ();
}
