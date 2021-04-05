import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Optional;


public class MyLinkedList<E> implements LinkedListForm<E>, Iterable<E> {

    private int size;
    private Node<E> firstNode;


    @SuppressWarnings("unchecked")
    @Override
    public E peekFirst() {
        return size != 0 ? firstNode.data : (E) Optional.empty();
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    @Override
    public void insertFirst(E value) {
        firstNode = new Node<E>(value, firstNode);
        size++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E removeFirst() {
        if (size == 0) {
            System.out.println("List is empty");
            return (E) Optional.empty();
        }
        Node<E> returnNode = firstNode;
        firstNode = firstNode.nextNode;
        size--;
        return returnNode.data;
    }

    @Override
    public boolean remove(E value) {
        if (size == 0) {
            System.out.println("List is empty");
            return false;
        }
        Node<E> verifiableNod = firstNode;
        Node<E> previousNod = new Node<>(null, null);
        do {
            if (verifiableNod.data == value) {
                if (verifiableNod == firstNode) {
                    removeFirst();
                } else {
                    previousNod.nextNode = verifiableNod.nextNode;
                    verifiableNod.nextNode = null;
                }
                size--;
                return true;
            }
            previousNod = verifiableNod;
            verifiableNod = verifiableNod.nextNode;
        } while (verifiableNod.nextNode != null);
        if (verifiableNod.data == value) {
            previousNod.nextNode = null;
            size--;
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(E value) {
        if (size == 0) {
            System.out.println("List is empty");
            return false;
        }
        Node<E> verifiableNod = firstNode;
        do {
            if (verifiableNod.data == value) {
                return true;
            }
            verifiableNod = verifiableNod.nextNode;
        } while (verifiableNod.nextNode != null);
        return verifiableNod.data == value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> verifiableNod = firstNode;
        do {
            sb.append(verifiableNod.data);
            sb.append(", ");
            verifiableNod = verifiableNod.nextNode;
        } while (verifiableNod.nextNode != null);
        if (size != 0) sb.append(verifiableNod.data);
        sb.append("] Size: ");
        sb.append(size);
        System.out.println(sb.toString());
    }


    private class MyIterator implements Iterator<E> {
        private MyLinkedList.Node<E> lastReturned;
        private MyLinkedList.Node<E> next  = firstNode;
        private int nextIndex;


        public boolean hasNext() {
            return next!=null;
        }

        @SuppressWarnings("unchecked")
        public E next() {
            if (hasNext()) {
                lastReturned = next;
                next = next.nextNode;
                nextIndex++;
                return lastReturned.data;
            } else return (E) Optional.empty();
        }

    }
}
