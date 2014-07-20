package master;

//AJV
//Creates the Items class for use throughout the rest of the program
//Can be initialized on call.

public class Items{
		
		double weight = 0;
		double price = 0;
		String itemName = "";
		int UID = -1;
		
		public double getWeight() {
			return weight;
		}
		public int getUID() {
			return UID;
		}
		public void setUID(int uID) {
			UID = uID;
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
