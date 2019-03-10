package serviceinterfaces;

import entities.Car;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @Author: Technical University of Cluj-Napoca, Romania
 *          Distributed Systems, http://dsrl.coned.utcluj.ro/
 * @Module: assignment-two-common-classes
 * @Since: Sep 1, 2015
 * @Description:
 * 	Interface of the remote object published by the server. It allows for the computation
 * 	of the tax needed to be payed for a Car.
 */
public interface ITaxService extends Remote {

	/**
	 * Computes the tax to be payed for a Car.
	 *
	 * @param c Car for which to compute the tax
	 * @return tax for the car
	 */
	double computeTax(Car c) throws RemoteException;
	double computeSellingPrice(Car c) throws RemoteException;
}
