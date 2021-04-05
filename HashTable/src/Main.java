import javax.print.attribute.IntegerSyntax;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        MyHashTable<String, Integer> myHashTable = new MyHashTable<>(5);
        myHashTable.put("Item1", 50);
        myHashTable.put("Item2", 40);
        myHashTable.put("Item3", 240);
        myHashTable.put("Item4", 10);
        myHashTable.put("Item5", 2);
        myHashTable.put("Item6", 71);
        myHashTable.put("Item7", 72);
        myHashTable.put("Item8", 43);
        myHashTable.put("Item9", 723);
        myHashTable.put("Item10", 55);
        myHashTable.put("Item2", 30);
        myHashTable.display();

        System.out.println(myHashTable.get("Item2"));
 //       System.out.println(myHashTable.get("Itemm1"));
        System.out.println(myHashTable.remove("Item5"));
        myHashTable.display();

    }
}
