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
	
		static int maxItemsInCart = 20;
		static Random rdm = new Random();
		static int numItemsInCart = rdm.nextInt(maxItemsInCart) + 1;
		static Items[] items = new Items[numItemsInCart];
		
		public Items[] getItems() {
			return items;
		}
		/*public void setRemainingPrice(double remainingPrice){
			this.remainingPrice = remainingPrice;
		}
		public double getRemainingPrice(){
			return remainingPrice;
		}*/
		
		public void setItems(Items[] items) {
			Cart.items = items;
		}
		public int getNumItemsInCart() {
			return numItemsInCart;
		}
		public Items getItem(int index){
			return items[index];
		}
		public static Items[] sendItems(){
			return items;
		}
		
}
	
