import entities.Car;
import presenter.ClientGUI;
import serviceinterfaces.ITaxService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class StartClient {
    public static void main(String[] args) {
        try{
            Registry registry  = LocateRegistry.getRegistry("127.0.0.1",1099);
            ITaxService iTaxService = (ITaxService) registry.lookup("taxService");
            System.out.println("-----Super Client is ON-----");


            System.out.println("Tax value: "
                    + iTaxService.computeTax(new Car(2009, 2000)));
            System.out.println(iTaxService.computeTax(new Car(2009, 100)));

            System.out.println("Price selling : "
                    + iTaxService.computeSellingPrice(new Car(2014, 2000, 10000)));
            System.out.println(iTaxService.computeSellingPrice(new Car(2009, 100, 10000)));
            ClientGUI gui = new ClientGUI();
            gui.createAdmin();
            gui.setTax(iTaxService);
            /*JFrame frame = new JFrame("App");
            frame.setContentPane(gui.getPanel1());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
            gui.setTax(iTaxService);*/
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
