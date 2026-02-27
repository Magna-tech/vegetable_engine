package VegetableServer;

public class AddVegetablePrice implements Task<String> {
    private String name;
    private double price;

    public AddVegetablePrice(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String execute() {
        VegetableStore.priceTable.put(name, price);
        return "Added: " + name + " at " + price;
    }
}