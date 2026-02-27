package VegetableServer;

public class DeleteVegetablePrice implements Task<String> {
    private String name;

    public DeleteVegetablePrice(String name) {
        this.name = name;
    }

    @Override
    public String execute() {
        if (VegetableStore.priceTable.remove(name) != null) {
            return "Deleted: " + name;
        }
        return "Error: Vegetable not found.";
    }
}