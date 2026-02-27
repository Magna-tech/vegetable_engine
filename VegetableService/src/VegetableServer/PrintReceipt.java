package VegetableServer;

public class PrintReceipt implements Task<String> {
    private double totalCost;
    private double amountGiven;
    private String cashierName;

    public PrintReceipt(double totalCost, double amountGiven, String cashierName) {
        this.totalCost = totalCost;
        this.amountGiven = amountGiven;
        this.cashierName = cashierName;
    }

    @Override
    public String execute() {
        double change = amountGiven - totalCost;
        return String.format(
            "--- RECEIPT ---\nTotal: %.2f\nPaid: %.2f\nChange: %.2f\nCashier: %s\n---------------",
            totalCost, amountGiven, change, cashierName
        );
    }
}