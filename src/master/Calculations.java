
package master;	

//import java.util.EmptyStackException;

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
	 
	static double getTotalPrice(Cart cart){
		double totalCost = 0.0;
		for (int i = 0; i < cart.items.length; i++ ){
			totalCost += cart.items[i].getPrice();
		}
		totalCost = Calculations.round(totalCost, 2);
		return totalCost;
	}

	static double getTotalWeight(Cart cart){
		double totalWeight = 0;
		for (int i = 0; i < cart.items.length; i++ ){
			totalWeight += cart.items[i].getWeight();
		}
		totalWeight = Calculations.round(totalWeight, 2);
		return totalWeight;
	}

	public Cart SortCart(Cart cart){
		int i, j, minIndex;
		Items tmp;
	      int n = cart.items.length;
	      for (i = 0; i < n - 1; i++) {
	            minIndex = i;
	            for (j = i + 1; j < n; j++)
	                  if (cart.items[j].UID < cart.items[minIndex].UID)
	                        minIndex = j;
	            if (minIndex != i) {
	                  tmp = cart.items[i];
	                  cart.items[i] = cart.items[minIndex];
	                  cart.items[minIndex] = tmp;
	            }
	      }
	      return cart;
	}
	
}

