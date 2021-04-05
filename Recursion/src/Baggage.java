import java.util.ArrayList;
import java.util.LinkedList;

public class Baggage {
    static ArrayList<BaggageUnit> baggageUnits = new ArrayList<>();
    static BaggageVersion currentVersion= new BaggageVersion();
    static BaggageVersion  beastVersion= new BaggageVersion();
    static int bagLiftingCapacity = 4;
    static int size;

    public static void main(String[] args) {
        createBaggagePool();
        fillingTheBag(size);
        beastVersion.printVersion();


    }
    private static void createBaggagePool () {
//        baggageUnits.add(new BaggageUnit("Unit1",50,10));
//        baggageUnits.add(new BaggageUnit("Unit2",500,15));
//        baggageUnits.add(new BaggageUnit("Unit3",550,100));
//        baggageUnits.add(new BaggageUnit("Unit4",1000,500));
//        baggageUnits.add(new BaggageUnit("Unit5",150,30));
//        baggageUnits.add(new BaggageUnit("Unit6",35,15));
//        baggageUnits.add(new BaggageUnit("Unit7",80,900));
//        baggageUnits.add(new BaggageUnit("Unit8",40,40));
//        baggageUnits.add(new BaggageUnit("Unit9",55,40));
//        baggageUnits.add(new BaggageUnit("Unit10",80,1));
        baggageUnits.add(new BaggageUnit("Book", 600, 1));
        baggageUnits.add(new BaggageUnit("Binoculars", 5000, 2));
        baggageUnits.add(new BaggageUnit("Medicine Chest", 1500, 4));
        baggageUnits.add(new BaggageUnit("Notebook", 40000, 2));
        baggageUnits.add(new BaggageUnit("Bowler hat", 500, 1));

        size = baggageUnits.size();
    }

    private static void fillingTheBag(int count){
        if(baggageUnits.get(count-1).getWeight()<=(bagLiftingCapacity-currentVersion.getSumWight())
                && !currentVersion.contains(baggageUnits.get(count-1))){
            currentVersion.add(baggageUnits.get(count-1), count);
            if (currentVersion.getSumPrice()>beastVersion.getSumPrice()) {
                BaggageUnit[] beastUnits = currentVersion.getBaggage();
                beastVersion=new BaggageVersion();
                for (BaggageUnit unit : beastUnits){
                    beastVersion.add(unit,1);
                }
            }
        }
        if(count==1){
            return;
        }
        for (int i=0;i<count; i++){
            fillingTheBag(count-1);
            rotate(count);
        }
    }

    private static void rotate (int count){
        if (count==3){
            int ewr;
        }
        int i;
        int pos = size - count;
        BaggageUnit temp = baggageUnits.get(pos);
        currentVersion.remove(pos);
  //      System.out.print("4");
        for(i=pos+1;i<size;i++){
            baggageUnits.set(i-1,baggageUnits.get(i));
        }
        baggageUnits.set(i-1, temp);

    }
}

