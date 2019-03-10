package services;


import entities.Car;
import serviceinterfaces.ITaxService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @Author: Technical University of Cluj-Napoca, Romania
 *          Distributed Systems Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Module: assignment-two-server
 * @Since: Sep 1, 2015
 * @Description:
 * 	Class used for computation of taxes to be paid for a specific car. An instance
 * 	of this class is published in the Registry so that it can be remotely accessed
 * 	by a client.
 */
public class TaxService extends UnicastRemoteObject implements ITaxService {


	public TaxService() throws RemoteException {}

	public double computeTax(Car c) throws RemoteException {
		// Dummy formula
		if (c.getEngineCapacity() <= 0) {
			throw new IllegalArgumentException("Engine capacity must be positive.");
		}
		System.out.println(c);
		int sum = 8;
		if(c.getEngineCapacity() > 1601) sum = 18;
		if(c.getEngineCapacity() > 2001) sum = 72;
		if(c.getEngineCapacity() > 2601) sum = 144;
		if(c.getEngineCapacity() > 3001) sum = 290;
		return c.getEngineCapacity() / 200.0 * sum;
	}

	public double computeSellingPrice(Car c) throws RemoteException{
		// Dummy formula
//		if (c.getEngineCapacity() <= 0) {
//			throw new IllegalArgumentException("Engine capacity must be positive.");
//		}


		int old = 2018 - (c.getYear());
		if(old >= 7){
			System.out.println(c + "price: " +  c.getPrice());
			System.out.println("Mai veche de 7 ani");
			return 0;
		}
		System.out.println(c+ "price: " +  c.getPrice());
		System.out.println("Mai noua de 7 ani");
		double purchasingPrice = c.getPrice();
		double sellingPrice = purchasingPrice - purchasingPrice / 7.0 *(2018 - c.getYear());

		return sellingPrice;
	}
}
