/**
 * 
 */
package master;

import java.util.Random;

/**
 * @author John
 *  This will act as the customer.  It will call the other classes/agents to do 
 *  the checkout process.
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Commented out the stuff below, not sure what is the most current
		// iteration of the code, I think Matt has the answer.

		
/*		int maxItemsInCart = 20;
		productDatabase db = new productDatabase();
		
		//Cart is on scale.
		Random rdm = new Random();
		int numItemsInCart = rdm.nextInt(maxItemsInCart) + 1;

*/		
		POSRegister.startTransaction();
		
		
		
		

	}

}
