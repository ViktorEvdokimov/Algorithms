import java.util.LinkedList;

public class MyHashTable<K, V> implements HashForm<K, V> {

    private int size;
    private final List<Item<K, V>>[] data;

    @SuppressWarnings("unchecked")
    public MyHashTable(int memorySize) {
        data = new List[memorySize];
    }

    private int hashFunc (K key){
        return key.hashCode() % data.length;
    }

    @Override
    public boolean put(K key, V value) {
        int hashKey = hashFunc(key);
        if (data[hashKey] == null){
            data[hashKey]=new List<>();
            data[hashKey].add(new Item<>(key, value));
            size++;
            return true;
        }
        for (Item<K, V> item : data[hashKey]){
            if (item.getKey().equals(key)){
                item.setValue(value);
                return true;
            }
        }
        data[hashKey].add(new Item<>(key, value));
        size++;
        return true;
    }

    @Override
    public V remove(K key) {
        int hashKey = hashFunc(key);
//        if (data[hashKey] == null){
//            return null;
//        }
        for (Item<K, V> item : data[hashKey]){
            if (item.getKey().equals(key)){
                data[hashKey].remove(item);
                size--;
                if (data[hashKey].size()==0) data[hashKey]=null;
                return item.getValue();
            }
        }
        return null;
    }

    @Override
    public V get(K key) {
        int hashKey = hashFunc(key);
//        if (data[hashKey] == null){
//            return null;
//        }
        for (Item<K, V> item : data[hashKey]){
            if (item.getKey().equals(key)){
                return item.getValue();
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void display() {
        for (int i=0; i<data.length; i++){
            System.out.print(i + ". {");
            if (data[i]!=null) {
                for (Item<K, V> item : data[i]) {
                    System.out.print(" " + item + " ");
                }
            }
            System.out.println("}");
        }
    }

    private class List<Item> extends LinkedList<MyHashTable.Item>{
        LinkedList<Item> list;

        public List() {
            this.list = new LinkedList<>();
        }
    }


    private class Item<K, V>  implements ItemForm<K, V>{

        private final K key;
        private V value;



        public Item(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int hashCode() {
            return key.hashCode();
        }


        @Override
        public String toString() {
            return "Item{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
