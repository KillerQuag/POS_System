package master;

import master.Items;

/**
 * @author John
 * I can't figure out this call shit for line 13.  It's supposed to setup a new 
 * array of Items with size numItems.  
 */

public class productDatabase extends databases {
	public static final int numItems = 10;
	Items[] ia = new Items[numItems];

	public productDatabase() {
		
		ia[0] = new Items();
		ia[0].setItemName("Dog Biscuits");
		ia[0].setUID(0);
		ia[0].setPrice(2.50);
		ia[0].setWeight(3.20);	
	}
	public Items getItemByID(int id){
		return ia[id];
	}	
	//itemsinArray[0].weight = 10;
}
