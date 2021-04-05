public class Main {

    public static void main(String[] args) {
        testMyTree();
        doTaskTwo();
    }

    static void doTaskTwo (){
        int balancedTree = 0;
        int disbalancedTree=0;
        for (int i =0; i<20; i++){
            Tree4Steps<Integer> myTree = new Tree4Steps<>();
            addRandomTree(myTree);
            if (myTree.isTreeBalanced()) {
                balancedTree++;
            } else {
                disbalancedTree++;
            }
        }
        int percentOfBalancedTree = balancedTree*100/(balancedTree+disbalancedTree);
        System.out.println(percentOfBalancedTree + "% of trees is balanced.");

    }

    static void testMyTree (){
        Tree4Steps<Integer> myTree = new Tree4Steps<>();
        addRandomTree(myTree);
        myTree.display();
        System.out.println(myTree.isTreeBalanced());
//        myTree.travers(ThreeForm.TraversMode.IN_ORDER);
    }
    static void addRandomTree (Tree4Steps<Integer> myTree){
        for (int i=0; i<16; i++){
            myTree.add((int) (Math.random()*51-25));
        }
    }
    static void addBalanceTree(Tree4Steps<Integer> myTree){
        myTree.add(0);
        myTree.add(2);
        myTree.add(1);
        myTree.add(3);
        myTree.add(-2);
        myTree.add(-1);
    }
    static void addDisBalanceTree(Tree4Steps<Integer> myTree){
        myTree.add(0);
        myTree.add(2);
        myTree.add(1);
        myTree.add(3);
        myTree.add(4);
        myTree.add(-1);
    }

}
