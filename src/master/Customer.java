package master;

import java.text.DecimalFormat;
import java.text.NumberFormat;



public class Customer {
	
	public static Cart myCart;
	public static double amountPaid = 0.0;
	public static double amountReturned = 0.0;
	public static double remainingBalance = 0.0;
	
	public static PaymentMethod paidBy = new PaymentMethod();	
	public static double giftCardBalance = 0.0;
	public static double changeDue = 0.0;
	
	static NumberFormat formatter = new DecimalFormat("#0.00");
	
	public static double getAmountPaid() {
		return amountPaid;
	}

	public static void paidCash(double amountPaid) {
		paidBy.setCash(Calculations.round(amountPaid, 2));			
		Customer.amountPaid += amountPaid ;
		Display.remainingBalanceText.setText(formatter.format(getRemainingBalance()));
		System.out.println(getRemainingBalance());
	
	}
	
	public static void paidCredit(double amountPaid) {
		paidBy.setCredit(Calculations.round(amountPaid, 2));
		Customer.amountPaid += amountPaid ;
		Display.remainingBalanceText.setText(formatter.format(getRemainingBalance()));
		System.out.println(getRemainingBalance());
		
	}
	public static void paidDebit(double amountPaid){
		paidBy.setDebit(Calculations.round(amountPaid, 2));
		Customer.amountPaid += amountPaid;
		Display.remainingBalanceText.setText(formatter.format(getRemainingBalance()));
		System.out.println(getRemainingBalance());
		
	}
	
	public static void paidCoupon(double amountPaid) {
		paidBy.setCoupon(Calculations.round(amountPaid, 2));
		//Customer.amountPaid += amountPaid;
		Display.remainingBalanceText.setText(formatter.format(getRemainingBalance()));
		System.out.println(getRemainingBalance());
	
		//Customer.amountPaid += amountPaid;//took this out because coupons are discounts, not payments
	}
	
	public static void paidCheck(double amountPaid) {
		paidBy.setCheck(amountPaid);
		Customer.amountPaid += amountPaid ;
		Display.remainingBalanceText.setText(formatter.format(getRemainingBalance()));
		System.out.println(getRemainingBalance());
		
	}
	
	public static void paidGiftCard(double amountPaid) {
		paidBy.setGiftCard(amountPaid);
		Customer.amountPaid += amountPaid ;
		Display.remainingBalanceText.setText(formatter.format(getRemainingBalance()));
		System.out.println(getRemainingBalance());
		
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
		Customer.changeDue = (Calculations.round(changeDue, 2));
		
	}
	
	
	public static double getAmountReturned() {
		return amountReturned;
	}

	public static void setAmountReturned(double amountReturned) {
		paidBy.setCashReturned(amountReturned);
		Customer.amountReturned += (Calculations.round(amountReturned, 2));
		
	}	
	
	public static double getRemainingBalance() {
		if(Customer.myCart.myTaxTotal - amountPaid < 0 )
			return 0.00;
		else			
			return Customer.myCart.myTaxTotal - amountPaid;
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
