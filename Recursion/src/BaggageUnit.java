public class BaggageUnit {
    private final int price;
    private final int weight;
    private final String name;




    public BaggageUnit(String name, int price, int weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
}
