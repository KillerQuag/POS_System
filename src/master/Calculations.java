package master;

import java.util.EmptyStackException;

import master.productDatabase;
import master.Scale;
import master.Items;

public class Calculations {
	productDatabase database = new productDatabase();
	Scale scale = new Scale();
	ProductScanner scanner = new ProductScanner();
	
	Items[] getCart(){
		Items[] cart = new Items[]{};
		try {
			for (int i = 0; i < scanner.numItemsInCart; i++){
				cart[i] = scanner.sendItem();
			}
		}
		catch (EmptyStackException emptyCart){
		}
		return cart;
	}
	
	boolean areTheWeightsTheSame(Items[] cart){
		float actualWeight = scale.weight;
		float expectedWeight = 0;
		for(int i = 0; i < cart.length; i++){
			expectedWeight += cart[i].w;
		}
		
		
	}
}
