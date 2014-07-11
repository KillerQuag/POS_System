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
	Random rdm = new Random();
	int numItemsInCart = rdm.nextInt(maxItemsInCart) + 1;
	int numToSend = numItemsInCart; 
	
	
	//Send back random items till all are sent.
	
	Items sendItem(){
		if (numToSend != 0){
			numToSend -= 1;
			
			return db.getItemByID(rdm.nextInt(db.numItems));
			
			
		}
		else
			throw new EmptyStackException();
		
	}
	
}
