package master;

import java.util.EmptyStackException;
import java.util.Random;
import master.productDatabase;

//AJV
//Sends Items value back to indicate more items to scan
//Throws EmptyStackException when finished.

public class ProductScanner extends POSRegister {
	int maxItemsInCart = 20;
	productDatabase db = new productDatabase();

	//Generate Random number of items that will be in cart

	int numToSend = 0;
	
	//Send back random items till all are sent.
	
	Items[] sendItem(Items [] cart){
		return cart;	
	}
	
}
