package VegetableServer;

import java.io.Serializable;

//This interface is Seriarlizable because we want to send it over the network. 
// The execute method will be called on the worker node to perform the task and return the result.
public interface Task<T> extends Serializable {
    T execute();

}
