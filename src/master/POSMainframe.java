package master;

public class POSMainframe 
{
	//fields
	public double totalTransaction$ = 0;
	public int numOfTransactions = 0;
	public double totalCouponAmount = 0;
	
	//constructor
	public POSMainframe()
	{
		totalTransaction$ = 0;
		numOfTransactions = 0;
		totalCouponAmount = 0;
	}
	
	//functions
	public double getTotalTransaction$()
	{
		return totalTransaction$;
	}

	public void setTotalTransaction$(Items[] cart)
	{
		this.totalTransaction$ = totalTransaction$ + Calculations.getTotal(cart);
	}

	public int getNumOfTransactions() 
	{
		return numOfTransactions;
	}

	public void setNumOfTransactions() 
	{
		numOfTransactions = numOfTransactions;
	}

	public double getTotalCouponAmount() 
	{
		return totalCouponAmount;
	}

	public void setTotalCouponAmount(double coupon) 
	{
		totalCouponAmount = totalCouponAmount + coupon;
	}
	
	

}
