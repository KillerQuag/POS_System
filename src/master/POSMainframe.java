package master;

public class POSMainframe 
{
	//fields
	public double totalTransaction = 0.0;
	public int numOfTransactions = 0;
	public double totalCouponAmount = 0;
	public double totalCash = 0;
	public double totalCashReturned;
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
		totalCashReturned = 0;
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
	
	public String toString()
	{
		String output = "";
		
		output = '\n' + "	        Daily Transactions Summary" + '\n' + '\n' +
					"---------------------------------------------------------------------------------------------------" + '\n' + 
					"Number of Transactions:			 " + this.numOfTransactions + '\n' + 
					"---------------------------------------------------------------------------------------------------" + '\n' + 
					"Total Cash Received:			$" + Calculations.format(this.totalCash) + '\n' +
					"Total Cash Returned:			$" + Calculations.format(this.totalCashReturned) + '\n' +
					"Total Credit:				$" + Calculations.format(this.totalCredit) + '\n' +
					"Total Checks:				$" + Calculations.format(this.totalCheck) + '\n' +
					"Total Discounts:			$" + Calculations.format(this.totalCouponAmount) + '\n' +
					"Total Gift Card:				$" + Calculations.format(this.totalGiftCard) + '\n' + 
					"---------------------------------------------------------------------------------------------------" + '\n' + 					
					"Total Transactions:			$" + Calculations.format(this.totalTransaction) + '\n' +
					"---------------------------------------------------------------------------------------------------" + '\n' + '\n' + '\n';
		
		return output;
	}
	
	//functions  --Methods
	public double getTotalTransaction()
	{
		return totalTransaction;
	}

	public void setTotalTransaction(double tt) //Changed this from taking a cart to a double -John
	{
		this.totalTransaction = tt;
	}

	public int getNumOfTransactions() 
	{
		return numOfTransactions;
	}

	public void setNumOfTransactions() 
	{
		numOfTransactions += 1;
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
	public double getTotalCashReturned() {
		return totalCashReturned;
	}

	public void setTotalCashReturned(double totalCashReturned) {
		this.totalCashReturned = totalCashReturned;
	}
}
