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
	int maxItemsInCart = 20;
	Random rdm = new Random();
	int numItemsInCart = rdm.nextInt(maxItemsInCart) + 1;
	Items[] items = new Items[numItemsInCart];
	
	public Items[] getItems() {
		return items;
	}
	public void setItems(Items[] items) {
		this.items = items;
	}
	public int getNumItemsInCart() {
		return numItemsInCart;
	}
	
	
}
