package VegetableServer;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Compute extends Remote {
    // This method takes a Task object and executes it on the server.
    <T> T executeTask(Task<T> t) throws RemoteException;

}
