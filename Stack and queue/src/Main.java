import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        System.out.println(reversWord(word));
    }

    public static String  reversWord (String word){
        MyStack<Character> myStack = new MyStack<>(5);
        for (int i=0; i<word.length(); i++){
            myStack.push(word.charAt(i));
        }
        myStack.display();
        int stackLength = myStack.size();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<stackLength; i++){
            sb.append(myStack.pop());
        }
        return sb.toString();
    }

    public static void testStack (){
        MyStack<Character> myStack = new MyStack<>(5);
        String word = "JAVA!";
        for (int i=0; i<word.length(); i++){
            myStack.push(word.charAt(i));
        }
        myStack.display();
        int stackLength = myStack.size();
        for (int i=0; i<stackLength; i++){
            System.out.print(myStack.pop());
        }
    }

    public static void testQueue (){
        MyQueue<Character> myQueue = new MyQueue<>(5);
        String word = "JAVA!";
        for (int i=0; i<word.length(); i++){
            myQueue.insert(word.charAt(i));
        }
        myQueue.display();
        int stackLength = myQueue.size();
        for (int i=0; i<stackLength; i++){
            System.out.print(myQueue.remove());
        }
    }
    public static void testDeque (){
        MyDeque<Character> myDeque = new MyDeque<>(15);
            myDeque.insertLeft('a');
            myDeque.insertLeft('b');
            myDeque.insertLeft('c');
            myDeque.insertLeft('d');
            myDeque.insertLeft('e');
            myDeque.display();
            for (int i=0; i<=3;i++) {
                System.out.print(myDeque.removeRight());
            }
            myDeque.insertLeft('c');
            myDeque.insertLeft('d');
            myDeque.insertLeft('e');
            myDeque.display();
            for (int i=0; i<=3;i++) {
                System.out.print(myDeque.removeRight());
            }
        }
}
