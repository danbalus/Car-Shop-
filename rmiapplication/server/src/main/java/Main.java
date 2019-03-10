import services.TaxService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
    public static void main(String[] args) {
        try{
            //System.setProperty("java.rmi.server.hostname","192.168.1.2");

            Registry registry = LocateRegistry.createRegistry(1099);
            TaxService taxService = new TaxService();
            registry.rebind("taxService", taxService);
            System.out.println("-----Server is ON-----");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
