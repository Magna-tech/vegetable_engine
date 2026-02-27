package VegetableServer;

public class UpdateVegetablePrice implements Task<String> {
    private String name;
    private double newPrice;

    public UpdateVegetablePrice(String name, double newPrice) {
        this.name = name;
        this.newPrice = newPrice;
    }

    @Override
    public String execute() {
        if (VegetableStore.priceTable.containsKey(name)) {
            VegetableStore.priceTable.put(name, newPrice);
            return "Updated " + name + " to " + newPrice;
        }
        return "Error: Vegetable not found.";
    }
}