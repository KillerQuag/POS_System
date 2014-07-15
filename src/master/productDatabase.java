package master;

import master.Items;

/**
 * @author John
 * I can't figure out this call shit for line 13.  It's supposed to setup a new 
 * array of Items with size numItems.  
 */

public class productDatabase extends databases {
<<<<<<< HEAD
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
=======
	 public  int numItems = 30;
	 Items[] itemArray = new Items[numItems];
	
	 public productDatabase(){
		 	
		itemArray[0] = new Items();
		itemArray[0].setItemName("Dog Biscuits");
		itemArray[0].setPrice(2.50);
		itemArray[0].setWeight(3.20);
		itemArray[1] = new Items();
		itemArray[1].setItemName("Cereal");
		itemArray[1].setPrice(3.25);
		itemArray[1].setWeight(1.55);
		itemArray[2] = new Items();
		itemArray[2].setItemName("Coffee");
		itemArray[2].setPrice(9.99);
		itemArray[2].setWeight(1.00);
		itemArray[3] = new Items();
		itemArray[3].setItemName("Milk");
		itemArray[3].setPrice(3.99);
		itemArray[3].setWeight(1.20);
		itemArray[4] = new Items();
		itemArray[4].setItemName("Yogurt");
		itemArray[4].setPrice(1.25);
		itemArray[4].setWeight(1.00);
		itemArray[5] = new Items();
		itemArray[5].setItemName("Cheese");
		itemArray[5].setPrice(2.25);
		itemArray[5].setWeight(1.15);
		itemArray[6] = new Items();
		itemArray[6].setItemName("White Bread");
		itemArray[6].setPrice(1.85);
		itemArray[6].setWeight(0.75);
		itemArray[7] = new Items();
		itemArray[7].setItemName("Wheat Bread");
		itemArray[7].setPrice(1.55);
		itemArray[7].setWeight(0.75);
		itemArray[8] = new Items();
		itemArray[8].setItemName("Pickles");
		itemArray[8].setPrice(2.99);
		itemArray[8].setWeight(1.75);
		itemArray[9] = new Items();
		itemArray[9].setItemName("Jelly Beans");
		itemArray[9].setPrice(2.99);
		itemArray[9].setWeight(.99);
		itemArray[10] = new Items();
		itemArray[10].setItemName("Tortillas");
		itemArray[10].setPrice(1.99);
		itemArray[10].setWeight(1.00);
		itemArray[11] = new Items();
		itemArray[11].setItemName("Carrots");
		itemArray[11].setPrice(.99);
		itemArray[11].setWeight(.50);
		itemArray[12] = new Items();
		itemArray[12].setItemName("Ice Cream");
		itemArray[12].setPrice(2.99);
		itemArray[12].setWeight(1.0);
		itemArray[13] = new Items();
		itemArray[13].setItemName("Lunch Meat");
		itemArray[13].setPrice(9.99);
		itemArray[13].setWeight(1.50);
		itemArray[14] = new Items();
		itemArray[14].setItemName("Popcorn");
		itemArray[14].setPrice(4.99);
		itemArray[14].setWeight(1.00);
		itemArray[15] = new Items();
		itemArray[15].setItemName("Shrimp");
		itemArray[15].setPrice(6.99);
		itemArray[15].setWeight(1.0);
		itemArray[16] = new Items();
		itemArray[16].setItemName("Bagels");
		itemArray[16].setPrice(3.99);
		itemArray[16].setWeight(1.30);
		itemArray[17] = new Items();
		itemArray[17].setItemName("Rice");
		itemArray[17].setPrice(2.99);
		itemArray[17].setWeight(1.25);
		itemArray[18] = new Items();
		itemArray[18].setItemName("Broccoli");
		itemArray[18].setPrice(.99);
		itemArray[18].setWeight(1.0);
		itemArray[19] = new Items();
		itemArray[19].setItemName("Spaghetti Sauce");
		itemArray[19].setPrice(4.99);
		itemArray[19].setWeight(2.0);
		itemArray[20] = new Items();
		itemArray[20].setItemName("Macaroni & Cheese");
		itemArray[20].setPrice(2.99);
		itemArray[20].setWeight(1.5);
		itemArray[21] = new Items();
		itemArray[21].setItemName("Cat Food");
		itemArray[21].setPrice(7.99);
		itemArray[21].setWeight(5.0);
		itemArray[22] = new Items();
		itemArray[22].setItemName("Wine");
		itemArray[22].setPrice(11.99);
		itemArray[22].setWeight(3.0);
		itemArray[23] = new Items();
		itemArray[23].setItemName("Granola Bars");
		itemArray[23].setPrice(3.99);
		itemArray[23].setWeight(1.0);
		itemArray[24] = new Items();
		itemArray[24].setItemName("Peanut Butter");
		itemArray[24].setPrice(2.99);
		itemArray[24].setWeight(1.1);
		itemArray[25] = new Items();
		itemArray[25].setItemName("Marshmallows");
		itemArray[25].setPrice(2.99);
		itemArray[25].setWeight(0.75);
		itemArray[26] = new Items();
		itemArray[26].setItemName("Grape Jelly");
		itemArray[26].setPrice(2.75);
		itemArray[26].setWeight(.80);
		itemArray[27] = new Items();
		itemArray[27].setItemName("Cream Cheese");
		itemArray[27].setPrice(3.75);
		itemArray[27].setWeight(0.60);
		itemArray[28] = new Items();
		itemArray[28].setItemName("Butter");
		itemArray[28].setPrice(2.99);
		itemArray[28].setWeight(0.89);
		itemArray[29] = new Items();
		itemArray[29].setItemName("Candy Bar");
		itemArray[29].setPrice(1.25);
		itemArray[29].setWeight(0.25);
		
		
	 }

	
	
	
	Items testItem = new Items();
	
	Items getItemByID(int id){
		return itemArray[id];
	}

>>>>>>> origin/master
	//itemsinArray[0].weight = 10;
}
