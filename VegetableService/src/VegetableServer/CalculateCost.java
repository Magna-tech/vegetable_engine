package VegetableServer;

public class CalculateCost implements Task<Double> {
    private String name;
    private double quantity;

    public CalculateCost(String name, double quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    @Override
    public Double execute() {
        Double price = VegetableStore.priceTable.getOrDefault(name, 0.0);
        return price * quantity;
    }
}