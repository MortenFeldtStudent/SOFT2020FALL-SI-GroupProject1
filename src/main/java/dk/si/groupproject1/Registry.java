package dk.si.groupproject1;

import dk.si.groupproject1.rmi.MethodImpl;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Registry {

    public static java.rmi.registry.Registry registry;
    public Registry() throws RemoteException { }

    public static void main(String[] args) throws Exception
    {
        try
        {
            System.out.println("RMI server localhost starts");

            // Create a server registry at default port 1099
            registry = LocateRegistry.createRegistry(1099);
            System.out.println("RMI registry created ");

            // Create engine of remote services, running on the server
            MethodImpl remoteEngine = new MethodImpl();

            // Give a name to this engine
            String engineName = "CalculationService";

            // Register the engine by the name, which later will be given to the clients
            Naming.rebind("//localhost/" + engineName, remoteEngine);
            System.out.println("Engine " + engineName + " bound in registry");
        }
        catch (Exception e)
        {
            System.err.println("Exception:" + e);
        }
    }

}
