package master;



public class Customer {
	
	public static Cart myCart;
	public static double amountPaid = 0.0;
	public static double amountReturned = 0.0;
	
	public static PaymentMethod paidBy = new PaymentMethod();	
	public static double giftCardBalance = 0.0;
	public static double changeDue = 0.0;
	
	public static double getAmountPaid() {
		return amountPaid;
	}

	public static void paidCash(double amountPaid) {
		paidBy.setCash(Calculations.round(amountPaid, 2));		
		Customer.amountPaid += amountPaid ;
	}
	
	public static void paidCredit(double amountPaid) {
		paidBy.setCredit(Calculations.round(amountPaid, 2));
		Customer.amountPaid += amountPaid ;
	}
	
	public static void paidCoupon(double amountPaid) {
		paidBy.setCoupon(Calculations.round(amountPaid, 2));
		//Customer.amountPaid += amountPaid;//took this out because coupons are discounts, not payments
	}
	
	public static void paidCheck(double amountPaid) {
		paidBy.setCheck(Calculations.round(amountPaid, 2));
		Customer.amountPaid += amountPaid ;
	}
	
	public static void paidGiftCard(double amountPaid) {
		paidBy.setGiftCard(amountPaid);
		Customer.amountPaid += amountPaid ;
	}
	
	public static double getGiftCardBalance() {
		return giftCardBalance;
	}

	public static void setGiftCardBalance(double giftCardBalance) {
		Customer.giftCardBalance = giftCardBalance;
	}	

	public static double getChangeDue() {
		return changeDue;
	}

	public static void setChangeDue(double changeDue) {
		Customer.changeDue = (Calculations.round(amountPaid, 2));
	}
	
	
	public static double getAmountReturned() {
		return amountReturned;
	}

	public static void setAmountReturned(double amountReturned) {
		paidBy.setCashReturned(amountReturned);
		Customer.amountReturned += (Calculations.round(amountReturned, 2));		
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
