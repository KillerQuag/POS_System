package master;
//random message to test push

/**
 * 
 * The amount of money paid should be in here at least via
 * the form of coupons, checks, and cash. 
 * 
 * Should have a return value of the total amount inside.
 * 
 *  Original abstract of MoneyBunker has been removed.  This
 *  is it's replacement.
 */

public class CashInBunker
{
    //fields
	public double Cash = 0;
	public double Coupon = 0;
	public double Check = 0;
	
	//constructor
	public CashInBunker()
	{
		Cash = 200;
		Coupon = 0;
		Check = 0;
	}
	
	//functions
	public double getCash() 
	{
		return Cash;
	}

	public void setCash(double cash) 
	{
		Cash = Cash + cash;
	}

	public double getCoupon() 
	{
		return Coupon;
	}

	public void setCoupon(double coupon) 
	{
		Coupon = Coupon + coupon;
	}

	public double getCheck() 
	{
		return Check;
	}

	public void setCheck(double check) 
	{
		Check = Check + check;
	}

}
