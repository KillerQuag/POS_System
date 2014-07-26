package master;

//import java.util.EmptyStackException;
import java.util.Random;

import master.productDatabase;

/**
 * @author John
 *  Just returns the cart as it's setup via Main already and we don't have a scanner.   
 */

public class ProductScanner extends POSRegister {

	public static Cart populateCart(Cart cart){
		
		productDatabase db = new productDatabase();
				
		for (int i = 0; i < Cart.numItemsInCart; i++){
			Cart.items[i] = db.getItemByID(Cart.rdm.nextInt(db.numItems));
		}
		//Cart now has (random) items inside it.
		return cart;
	}
}

		 
		
			
		
		

