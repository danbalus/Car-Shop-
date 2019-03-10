package presenter;

import entities.Car;
import serviceinterfaces.ITaxService;
import services.TaxService;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.NoSuchElementException;

public class ClientGUI extends JFrame{

    public JPanel getPanel1() {
        return panel1;
    }

    private JPanel panel1;
    private JTabbedPane tabbedPane;


    private JPanel addPanel;
    private JLabel priceLabel;
    private JLabel RMILabel;
    private JLabel engineLabel;
    private JLabel yearLabel;
    private JTextField textFieldIdYear;
    private JTextField textFieldNameEngine;
    private JTextField textFieldAdressPrice;

    private JButton taxButton;
    private JButton priceButton;

    private JPanel managementPanel;
    private JScrollPane jScrollPanelManagement;

    private JTextArea textArea1;
    private ITaxService iTaxService;

    public ClientGUI() /*throws RemoteException*/ {
        //iTaxService = new TaxService() ;


        taxButton.addActionListener(new ActionListener() {
           // @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    //idException iddException= new idException();
                    int year = Integer.parseInt(textFieldIdYear.getText());
                    int engine = Integer.parseInt(textFieldNameEngine.getText());
                    double price = Double.parseDouble(textFieldAdressPrice.getText());

                    System.out.println("year " + year);
                    System.out.println("engine " + engine);
                    System.out.println("price " + price);

                   Car car = new Car(year,engine,price);

                    String tax = String.valueOf(iTaxService.computeTax(car));
                    //String sellingPrice = String.valueOf((iTaxService.computeSellingPrice(car)));
                    textArea1.setText(null);
                    textArea1.insert(tax,0);
                    //System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

                    //System.out.println(iTaxService.computeTax(car));
                    //EmployeeBLL employeeBLL = new EmployeeBLL();
                     //if (employeeBLL.findEmployeeById(id) != null) {
                    //     JOptionPane.showMessageDialog(null, "angajatul exista in baza de date", "ERROR", JOptionPane.ERROR_MESSAGE);
                    //     return;
                    // }
                   // Employee employee = new Employee(id, name, adress, email, age, nrTel, salary, title);
                   // employeeBLL.insert(employee);

                }
                 catch (Exception ex) {
                     //ex.printStackTrace();
                     JOptionPane.showMessageDialog(null, "Datele introduse nu respecta parametrii", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        priceButton.addActionListener(new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent e) {
               // String id = textFieldIdDelete.getText();
                //EmployeeBLL employeeBLL = new EmployeeBLL();
                //Employee employee = new Employee();
                try {

                    int year = Integer.parseInt(textFieldIdYear.getText());
                    int engine = Integer.parseInt(textFieldNameEngine.getText());
                    double price = Double.parseDouble(textFieldAdressPrice.getText());
                    System.out.println("year " + year);
                    System.out.println("engine " + engine);
                    System.out.println("price " + price);
                    Car car = new Car(year,engine,price);

                    String sellingPrice = String.valueOf((iTaxService.computeSellingPrice(car)));
                    textArea1.setText(null);
                    textArea1.insert(sellingPrice,0);
                    //System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

                    //System.out.println(iTaxService.computeSellingPrice(car));



                }catch (Exception ex) {
                   // ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Datele nu respecta formatul", "ERROR", JOptionPane.ERROR_MESSAGE);}

            }

        });

    }
    public void createAdmin(){
        JFrame frame = new JFrame("Admin");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setSize(555,555);
        frame.pack();
        frame.setVisible(true);
    }


    public void setTax(ITaxService iTaxService) {
        this.iTaxService = iTaxService;
    }
}
