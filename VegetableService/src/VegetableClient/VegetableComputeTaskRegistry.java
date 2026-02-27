package VegetableClient;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import VegetableServer.Task;
import VegetableServer.Compute;

public class VegetableComputeTaskRegistry {
    
    // This method looks for the engine and runs the task
    public static <T> T runTask(Task<T> task) {
        try {
            // Looking for the registry on localhost at port 1099
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            
            // Look up the engine by name 
            Compute engine = (Compute) registry.lookup("VegetableComputeEngine");
            
            // Execute and return result 
            return engine.executeTask(task);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}