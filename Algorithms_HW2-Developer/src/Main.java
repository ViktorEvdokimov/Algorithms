import java.util.Date;

public class Main {

    public static void main(String[] args) {
        ArrayBuilder<Integer> myArrayBubble = new ArrayBuilder<Integer>(10000);
        ArrayBuilder<Integer> myArraySelect = new ArrayBuilder<Integer>(10000);
        ArrayBuilder<Integer> myArrayInsert = new ArrayBuilder<Integer>(10000);
        for (int i=0; i<100000;i++){
            int value = (int)((Math.random()-0.5)*2147483647*2);
            myArrayBubble.add(value);
            myArrayInsert.add(value);
            myArraySelect.add(value);
        }
        Date bubbleStartTime = new Date();
        myArrayBubble.bubbleSorting();
        Date bubbleEndTime = new Date();
        long bubbleTime =bubbleEndTime.getTime()-bubbleStartTime.getTime();

        Date selectStartTime = new Date();
        myArraySelect.sortSelect();
        Date selectEndTime = new Date();
        long selectTime =selectEndTime.getTime()-selectStartTime.getTime();

        Date insertStartTime = new Date();
        myArrayInsert.sortInsert();
        Date insertEndTime = new Date();
        long insertTime =insertEndTime.getTime()-insertStartTime.getTime();

        System.out.printf("Time bubble sorting: %d%n" +
                "Time select sorting: %d%n" +
                "Time insert sorting: %d", bubbleTime, selectTime, insertTime);

    }
}
