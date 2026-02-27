package VegetableServer;

import java.util.concurrent.ConcurrentHashMap;

public class VegetableStore {
    // The vegetable-price table
    public static ConcurrentHashMap<String, Double> priceTable = new ConcurrentHashMap<>();
    
    static {
        // Pre-populate with some data
        priceTable.put("Cabbage", 50.0);
        priceTable.put("Kales", 30.0);
    }
}
