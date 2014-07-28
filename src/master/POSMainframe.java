package master;

public class POSMainframe 
{
	//fields
	public double totalTransaction = 0.0;
	public int numOfTransactions = 0;
	public double totalCouponAmount = 0;
	public double totalCash = 0;
	public double totalCredit = 0;
	public double totalGiftCard = 0;
	public double totalCheck = 0;
	
	//constructor
	public POSMainframe()
	{
		totalTransaction = 0;
		numOfTransactions = 0;
		totalCouponAmount = 0;
		totalCash = 0;
		totalCredit = 0;
		totalGiftCard = 0;
		totalCheck = 0;
		/*
		Main.dailyTotalsSummary.totalTransaction$ = getTotalTransaction$();
		Main.dailyTotalsSummary.numOfTransactions = getNumOfTransactions();
		Main.dailyTotalsSummary.totalCouponAmount = getTotalCouponAmount();
		Main.dailyTotalsSummary.totalCash = getTotalCash();
		Main.dailyTotalsSummary.totalCredit = getTotalCredit();
		Main.dailyTotalsSummary.totalGiftCard = getTotalGiftCard();
		*/
		
		/*Main.database.totalTransaction = getTotalTransaction();
		Main.database.numOfTransactions = getNumOfTransactions();
		Main.database.totalCouponAmount = getTotalCouponAmount();
		Main.database.totalCash = getTotalCash();
		Main.database.totalCredit = getTotalCredit();
		Main.database.totalGiftCard = getTotalGiftCard();*/

	}
	
	
	
	//functions
	public double getTotalTransaction()
	{
		return totalTransaction;
	}

	public void setTotalTransaction(Cart cart)
	{
		this.totalTransaction += totalTransaction;
	}

	public int getNumOfTransactions() 
	{
		return numOfTransactions;
	}

	public void setNumOfTransactions() 
	{
		numOfTransactions += 1;

		//this.numOfTransactions += numOfTransactions;  //>>>>>>> origin/Matt  Pretty sure this is not what you meant.
	}

	public double getTotalCouponAmount() 
	{
		return totalCouponAmount;
	}

	public void setTotalCouponAmount(double coupon) 
	{
		totalCouponAmount += coupon;
	}

	public double getTotalCash() {
		return totalCash;
	}

	public void setTotalCash(double totalCash) {
		this.totalCash += totalCash;
	}

	public double getTotalCredit() {
		return totalCredit;
	}

	public void setTotalCredit(double totalCredit) {
		this.totalCredit += totalCredit;
	}

	public double getTotalGiftCard() {
		return totalGiftCard;
	}

	public void setTotalGiftCard(double totalGiftCard) {
		this.totalGiftCard += totalGiftCard;
	}
	
	public double getTotalCheck() {
		return totalCheck;
	}

	public void setTotalCheck(double totalCheck) {
		this.totalCheck += totalCheck;
	}	
}
