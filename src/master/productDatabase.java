package master;

import master.Items;

//AJV
//Sets up framework for static array of items in the DB.
//use NumItems to increase size throughout.

public class productDatabase extends databases {
	int numItems = 10;
	
	Items[] itemsinArray = new Items[]{};{
		for (int i = 0; i < numItems; i++){
			itemsinArray[i] = new Items(1,1,1,"Test");
		}
	}
	
	Items getItemByID(int id){
		return itemsinArray[id];
	}
	
	//itemsinArray[0].weight = 10;
}
