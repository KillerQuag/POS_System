package master;



public class Customer {
	
	public static Cart myCart;
	public static double amountPaid = 0.0;
	public static PaymentMethod paidBy = new PaymentMethod();	
	
	public static double getAmountPaid() {
		return amountPaid;
	}

	public static void paidCash(double amountPaid) {
		paidBy.setCash(amountPaid);		
		Customer.amountPaid += amountPaid ;
	}
	
	public static void paidCredit(double amountPaid) {
		paidBy.setCredit(amountPaid);
		Customer.amountPaid += amountPaid ;
	}
	
	public static void paidCoupon(double amountPaid) {
		paidBy.setCoupon(amountPaid);
		Customer.amountPaid += amountPaid ;
	}
	
	public static void paidCheck(double amountPaid) {
		paidBy.setCheck(amountPaid);
		Customer.amountPaid += amountPaid ;
	}
	
	public static void paidGiftCard(double amountPaid) {
		paidBy.setGiftCard(amountPaid);
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
