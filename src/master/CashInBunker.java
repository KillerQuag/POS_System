package master;

/**
 * @author John
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
	private double totalCash = 0;
	private double totalCheck = 0;
	private double totalCoupon = 0;
	
	//constructor
	private CashInBunker()
	{
		totalCash = 200;
		totalCheck = 0;
		totalCoupon = 0;
	}
	
	//methods
	
	
}
