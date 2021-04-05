public class MyStack<E> implements StackForm<E>{
    private E[] data;
    private int size=0;
    private int capacity;
    private final int  DEFAULT_MAX_LENGTH = 100;

    public MyStack() {
        this.capacity=DEFAULT_MAX_LENGTH;
    }

    @SuppressWarnings("unchecked")
    public MyStack(int capacity) {
        this.capacity = capacity;
        this.data = (E[]) new Object[capacity];
    }

    @Override
    public void push(E value) {
        if (size==capacity){
            System.out.println("Stack is full");
            return;
        }
        data[size++] = value;
    }


    @Override
    public E pop() {
        return data[--size];
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public E peek() {
        return data[size-1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void display() {
        System.out.print("[");
        for (int i=0;i<size-1;i++) {
            System.out.print(data[i] + ", ");
        }
        System.out.println(data[size-1]+"]");
    }

    @Override
    public boolean isFill() {
        return size==capacity;
    }
}
