public interface ArrayModel<E> {

    void add (E data);
    boolean remove (E data);
    boolean remove (int index);
    int search (E data);
    boolean isEmpty();
    int size();
    void display();
}
