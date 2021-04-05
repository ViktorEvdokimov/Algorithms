import java.util.Optional;

public class MyDeque<E> implements DequeForm<E> {
    private E[] data;
    int size;
    private int capacity;
    private final int  DEFAULT_MAX_LENGTH = 100;
    int left=0;
    int right=-1;

    public MyDeque() {
        this.capacity=DEFAULT_MAX_LENGTH;
    }

    @SuppressWarnings("unchecked")
    public MyDeque(int capacity) {
        this.capacity = capacity;
        this.data = (E[]) new Object[capacity];
    }

    @Override
    public void insertLeft(E value) {
        if (size==capacity){
            System.out.println("Queue is full");
            return;
        }
        size++;
        if (--left<0) left=capacity-1;
        data[left]=value;
    }


    @SuppressWarnings("unchecked")
    @Override
    public E removeLeft() {
        if (isEmpty()){
            System.out.println("Queue is empty");
            return (E) Optional.empty();
        }
        if(left==capacity) left=0;
        size--;
        E value = data[left];
        data[left++]=null;
        return value;
    }

    @Override
    public void insertRight(E value) {
        if (size==capacity){
            System.out.println("Queue is full");
            return;
        }
        size++;
        if (right++>=capacity) right=0;
        data[right]=value;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E removeRight() {
        if (isEmpty()){
            System.out.println("Queue is empty");
            return (E) Optional.empty();
        }
        if(right<0) right=capacity-1;
        size--;
        E value = data[right];
        data[right--]=null;
        return value;
    }

    @Override
    public E peekLeft() {
        if (isEmpty()){
            System.out.println("Queue is empty");
            return (E) Optional.empty();
        }
        if(left==capacity) left=0;
        return data[left];
    }

    @Override
    public E peekRight() {
        if (isEmpty()){
            System.out.println("Queue is empty");
            return (E) Optional.empty();
        }
        if(right<0) right=capacity-1;
        return data[right];
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

}
