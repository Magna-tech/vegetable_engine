package VegetableServer;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class VegetableComputeEngine extends UnicastRemoteObject implements Compute {

    public VegetableComputeEngine() throws RemoteException {
        super();
    }

    @Override
    public <T> T executeTask(Task<T> t) throws RemoteException {
        // This is where the 4+ types of client tasks are actually run
        return t.execute();
    }

    public static void main(String[] args) {
        try {
            String name = "VegetableComputeEngine";
            Compute engine = new VegetableComputeEngine();
            
            // Start the RMI registry on the default port 1099
            // and bind the engine to "localhost"
            Registry registry = LocateRegistry.createRegistry(1099); 
            registry.rebind(name, engine);
            
            System.out.println("VegetableComputeEngine bound and ready!");
        } catch (Exception e) {
            System.err.println("VegetableComputeEngine exception:");
            e.printStackTrace();
        }
    }
}
