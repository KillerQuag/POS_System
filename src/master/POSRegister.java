/**
 * 
 */
package master;

import java.util.Random;
import java.text.DecimalFormat;

/**
 * @author John
 * UI portion, gets user input.  May go elsewhere or be subsumed by something else.
 */
public class POSRegister extends POSOverwatch {
	
	POSRegister(){
		
	}
	public static void startTransaction(){
		
	double totalPrice = 0;
	double totalWeight = 0;	
	int maxItemsInCart = 20;
	
	productDatabase db = new productDatabase();
	
	Random rdm = new Random();
	int numItemsInCart = rdm.nextInt(maxItemsInCart) + 1;
	
	Items[] cart = new Items[numItemsInCart];
	
	for (int i = 0; i < numItemsInCart; i++){
		cart[i] = db.getItemByID(rdm.nextInt(db.numItems));
	}
	//Cart now has (random) items inside it.
	
	String newLine = System.getProperty("line.separator");
	
	for(int i = 0; i < cart.length; i++){
		System.out.format("%-20s",(i+1) + ". " + cart[i].getItemName());
		System.out.format("%15s", cart[i].getPrice());
		System.out.print(newLine);
	}
	//get totalPrice & totalWeight from Calculations
	//totalWeight displayed for debugging purposes
		totalPrice = Calculations.getTotalPrice(cart);
		totalWeight = Calculations.getTotalWeight(cart);
		System.out.println("Number Items in Cart: " + numItemsInCart);
		System.out.println("Total Price: " + "$"+totalPrice);
		System.out.println("Total Weight:  " + totalWeight);
	}
	//send cart[] to mainframe


}
