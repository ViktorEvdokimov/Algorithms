public class Main {

    public static void main(String[] args) {
		findAWay();
    }

    private static void findAWay(){
		MyGraphs<String> myGraphs = new MyGraphs<>(10);
		myGraphs.add("Москва");
		myGraphs.add("Тула");
		myGraphs.add("Липетск");
		myGraphs.add("Воронеж");
		myGraphs.add("Рязань");
		myGraphs.add("Томбов");
		myGraphs.add("Саратов");
		myGraphs.add("Калуга");
		myGraphs.add("Орел");
		myGraphs.add("Курск");
//		myGraphs.display();
		myGraphs.addEdges("Москва", "Тула", "Рязань", "Калуга");
		myGraphs.addEdges("Воронеж", "Липетск", "Саратов", "Курск");
		myGraphs.addEdges("Тула", "Липетск");
		myGraphs.addEdges("Томбов", "Рязань", "Саратов");
		myGraphs.addEdges("Орел", "Калуга", "Курск");
		myGraphs.bfs("Москва");
		myGraphs.findAWay("Курск", "Тула");
	}

    private static void myTests(){
		MyGraphs<String> myGraphs = new MyGraphs<>(7);
		myGraphs.add("a");
		myGraphs.add("b");
		myGraphs.add("c");
		myGraphs.add("d");
		myGraphs.add("e");
		myGraphs.add("f");
		myGraphs.add("g");
		myGraphs.addEdges("a", "b", "d", "e");
		myGraphs.addEdges("b", "c");
		myGraphs.addEdges("f", "e", "g");
		myGraphs.display();
		myGraphs.bfs("a");
		myGraphs.dfs("a");
	}
}
