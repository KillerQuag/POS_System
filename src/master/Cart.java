/**
 * 
 */
package master;

import java.util.*;

/**
 * @author John
 *
 */
public class Cart {
	

	private static final int maxItemsInCart = 20;
	static Random rdm = new Random();
	public static final int numItemsInCart = rdm.nextInt(maxItemsInCart) + 1;
	public static Items[] items = new Items[numItemsInCart];
	public static double myPrice = 0.0;
	static double myWeight = 0.0;
	static double myTaxTotal  = 0.0;
	static double myTax = 0.0;
	static double myRemBal = 0.0;
	
	public Items[] getItems() {
		return items;
	}
	public void setItems(Items[] items) {
		Cart.items = items;
	}
	public int getNumItemsInCart() {
		return numItemsInCart;
	}
	public Items getItem(int index){
		return items[index];
	}
	public boolean hasItems(){
		return (items[0].getUID() != -1);
	}
	
	
}
	
