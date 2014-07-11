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
		// TODO Auto-generated method stub
		
		int maxItemsInCart = 20;
		productDatabase db = new productDatabase();
		
		//Cart is on scale.
		Random rdm = new Random();
		int numItemsInCart = rdm.nextInt(maxItemsInCart) + 1;
		
		Items[] cart = new Items[numItemsInCart];
		
		for (int i = 0; i < numItemsInCart; i++){
			cart[i] = db.getItemByID(rdm.nextInt(db.numItems));
		}
		//Cart populated with items.
		
		float totalPrice = Calculations.getTotal(cart);
		
		

	}

}
