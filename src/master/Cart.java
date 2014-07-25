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
	static final int numItemsInCart = rdm.nextInt(maxItemsInCart) + 1;
	static Items[] items = new Items[numItemsInCart];
	
	
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
		return numItemsInCart > 0;
	}
	
	
}
