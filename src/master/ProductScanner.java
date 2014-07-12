package master;

import java.util.EmptyStackException;
import java.util.Random;
import master.productDatabase;

/**
 * @author John
 *  Just returns the cart as it's setup via Main already and we don't have a scanner.   
 */

public class ProductScanner extends POSRegister {

	Items[] sendItem(Items [] cart){
		return cart;	
	}
	
}
