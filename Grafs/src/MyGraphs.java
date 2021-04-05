import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyGraphs<E extends Comparable<? super E>> {
    private int size;
    private final Vertex<E> data[];
    private final boolean[][] linkTable;
    private final int defaultMaxSize = 10;

    public MyGraphs(int maxSize) {
        data = new Vertex[maxSize];
        linkTable = new boolean[maxSize][maxSize];
    }

    public void add (E value){
        data[size++]= new Vertex<>(value);
    }

    public boolean addEdges (E firstVertex, E secondVertex, E... others){
        int indexOfFirstVertex = getIndexOfValue(firstVertex);
        int indexOfSecondVertex = getIndexOfValue(secondVertex);
        if (indexOfFirstVertex==-1 || indexOfSecondVertex==-1) return false;
        linkTable[indexOfFirstVertex][indexOfSecondVertex]=true;
        linkTable[indexOfSecondVertex][indexOfFirstVertex]=true;
        for (E vertex : others){
            int indexOFOtherVertex = getIndexOfValue(vertex);
            if (indexOFOtherVertex==-1) return false;
            linkTable[indexOfFirstVertex][indexOFOtherVertex]=true;
            linkTable[indexOFOtherVertex][indexOfFirstVertex]=true;
        }
        return true;
    }


    public void findAWay (E firstVertex, E lastVertex){
        cleanTemp();
        Queue<Integer> queue = new LinkedList<>();
        int indexOfFirstValue = getIndexOfValue(firstVertex);
        if (indexOfFirstValue==-1) {
            System.out.println("Incorrect value of first vertex.");
            return;
        }
        queue.add(indexOfFirstValue);
        data[indexOfFirstValue].setVisited(true);
  //      System.out.print(data[indexOfFirstValue].getValue());
        while (!queue.isEmpty()){
            int nextIndex = getIndexOfNextUnvisited(queue.peek());
            if (nextIndex==-1){
                queue.remove();
            } else {
                data[nextIndex].setIndexOfPreviousVertex(queue.peek());
                if (data[nextIndex].getValue().equals(lastVertex)){
                    int[] way = getAWay(nextIndex);
                    for (int index : way){
                        System.out.print(" " + data[index].getValue() + " ");
                    }
                    System.out.println("");
                    return;
                }
 //               System.out.print(" ->" + data[nextIndex].getValue());
                data[nextIndex].setVisited(true);
                queue.add(nextIndex);
            }
        }
        System.out.println("Vertex are not connected.");
        cleanTemp();
    }

    private int[] getAWay (int index){
        Stack<Integer> stack = new Stack<>();
        stack.push(index);
        while (data[index].getIndexOfPreviousVertex()!=-1){
            index=data[index].getIndexOfPreviousVertex();
            stack.push(index);
        }
        int stackSize = stack.size();
        int[] way = new int[stackSize];
        for (int i=0;i<stackSize;i++){
            way[i]=stack.pop();
        }
        return way;
    }

    public void bfs(E firstVertex){
        cleanTemp();
        Queue<Integer> queue = new LinkedList<>();
        int indexOfFirstValue = getIndexOfValue(firstVertex);
        if (indexOfFirstValue==-1) {
            System.out.println("Incorrect value of first vertex.");
            return;
        }
        queue.add(indexOfFirstValue);
        data[indexOfFirstValue].setVisited(true);
        System.out.print(data[indexOfFirstValue].getValue());
        while (!queue.isEmpty()){
            int nextIndex = getIndexOfNextUnvisited(queue.peek());
            if (nextIndex==-1){
                queue.remove();
            } else {
                System.out.print(" ->" + data[nextIndex].getValue());
                data[nextIndex].setVisited(true);
                queue.add(nextIndex);
            }
        }
        System.out.println();
        cleanTemp();
    }

    public void dfs(E firstVertex){
        cleanTemp();
        Stack<Integer> stack = new Stack<>();
        int indexOfFirstValue = getIndexOfValue(firstVertex);
        if (indexOfFirstValue==-1) {
            System.out.println("Incorrect value of first vertex.");
            return;
        }
        stack.push(indexOfFirstValue);
        data[indexOfFirstValue].setVisited(true);
        System.out.print(data[indexOfFirstValue].getValue());
        while (!stack.isEmpty()){
            int nextIndex = getIndexOfNextUnvisited(stack.peek());
            if (nextIndex==-1){
                stack.pop();
            } else {
                System.out.print(" ->" + data[nextIndex].getValue());
                data[nextIndex].setVisited(true);
                stack.push(nextIndex);
            }
        }
        System.out.println();
        cleanTemp();
    }


    public void cleanTemp (){
        for (Vertex<E> vertex : data){
            vertex.setVisited(false);
            vertex.setIndexOfPreviousVertex(-1);
        }
    }

    public int getIndexOfNextUnvisited (int indexOfVertex){
        for (int i = 0; i< data.length; i++){
            if (!data[i].isVisited()&&linkTable[i][indexOfVertex]) return i;
        }
        return -1;
    }

    public void display (){
        for (int i=0; i< data.length;i++){
            System.out.print(data[i].getValue());
            for (int j=0; j< data.length; j++){
                if (linkTable[i][j]) System.out.print("->"+data[j].getValue());
            }
            System.out.println("");
        }
    }

    private int getIndexOfValue (E value){
        for (int i=0; i<data.length; i++){
            if (data[i].getValue().equals(value)) return i;
        }
        return -1;
    }

    private class Vertex<E>{
        private final E value;
        private boolean isVisited;
        private int indexOfPreviousVertex;

        public void setIndexOfPreviousVertex(int indexOfPreviousVertex) {
            this.indexOfPreviousVertex = indexOfPreviousVertex;
        }

        public int getIndexOfPreviousVertex() {
            return indexOfPreviousVertex;
        }

        public void setVisited(boolean visited) {
            isVisited = visited;
        }

        public boolean isVisited() {
            return isVisited;
        }

        public Vertex(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }
    }

}
