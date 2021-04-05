import java.util.Optional;

public class MyQueue<E> implements QueueForm<E> {
    private E[] data;
    int size;
    private int capacity;
    private final int  DEFAULT_MAX_LENGTH = 100;
    int front=-1;
    int tail=0;

    public MyQueue() {
        this.capacity=DEFAULT_MAX_LENGTH;
    }

    @SuppressWarnings("unchecked")
    public MyQueue(int capacity) {
        this.capacity = capacity;
        this.data = (E[]) new Object[capacity];
    }

    @Override
    public void insert(E value) {
        if (size==capacity){
            System.out.println("Queue is full");
            return;
        }
        size++;
        if (++front==capacity) front=0;
        data[front]=value;
            }

    @SuppressWarnings("unchecked")
    @Override
    public E remove() {
        if (isEmpty()){
            System.out.println("Queue is empty");
            return (E) Optional.empty();
        }
        if(tail==capacity) tail=0;
        size--;
        E temp = data[tail];
        data[tail++]=null;
        return temp;

    }

    @Override
    public void display() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (E value : data){
            if (value!= null ) {
                sb.append(value);
                sb.append(", ");
            }
        }
        sb.setLength(sb.length()-2);
        sb.append("]");
        System.out.println(sb.toString());
    }


    @Override
    public E peek() {
        if (isEmpty()){
            System.out.println("Queue is empty");
            return (E) Optional.empty();
        }
        if(tail==capacity) tail=0;
        return data[tail];

    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean isFull() {
        return size==capacity;
    }

    @Override
    public int size() {
        return size;
    }
}
