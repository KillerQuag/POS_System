package master;

//AJV
//Creates the Items class for use throughout the rest of the program
//Can be initialized on call.

public class Items{
		
		private double weight = 0;
		private double price = 0;
		private String itemName = "";
		
		Items(){
			weight = 0;
			price = 0;
			itemName = "Item name not entered.";
		}
		public double getWeight() {
			return weight;
		}
		public void setWeight(double weight) {
			this.weight = weight;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public String getItemName() {
			return itemName;
		}
		public void setItemName(String itemName) {
			this.itemName = itemName;
		}
	
}
