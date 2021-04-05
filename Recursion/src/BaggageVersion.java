import java.util.LinkedList;

public class BaggageVersion {
    private int sumWight;
    private int sumPrice;
    UnitWithCount[] baggage;
    private int count;
    private int size;

    public BaggageVersion() {
        this.sumWight = 0;
        this.sumPrice = 0;
        this.baggage=new UnitWithCount[100];
    }

    public BaggageUnit[] getBaggage() {
        BaggageUnit[] baggageUnitas = new BaggageUnit[size];
        for (int i=0;i<size;i++){
            baggageUnitas[i]=baggage[i].unit;
        }
        return baggageUnitas;
    }

    public int getCount() {
        return count;
    }

    public void remove (int pos){
        if(size==0) return;
       for (int i=0;i<size;i++){
           UnitWithCount unit = baggage[i];
           if (unit.count>pos){
               sumWight-=unit.unit.getWeight();
                sumPrice-=unit.unit.getPrice();
               System.arraycopy(baggage, i+1, baggage, i, size - i - 1);
               baggage[--size]=null;
//               System.out.print("1");
 //               unit = baggage.iterator().next();
            }
 //           System.out.print("5");
        }
    }

    public void add(BaggageUnit baggageUnit, int count) {
            baggage[size++]=(new UnitWithCount(baggageUnit, count));
            this.sumPrice+=baggageUnit.getPrice();
            this.sumWight+=baggageUnit.getWeight();
    }
    public boolean contains (BaggageUnit unit){
        for (int i=0;i<size;i++){
            if (baggage[i].unit==unit) return true;
        }
        return false;
    }

    public int getSumWight() {
        return sumWight;
    }

    public int getSumPrice() {
        return sumPrice;
    }

    public void printVersion (){
        System.out.printf("Sum prise: %d Sum weight: %d%n", sumPrice, sumWight);
        for (int i=0;i<size;i++){
            System.out.print(" "+ baggage[i].unit.getName()+ " ");
        }
        System.out.println("");
    }

}

class UnitWithCount {
    BaggageUnit unit;
    int count;

    public UnitWithCount(BaggageUnit unit, int count) {
        this.unit = unit;
        this.count = count;
    }
}


