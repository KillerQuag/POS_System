
package master;	

import java.util.EmptyStackException;

import master.productDatabase;
import master.Scale;
import master.Items;

public class Calculations {
	productDatabase database = new productDatabase();
	Scale scale = new Scale();
	ProductScanner scanner = new ProductScanner();
	
	boolean areTheWeightsTheSame(Items[] cart){
		double actualWeight = scale.weight;
		double expectedWeight = 0;
		for(int i = 0; i < cart.length; i++){
			expectedWeight += cart[i].getWeight();
		}
		if (actualWeight == expectedWeight) 
			return true;
		else
			return false;
	}
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    double factor = (double) Math.pow(10, places);
	    value = value * factor;
	    double tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	 
	static double getTotalPrice(Items[] cart){
		double totalCost = 0.0;
		for (int i = 0; i < cart.length; i++ ){
			totalCost += cart[i].getPrice();
		}
		totalCost = Calculations.round(totalCost, 2);
		return totalCost;
	}

	static double getTotalWeight(Items[] cart){
		double totalWeight = 0;
		for (int i = 0; i < cart.length; i++ ){
			totalWeight += cart[i].getWeight();
		}
		totalWeight = Calculations.round(totalWeight, 2);
		return totalWeight;
	}
	
}

