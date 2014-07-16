/**
 * 
 */
package master;

import master.CardProcessor;
import master.MFScanner;
import master.CashInBunker;
import master.Calculations;

/**
 * @author John
 * UI Element to select payment method
 * should call either MFScanner or CardProcessor to get funds applied.
 * should return amount paid to calling function.
 */
public abstract class PaymentMethod 
{
	
	double Cash = 0;
	double Credit = 0;
	double Coupon = 0;
	double Check = 0;
	double totalPayment;
	
	//random comment
	
	public PaymentMethod()
	{
		Cash = 0;
		Credit = 0;
		Coupon = 0;
		Check = 0;
		totalPayment = 0;
	}
	
	double setTotalPayment()
	{
		return 
	}
	
	
}
