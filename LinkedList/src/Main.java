import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
	testLinkedList();
    }

    static void testLinkedList (){
        MyLinkedList<Integer> testList = new MyLinkedList<>();
        System.out.println(testList.peekFirst());
        testList.insertFirst(1);
        testList.insertFirst(2);
        testList.insertFirst(3);
        testList.insertFirst(4);
        testList.insertFirst(5);
        testList.insertFirst(6);
        testList.insertFirst(7);
        testList.display();
        for (Object data : testList){
            System.out.println(data);
        }
        System.out.println(testList.peekFirst());
        testList.removeFirst();
        testList.removeFirst();
        System.out.println("Remove 2 " + testList.remove(2));
        System.out.println("Remove 1 " + testList.remove(1));
        System.out.println("Remove 15 " + testList.remove(15));
        testList.display();

    }

    static void iteratorTest (){
        LinkedList<Integer> testList = new LinkedList<>();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.add(5);
        testList.add(6);
        testList.add(7);
        ListIterator<Integer> testIterator = testList.listIterator();
        System.out.println(testIterator.hasPrevious());
        System.out.println(testIterator.next());
        System.out.println(testIterator.next());
        System.out.println(testIterator.hasNext());
        System.out.println(testIterator.previous());
        System.out.println(testIterator.next());
        System.out.println(testIterator.nextIndex());
        System.out.println(testIterator.previousIndex());
        testIterator.remove();
        testIterator.add(5);
        System.out.println(testList);

        }
}
