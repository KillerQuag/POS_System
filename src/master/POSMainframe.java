package master;

public class POSMainframe 
{
	//fields
	public double totalTransaction = 0.0;
	public int numOfTransactions = 0;
	public double totalCouponAmount = 0;
	public double totalCash = 0;
	public double TotalCashReturned = 0;
	public double totalCredit = 0;
	public double totalDebit = 0;
	public double totalGiftCard = 0;
	public double totalCheck = 0;
	public double checkTotalCalc = (totalCash + totalCheck + totalCredit + totalDebit + totalGiftCard ) - TotalCashReturned;
	
	//constructor
	public POSMainframe()
	{
		totalTransaction = 0;
		numOfTransactions = 0;
		totalCouponAmount = 0;
		totalCash = 0;
		TotalCashReturned = 0;
		totalCredit = 0;
		totalDebit = 0;
		totalGiftCard = 0;
		totalCheck = 0;
		checkTotalCalc = 0;
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
					"Total Cash Returned:			$" + Calculations.format(this.TotalCashReturned) + '\n' +
					"Total Credit:				$" + Calculations.format(this.totalCredit) + '\n' +
					"Total Debit:				$" + Calculations.format(this.totalDebit) + '\n' +
					"Total Checks:				$" + Calculations.format(this.totalCheck) + '\n' +
					"Total Discounts:			$" + Calculations.format(this.totalCouponAmount) + '\n' +
					"Total Gift Card:				$" + Calculations.format(this.totalGiftCard) + '\n' + 
					"---------------------------------------------------------------------------------------------------" + '\n' + 					
					"Total Transactions:			$" + Calculations.format(this.totalTransaction) + '\n' +
					"---------------------------------------------------------------------------------------------------" + '\n' + '\n' + '\n' +
					"Total Transactions Should Match:		$" + Calculations.format(this.checkTotalCalc) + '\n';
		
		return output;
	}
	
	//functions  --Methods
	public double getTotalTransaction()
	{
		return totalTransaction;
	}

	public void setTotalTransaction(double tt) //Changed this from taking a cart to a double -John
	{
		this.totalTransaction += tt;
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
		this.setCheckTotalCalc();
	}

	public double getTotalCredit() {
		return totalCredit;
	}

	public void setTotalCredit(double totalCredit) {
		this.totalCredit += totalCredit;
		this.setCheckTotalCalc();
	}
	
	public double getTotalDebit() {
		return totalDebit;
	}

	public void setTotalDebit(double totalDebit) {
		this.totalDebit += totalDebit;
		this.setCheckTotalCalc();
	}

	public double getTotalGiftCard() {
		return totalGiftCard;
	}

	public void setTotalGiftCard(double totalGiftCard) {
		this.totalGiftCard += totalGiftCard;
		this.setCheckTotalCalc();
	}
	
	public double getTotalCheck() {
		return totalCheck;
	}

	public void setTotalCheck(double totalCheck) {
		this.totalCheck += totalCheck;
		this.setCheckTotalCalc();
	}

	public double getTotalCashReturned() {
		return TotalCashReturned;
	}

	public void setTotalCashReturned(double totalCashReturned) {
		this.TotalCashReturned += totalCashReturned;
		this.setCheckTotalCalc();
	}

	public double getCheckTotalCalc() {
		return checkTotalCalc;
	}

	public void setCheckTotalCalc() {
		this.checkTotalCalc = (totalCash + totalCheck + totalCredit + totalDebit + totalGiftCard ) - TotalCashReturned;
	}	
	
	
}
