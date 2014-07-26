package master;



public class Customer {
	
	public static Cart myCart;
	public static double amountPaid = 0.0;	
	
	public static double getAmountPaid() {
		return amountPaid;
	}

	public static void setAmountPaid(double amountPaid) {
		Customer.amountPaid += amountPaid ;
	}

	public Customer(){
		Customer.myCart = new Cart();
		myCart = ProductScanner.populateCart(myCart);
		//myCart = Calculations.SortCart(myCart);  //WIP
	}
	
	public Cart getCart(){
		return this.myCart;
	}
}
