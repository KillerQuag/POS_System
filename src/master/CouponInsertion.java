package master;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

//This class simulates the process of inserting coupons
public class CouponInsertion extends Display {
	

	private static final long serialVersionUID = 1L;
	
	
	private static CouponInsertion myInstance;

	public JFrame insertCouponFrame;
	public JLabel insertCouponLabel;
	public JButton returnToPayMethods;
	
	public static JButton fivePerOff;
	public static JButton fifteenPerOff;
	public static JButton twentyfivePerOff;
	
	public CouponInsertion(){
		
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.getContentPane().setLayout(null);
		
		insertCouponLabel = new JLabel("<html>Please insert coupon now.<html>");//possibly add a return to payment methods option once this works
		insertCouponLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
		insertCouponLabel.setLocation(320, 0);
		insertCouponLabel.setSize(400,100);
		this.getContentPane().add(insertCouponLabel);
		
		insertCouponFrame = this;
		
		//button for 5 percent off
		fivePerOff = new JButton("5% off Total Purchase!");
		fivePerOff.setFont(new Font("Ariel", Font.PLAIN, 12));				
		fivePerOff.setLocation(75, 200);
		fivePerOff.setSize(200, 100);
		insertCouponFrame.getContentPane().add(fivePerOff);
		ListenForButton lFofivePerButton = new ListenForButton();
		fivePerOff.addActionListener(lFofivePerButton);
		
		//button for 15 percent off
		fifteenPerOff = new JButton("15% off Total Purchase!!");
		fifteenPerOff.setFont(new Font("Ariel", Font.PLAIN, 12));				
		fifteenPerOff.setLocation(75 + 225, 200);
		fifteenPerOff.setSize(200, 100);
		insertCouponFrame.getContentPane().add(fifteenPerOff);
		ListenForButton lFofifteenPerButton = new ListenForButton();
		fifteenPerOff.addActionListener(lFofifteenPerButton);
		
		//button for 25 percent off
		twentyfivePerOff = new JButton("25% off Total Purchase!!!");
		twentyfivePerOff.setFont(new Font("Ariel", Font.PLAIN, 12));				
		twentyfivePerOff.setLocation(75 + 225 + 225, 200);
		twentyfivePerOff.setSize(200, 100);
		insertCouponFrame.getContentPane().add(twentyfivePerOff);
		ListenForButton lFotwentyfivePerButton = new ListenForButton();
		twentyfivePerOff.addActionListener(lFotwentyfivePerButton);
		
		returnToPayMethods = new JButton("Return to Payment Methods");
		returnToPayMethods.setFont(new Font("Ariel", Font.PLAIN, 18));
		returnToPayMethods.setLocation(265, 500);
		returnToPayMethods.setSize(300, 75);
		insertCouponFrame.getContentPane().add(returnToPayMethods);
		ListenForButton lFoReturnToPayMethods = new ListenForButton(); //Making object from within the object's class may be bad
		returnToPayMethods.addActionListener(lFoReturnToPayMethods);
		
		this.remove(welcomeLabel);
		this.remove(startTransactionButton);
	}
	private class ListenForButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Main.mainWindow.lForButton.actionPerformed(e);
			NumberFormat formatter = new DecimalFormat("#0.00");
			Customer customer = (Customer)Main.Customers.get(Main.currentCustNum);
			double discount,
			       couponAmount,
			       roundTotal;
			String formattedTotal;		
			       
			if(e.getSource() == returnToPayMethods) {
				
				insertCouponFrame.dispose();
				myInstance = null;
			}
			else if(e.getSource() == fivePerOff){
				
				discount = 0.05;
				System.out.print("Subtotal Price:  $" + customer.myCart.myPrice + '\n');
				couponAmount = customer.myCart.myPrice * discount;
				formattedTotal = formatter.format(customer.myCart.myTaxTotal  - couponAmount);				
				DisplayCart.textArea1.append("Coupon - 5 Percent off:\n");
				DisplayCart.textArea1.append("Total:\n");
				DisplayCart.textArea2.append("$-" + formatter.format(couponAmount) + "\n");
				DisplayCart.textArea2.append("$" + formattedTotal + "\n");				
				
				//Laya's addition to reflect the adjusted total amount to be paid.				
				couponAmount = Math.round(couponAmount*100)/100.00;
				roundTotal = Math.round((customer.myCart.myTaxTotal -= couponAmount)*100)/100.00;
				Main.dailyTotalsSummary.setTotalTransaction(roundTotal);
				customer.paidCoupon(couponAmount);
				
				insertCouponFrame.dispose();
				myInstance = null;
			}
			else if(e.getSource() == fifteenPerOff){
				discount = 0.15;
				System.out.print(customer.myCart.myPrice);
				couponAmount = customer.myCart.myPrice * discount;
				formattedTotal = formatter.format(customer.myCart.myTaxTotal  - couponAmount);
				DisplayCart.textArea1.append("Coupon - 15 Percent off:\n");
				DisplayCart.textArea1.append("Total:\n");
				DisplayCart.textArea2.append("$-" + formatter.format(couponAmount) + "\n");
				DisplayCart.textArea2.append("$" + formattedTotal + "\n");				
				
				//Laya's addition to reflect the adjusted total amount to be paid.				
				couponAmount = Math.round(couponAmount*100)/100.00;
				roundTotal = Math.round((customer.myCart.myTaxTotal -= couponAmount)*100)/100.00;
				Main.dailyTotalsSummary.setTotalTransaction(roundTotal);
				customer.paidCoupon(couponAmount);
				
				insertCouponFrame.dispose();
				myInstance = null;
			}
			else if(e.getSource() == twentyfivePerOff){
				discount = 0.25;
				System.out.print(customer.myCart.myPrice);
				couponAmount = customer.myCart.myPrice * discount;
				formattedTotal = formatter.format(customer.myCart.myTaxTotal  - couponAmount);
				DisplayCart.textArea1.append("Coupon - 25 Percent off:\n");
				DisplayCart.textArea1.append("Total:\n");
				DisplayCart.textArea2.append("$-" + formatter.format(couponAmount) + "\n");
				DisplayCart.textArea2.append("$" + formattedTotal + "\n");				
				
				//Laya's addition to reflect the adjusted total amount to be paid.								
				couponAmount = Math.round(couponAmount*100)/100.00;
				roundTotal = Math.round((customer.myCart.myTaxTotal -= couponAmount)*100)/100.00;
				Main.dailyTotalsSummary.setTotalTransaction(roundTotal);
				customer.paidCoupon(couponAmount);
				
				insertCouponFrame.dispose();
				myInstance = null;
			}
		}
	}
	public static CouponInsertion getInstance() {
        if (myInstance == null)
            myInstance = new CouponInsertion();

        return myInstance;
    }
}
