import java.util.Arrays;

public class ArrayBuilder<E extends Comparable<? super E>> implements ArrayModel<E>{
    private E[] data;
    private int size;
    private final int DEFAULT_CAPACITY = 100;
    int capacity;

    @Override
    public boolean isEmpty() {
        return size>0;
    }

    public void bubbleSorting () {
        for (int i=0; i<size-1;i++){
            for (int j=1; j<size-i;j++){
                if (data[j].compareTo(data[j-1])<0){
                    switchData(j,j-1);
                }
            }

        }
    }

    public void sortSelect (){
        for (int i=0;i<size-1;i++){
            E minValue = data[i];
            int minIndex = i;
            for (int j=i+1; j<size;j++){
                if(data[j].compareTo(minValue)<0){
                    minValue=data[j];
                    minIndex=j;
                }
            }
            switchData(minIndex,i);
        }
    }

    public void sortInsert (){
        for (int i=1; i<size;i++){
            if (data[i].compareTo(data[i-1])<0){
                E temp = data[i];
                for (int j=i-1;j>=0;j--){
                    if (j==0) {
                        data[j+1]=data[j];
                        data[j]=temp;
                    }
                    else if(data[j].compareTo(temp)<0){
                        data[j+1]=temp;
                        j=-1;
                    } else {
                        data[j+1]=data[j];
                    }
                }
            }
        }
    }

    public void switchData (int indexMin, int indexMax){
        E temp = data[indexMin];
        data[indexMin]=data[indexMax];
        data[indexMax]=temp;
    }

    @Override
    public void display() {
        StringBuilder sb = new StringBuilder("[");
        for (int i=0; i<(size-1); i++){
            sb.append(data[i]);
            sb.append(", ");
        }
        if (size>0) sb.append(data[size-1]);
        sb.append("]");
        System.out.println(sb.toString());
        System.out.println("Size: " + size);
    }

    @Override
    public int size() {
        return size;
    }

    public ArrayBuilder() {
        this.size=DEFAULT_CAPACITY;
    }

    @SuppressWarnings("unchecked")
    public ArrayBuilder(int capacity) {
        this.data = (E[]) new Comparable[capacity];
    }

    @Override
    public void add(E value) {
        if (data.length==size) increaseSize();
        data[size]=value;
        size++;
    }

    @Override
    public boolean remove(E value) {
        int i = search(value);
        return remove(i);
    }

    @Override
    public boolean remove(int index) {
        if (index<size && index>=0) {
            System.arraycopy(data, index+1, data, index, size - index - 1);
            data[--size]=null;
            return true;
        }
        return false;
    }

    @Override
    public int search(E value) {
        for (int i=0; i<size; i++){
            if (data[i].compareTo(value)==0){
                return i;
            }
        }
        return -1;
    }

    private void increaseSize (){
        if (data.length<=0) capacity=1;
        else {
            @SuppressWarnings("unchecked") E[] newData = (E[]) new Comparable[data.length+100];
            System.arraycopy(data,0,newData,0,data.length);
            data = newData;
        }
    }
}
