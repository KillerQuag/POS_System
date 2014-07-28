/**
 * 
 */
package master;
/**
 * @author Leah
 * UI Element to select payment method
 * should call either MFScanner or CardProcessor to get funds applied.
 * should return amount paid to calling function.
 */
public class PaymentMethod 
{
	double Cash = 0;
	double Credit = 0;
	double Coupon = 0;
	double Check = 0;
	double GiftCard = 0;
	double TotalPayment = 0;	

	public PaymentMethod()
	{
		Cash = 0;
		Credit = 0;
		Coupon = 0;
		Check = 0;
		GiftCard = 0;
		TotalPayment = 0;	
	}			
	
	public double getCash() {
		return Cash;
	}

	public void setCash(double cash) {
		Main.dailyTotalsSummary.setTotalCash(cash);
		Cash += cash;
	}

	public double getCredit() {
		return Credit;
	}

	public void setCredit(double credit) {
		Main.dailyTotalsSummary.setTotalCredit(credit);
		Credit += credit;
	}

	public double getCoupon() {
		return Coupon;
	}

	public void setCoupon(double coupon) {
		Main.dailyTotalsSummary.setTotalCouponAmount(coupon);
		Coupon += coupon;
	}

	public double getCheck() {
		return Check;
	}

	public void setCheck(double check) {
		Main.dailyTotalsSummary.setTotalCheck(check);
		Check += check;
	}

	public double getTotalPayment() {
		return TotalPayment;
	}

	public void setTotalPayment(double totalPayment) {
		Main.dailyTotalsSummary.setTotalTransaction(totalPayment);
		TotalPayment += totalPayment;		
	}	
	public double getGiftCard() {
		return GiftCard;
	}

	public void setGiftCard(double giftCard) {
		Main.dailyTotalsSummary.setTotalGiftCard(giftCard);
		GiftCard += giftCard;
	}
	
}
