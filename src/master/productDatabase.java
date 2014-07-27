
package master;

import master.Items;

/**
 * @author Matt
 * List of items currently available for sale.
 * Planning on increasing the list to 50+, 100+ if we have time.
 */

public class productDatabase extends databases {

	 public final int numItems = 50;
	 Items[] itemArray = new Items[numItems];
	
	 public productDatabase(){
		 for(int i = 0; i < numItems; i++){
			 itemArray[i] = new Items();
			 itemArray[i].setUID(i);
		 }
		 	
		itemArray[0].setItemName("Dog Biscuits");
		itemArray[0].setPrice(2.55);
		itemArray[0].setWeight(3.20);
		itemArray[1].setItemName("Cereal");
		itemArray[1].setPrice(3.25);
		itemArray[1].setWeight(1.55);
		itemArray[2].setItemName("Coffee");
		itemArray[2].setPrice(9.99);
		itemArray[2].setWeight(1.00);
		itemArray[3].setItemName("Milk");
		itemArray[3].setPrice(3.99);
		itemArray[3].setWeight(1.20);
		itemArray[4].setItemName("Yogurt");
		itemArray[4].setPrice(1.25);
		itemArray[4].setWeight(1.00);
		itemArray[5].setItemName("Cheese");
		itemArray[5].setPrice(2.25);
		itemArray[5].setWeight(1.15);
		itemArray[6].setItemName("White Bread");
		itemArray[6].setPrice(1.85);
		itemArray[6].setWeight(0.75);
		itemArray[7].setItemName("Wheat Bread");
		itemArray[7].setPrice(1.55);
		itemArray[7].setWeight(0.75);
		itemArray[8].setItemName("Pickles");
		itemArray[8].setPrice(2.99);
		itemArray[8].setWeight(1.75);
		itemArray[9].setItemName("Jelly Beans");
		itemArray[9].setPrice(2.99);
		itemArray[9].setWeight(.99);
		itemArray[10].setItemName("Tortillas");
		itemArray[10].setPrice(1.99);
		itemArray[10].setWeight(1.00);
		itemArray[11].setItemName("Carrots");
		itemArray[11].setPrice(0.99);
		itemArray[11].setWeight(.50);
		itemArray[12].setItemName("Ice Cream");
		itemArray[12].setPrice(2.99);
		itemArray[12].setWeight(1.0);
		itemArray[13].setItemName("Lunch Meat");
		itemArray[13].setPrice(9.99);
		itemArray[13].setWeight(1.50);
		itemArray[14].setItemName("Popcorn");
		itemArray[14].setPrice(4.99);
		itemArray[14].setWeight(1.00);
		itemArray[15].setItemName("Shrimp");
		itemArray[15].setPrice(6.99);
		itemArray[15].setWeight(1.0);
		itemArray[16].setItemName("Bagels");
		itemArray[16].setPrice(3.99);
		itemArray[16].setWeight(1.30);
		itemArray[17].setItemName("Rice");
		itemArray[17].setPrice(2.99);
		itemArray[17].setWeight(1.25);
		itemArray[18].setItemName("Broccoli");
		itemArray[18].setPrice(0.99);
		itemArray[18].setWeight(1.0);
		itemArray[19].setItemName("Spaghetti Sauce");
		itemArray[19].setPrice(4.99);
		itemArray[19].setWeight(2.0);
		itemArray[20].setItemName("Mac & Cheese");
		itemArray[20].setPrice(2.99);
		itemArray[20].setWeight(1.5);
		itemArray[21].setItemName("Cat Food");
		itemArray[21].setPrice(7.99);
		itemArray[21].setWeight(5.0);
		itemArray[22].setItemName("Wine");
		itemArray[22].setPrice(11.99);
		itemArray[22].setWeight(3.0);
		itemArray[23].setItemName("Granola Bars");
		itemArray[23].setPrice(3.99);
		itemArray[23].setWeight(1.0);
		itemArray[24].setItemName("Peanut Butter");
		itemArray[24].setPrice(2.99);
		itemArray[24].setWeight(1.1);
		itemArray[25].setItemName("Marshmallows");
		itemArray[25].setPrice(2.99);
		itemArray[25].setWeight(0.75);
		itemArray[26].setItemName("Grape Jelly");
		itemArray[26].setPrice(2.75);
		itemArray[26].setWeight(.80);
		itemArray[27].setItemName("Cream Cheese");
		itemArray[27].setPrice(3.75);
		itemArray[27].setWeight(0.60);
		itemArray[28].setItemName("Butter");
		itemArray[28].setPrice(2.99);
		itemArray[28].setWeight(0.89);
		itemArray[29].setItemName("Candy Bar");
		itemArray[29].setPrice(1.25);
		itemArray[29].setWeight(0.25);
		itemArray[30].setItemName("Dead Cat");
		itemArray[30].setPrice(4.99);
		itemArray[30].setWeight(11.0);
		itemArray[31].setItemName("Anthrax Vial");
		itemArray[31].setPrice(329.99);
		itemArray[31].setWeight(0.02);
		itemArray[32].setItemName("Crystal Meth");
		itemArray[32].setPrice(25.00);
		itemArray[32].setWeight(0.05);
		itemArray[33].setItemName("Prostitute");
		itemArray[33].setPrice(29.99);
		itemArray[33].setWeight(300.00);
		itemArray[34].setItemName("AK-47");
		itemArray[34].setPrice(199.49);
		itemArray[34].setWeight(9.50);
		itemArray[35].setItemName("Chainsaw");
		itemArray[35].setPrice(129.99);
		itemArray[35].setWeight(16.05);
		itemArray[36].setItemName("Sex Panther Cologne");
		itemArray[36].setPrice(99.98);
		itemArray[36].setWeight(0.10);
		itemArray[37].setItemName("The One Ring");
		itemArray[37].setPrice(275.00);
		itemArray[37].setWeight(0.01);
		itemArray[38].setItemName("Snuggie");
		itemArray[38].setPrice(39.99);
		itemArray[38].setWeight(0.7);
		itemArray[39].setItemName("Great White Shark");
		itemArray[39].setPrice(149.00);
		itemArray[39].setWeight(1000.00);
		itemArray[40].setItemName("iPhone 12");
		itemArray[40].setPrice(0.99);
		itemArray[40].setWeight(0.3);
		itemArray[41].setItemName("Slap Chop");
		itemArray[41].setPrice(9.99);
		itemArray[41].setWeight(0.9);
		itemArray[42].setItemName("(Holy) Hand Grenade");
		itemArray[42].setPrice(54.99);
		itemArray[42].setWeight(3.5);
		itemArray[43].setItemName("Bacon Wrapped Bacon");
		itemArray[43].setPrice(12.99);
		itemArray[43].setWeight(1.00);
		itemArray[44].setItemName("Boones Farm");
		itemArray[44].setPrice(4.99);
		itemArray[44].setWeight(0.7);
		itemArray[45].setItemName("Prosthetic Leg");
		itemArray[45].setPrice(99.99);
		itemArray[45].setWeight(4.2);
		itemArray[46].setItemName("Natty Light 12 Pack");
		itemArray[46].setPrice(7.99);
		itemArray[46].setWeight(1.5);
		itemArray[47].setItemName("Magic: The Gathering Cards");
		itemArray[47].setPrice(7.99);
		itemArray[47].setWeight(0.2);
		itemArray[48].setItemName("An A in 4498 Project");
		itemArray[48].setPrice(300.00);
		itemArray[48].setWeight(0.00);
		itemArray[49].setItemName("Flip Flops");
		itemArray[49].setPrice(18.99);
		itemArray[49].setWeight(0.5);
		
	 }

	Items getItemByID(int id){
		return itemArray[id];
	}
	
}
