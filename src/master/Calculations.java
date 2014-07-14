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
		float actualWeight = scale.weight;
		float expectedWeight = 0;
		for(int i = 0; i < cart.length; i++){
			expectedWeight += cart[i].getWeight();
		}
		if (actualWeight == expectedWeight) 
			return true;
		else
			return false;
	}
	
	static float getTotal(Items[] cart){
		float totalCost = 0;
		for (int i = 0; i < cart.length; i++ ){
			totalCost += cart[i].getPrice();
		}
		return totalCost;
	}
	
	
}
