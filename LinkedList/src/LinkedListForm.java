import java.util.Iterator;

public interface LinkedListForm<E> {
    Iterator iterator();

    void insertFirst(E value);
    E removeFirst();
    boolean remove (E value);
    boolean contains (E value);
    boolean isEmpty ();
    void display ();
    E peekFirst ();


    class Node<E>{
         E data;
         Node<E> nextNode;

         public Node(E data, Node<E> nextNode) {
             this.data = data;
             this.nextNode = nextNode;
         }
     }

}
