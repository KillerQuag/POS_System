package master;



public class Customer {
	
	public static Cart myCart;
	public static double amountPaid = 0.0;
	public static double amountPaidCash = 0.0;
	public static double amountPaidGift = 0.0;
	public static double amountReturned = 0.0;
	
	
	public static double getAmountPaidCash() {
		return amountPaidCash;
	}

	public static void setAmountPaidCash(double amountPaidCash) {
		Customer.amountPaidCash = amountPaidCash;
	}

	public static double getAmountPaidGift() {
		return amountPaidGift;
	}

	public static void setAmountPaidGift(double amountPaidGift) {
		Customer.amountPaidGift = amountPaidGift;
	}

	public static PaymentMethod paidBy = new PaymentMethod();	
	public static double giftCardBalance = 0.0;
	public static double changeDue;
	
	public static double getAmountPaid() {
		return amountPaid;
	}

	public static void paidCash(double amountPaid) {
		paidBy.setCash(Math.round(amountPaid*100)/100.00);		
		Customer.amountPaid += amountPaid ;
	}
	
	public static void paidCredit(double amountPaid) {
		paidBy.setCredit(Math.round(amountPaid*100)/100.00);
		Customer.amountPaid += amountPaid ;
	}
	
	public static void paidCoupon(double amountPaid) {
		paidBy.setCoupon(Math.round(amountPaid*100)/100.00);
		Customer.amountPaid += amountPaid ;
	}
	
	public static void paidCheck(double amountPaid) {
		paidBy.setCheck(Math.round(amountPaid*100)/100.00);
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
		Customer.changeDue = Math.round(changeDue*100)/100.00;
	}
	
	
	public static double getAmountReturned() {
		return amountReturned;
	}

	public static void setAmountReturned(double amountReturned) {
		paidBy.setCashReturned(amountReturned);
		Customer.amountReturned += Math.round(amountReturned*100)/100.00;		
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
