/**
 * 
 */
package master;

/**
 * @author Matt
 * Takes populated cart and displays the Name, Price, and Totals of each item.
 */
public class POSRegister {
	
	static double totalPrice = 0;
	static double totalWeight = 0;		
	
	POSRegister(){
		
	}
	
	//This method outputs the cart information
	public static void startTransaction(Items cart[]){
	for(int i = 0; i < cart.length; i++){
		System.out.format("%-20s",(i+1) + ". " + cart[i].getItemName());
		System.out.format("%15s", cart[i].getPrice() + "\n");
	}
		//get totalPrice & totalWeight from Calculations
		//totalWeight displayed for debugging purposes
		totalPrice = Calculations.getTotalPrice(cart);
		totalWeight = Calculations.getTotalWeight(cart);
		System.out.println("Number Items in Cart: " + cart.length);
		System.out.println("Total Price: " + "$"+totalPrice);
		System.out.println("Total Weight:  " + totalWeight);
	}
	//send cart[] to mainframe
	

}
