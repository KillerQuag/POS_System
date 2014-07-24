package master;



public class Customer {
	public Customer(){
		Cart myCart = new Cart();
		myCart = ProductScanner.populateCart(myCart);
		myCart = Calculations.SortCart(myCart);
	}
}
