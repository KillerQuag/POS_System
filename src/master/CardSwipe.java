package master;

import javax.swing.*;

import master.Display.ListenForButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

//This class simulates the process of swiping a card (Debit, Credit or Gift)
public class CardSwipe extends JFrame 
{
	private static final long serialVersionUID = 1L; //Ignore
	
	private static CardSwipe myInstance;
	
	public static JButton debitButton;
	public static JButton creditButton;
	public static JButton giftButton;
	public static JButton returnButton;
	public static JButton returnButtonGift;
	public static JButton enterButton;
	
	//Gift card buttons
	public static JButton fiveDollar;
	public static JButton tenDollar;
	public static JButton twentyFiveDollar;
	public static JButton fiftyDollar;	
	public static JButton cancelButton;
	
	//Added 8/1 -Heath
	public static JButton giftCardCompletedPayment;
	
	public static JLabel chooseACardLabel;
	public static JLabel couponLabel;
	public static JLabel giftCardAmountLabel;
	
	public static JLabel amtPaid;
	public static JLabel amtRemaining;
	public static JLabel giftCardLabel;
	
	public static JTextField CardSwipeField;
	public static JTextField amtPaidText;
	public static JTextField amtDueText;

	Point windowLocation;	
	
	public static JFrame cardSwipeWindow;
	
	
	public CardSwipe()
	{
	
	//this.setLocationRelativeTo();
	this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	//this.setBounds(30, 30, 300, 300); //An alternate method for setting size and location of frame
	this.setSize(550, 450); //Where this method is invoked relative to other matters
	this.setLocationRelativeTo(null); //Centers frame in the middle of the screen
	this.setResizable(false);
	this.setVisible(true);
	//this.setLocation(0, 0);
	
	cardSwipeWindow = this;
	
	//debitButton
	debitButton = new JButton("Debit");
	debitButton.setLocation(95, 160);
	debitButton.setSize(100, 75);
	ListenForButton lForDebitButton = new ListenForButton(); //Making object from within the object's class may be bad
	debitButton.addActionListener(lForDebitButton);
	cardSwipeWindow.getContentPane().add(debitButton);
	
	//creditButton
	creditButton = new JButton("Credit");
	creditButton.setLocation(210, 160);
	creditButton.setSize(100, 75);
	ListenForButton lForCreditButton = new ListenForButton(); //Making object from within the object's class may be bad
	creditButton.addActionListener(lForCreditButton);
	cardSwipeWindow.getContentPane().add(creditButton);
	
	
	//giftButton
	giftButton = new JButton("Gift");
	giftButton.setLocation(330, 160);
	giftButton.setSize(100, 75);
	ListenForButton lForGiftButton = new ListenForButton(); //Making object from within the object's class may be bad
	giftButton.addActionListener(lForGiftButton);
	cardSwipeWindow.getContentPane().add(giftButton);
	
	
	//Return to Payment Method
	returnButton = new JButton("Return to Payment Method");
	returnButton.setLocation(115, 280);
	returnButton.setSize(300, 75);
	//Color returnBackgroundButton = Color.yellow;
	//returnButton.setBackground(returnBackgroundButton );
	ListenForButton lForreturnButton = new ListenForButton(); //Making object from within the object's class may be bad
	returnButton.addActionListener(lForreturnButton);
	cardSwipeWindow.getContentPane().add(returnButton);
	
	
	chooseACardLabel = new JLabel("<html>Please select the type of card you are using.<html>");
	chooseACardLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
	chooseACardLabel.setLocation(90, 50);
	chooseACardLabel.setSize(400, 100);
	cardSwipeWindow.getContentPane().add(chooseACardLabel);
	
	this.getContentPane().setLayout(null); //Setting Layout to null allows coordinate placement //Can't get backDrop to appear if layout is set to null
	
	
	}	
		 
	//Implement listeners
	static class ListenForButton implements ActionListener 
	{		
		public void actionPerformed(ActionEvent e)
		{
			
			if(e.getSource() == debitButton )
			{
				//full payment be made with the card?
				//ActionEvent debitPress = null;
				//debitPress.setSource(debitButton);				
				Main.mainWindow.lForButton.actionPerformed(e);
				cardSwipeWindow.dispose();
				myInstance = null;
			}
			else if(e.getSource() == returnButton ){
				NumberFormat formatter = new DecimalFormat("#0.00");
				Customer customer = (Customer)Main.Customers.get(Main.currentCustNum);
				DisplayCart.textArea1.append("Gift payment:\n");
				DisplayCart.textArea2.append("$" + formatter.format(customer.myCart.myRemBal) + "\n");
				//Main.mainWindow.remainingBalanceText.setText(formatter.format(customer.myCart.myRemBal));
				Main.mainWindow.lForButton.actionPerformed(e);
				cardSwipeWindow.dispose();
				myInstance = null;
			}
			else if(e.getSource() == creditButton )
			{
				
				
				//full payment be made with card? 
				Main.mainWindow.lForButton.actionPerformed(e);
				//Customer.paidCredit(amountPaid);
				
				cardSwipeWindow.dispose();
				
				myInstance = null;
			}
			else if(e.getSource() == giftButton )
			{
				//full payment to be made with gift card?
				Main.mainWindow.lForButton.actionPerformed(e);				
				//cardSwipeWindow.dispose();
				myInstance = null;
				//cardSwipeWindow.remove(CardSwipeField);
				cardSwipeWindow.remove(creditButton);
				cardSwipeWindow.remove(debitButton);
				cardSwipeWindow.remove(giftButton);
				cardSwipeWindow.remove(returnButton);
				cardSwipeWindow.remove(chooseACardLabel);
				cardSwipeWindow.repaint();
				
				fiveDollar = new JButton("$5");
				fiveDollar.setLocation(40, 100);
				fiveDollar.setSize(100, 75);
				ListenForButton lForFiveDollar = new ListenForButton(); //Making object from within the object's class may be bad
				fiveDollar.addActionListener(lForFiveDollar);
				cardSwipeWindow.getContentPane().add(fiveDollar);	
				
				tenDollar = new JButton("$10");
				tenDollar.setLocation(160, 100);
				tenDollar.setSize(100, 75);
				ListenForButton lFortenDollar = new ListenForButton(); //Making object from within the object's class may be bad
				tenDollar.addActionListener(lFortenDollar);
				cardSwipeWindow.getContentPane().add(tenDollar);					
				
				twentyFiveDollar = new JButton("$25");
				twentyFiveDollar.setLocation(280, 100);
				twentyFiveDollar.setSize(100, 75);
				ListenForButton lFortwentyFiveDollar = new ListenForButton(); //Making object from within the object's class may be bad
				twentyFiveDollar.addActionListener(lFortwentyFiveDollar);
				cardSwipeWindow.getContentPane().add(twentyFiveDollar);	
				
				fiftyDollar = new JButton("$50");
				fiftyDollar.setLocation(400, 100);
				fiftyDollar.setSize(100, 75);
				ListenForButton lForfiftyDollar = new ListenForButton(); //Making object from within the object's class may be bad
				fiftyDollar.addActionListener(lForfiftyDollar);
				cardSwipeWindow.getContentPane().add(fiftyDollar);	
/*	
				cancelButton = new JButton("Cancel");
				cancelButton.setLocation(200, 270);
				cancelButton.setSize(150, 75);
				Color cancelBackgroundColor = Color.yellow;
				cancelButton.setBackground(cancelBackgroundColor);
				ListenForButton lForcancelButton = new ListenForButton(); //Making object from within the object's class may be bad
				cancelButton.addActionListener(lForcancelButton);
				cardSwipeWindow.getContentPane().add(cancelButton);
*/				
				returnButtonGift = new JButton("Return to Payment Method");
				returnButtonGift.setLocation(130, 300);
				returnButtonGift.setSize(300, 75);
				//Color returnBackgroundButton = Color.yellow;
				//returnButtonGift.setBackground(returnBackgroundButton );
				ListenForButton lForreturnButtonGift = new ListenForButton(); //Making object from within the object's class may be bad
				returnButtonGift.addActionListener(lForreturnButtonGift);
				cardSwipeWindow.getContentPane().add(returnButtonGift);
				
				
				double printAmt = Customer.getAmountPaid();
				amtPaidText = new JTextField("$" + Calculations.format(printAmt));				

				//currencyField.setColumns(10); // Change the size of the text field
				//currencyField.setText("New Text Here"); // Change the initial value of the text field
				amtPaidText.setToolTipText("Amount paid"); // Change the tool tip for the text field
				amtPaidText.setHorizontalAlignment(JLabel.CENTER);
				amtPaidText.setLocation(50, 250);
				amtPaidText.setSize(200, 25);
				//currencyField.setEditable(false);
				cardSwipeWindow.getContentPane().add(amtPaidText);
				
				amtPaid = new JLabel("<html>Amount Paid:<html>");
				amtPaid.setFont(new Font("Ariel", Font.PLAIN, 12));
				amtPaid.setLocation(105, 180);
				amtPaid.setSize(400,100);
				cardSwipeWindow.getContentPane().add(amtPaid);
				
				amtRemaining = new JLabel("<html>Balance Remaining:<html>");
				amtRemaining.setFont(new Font("Ariel", Font.PLAIN, 12));
				amtRemaining.setLocation(335, 180);
				amtRemaining.setSize(400,100);

				cardSwipeWindow.getContentPane().add(amtRemaining);				
								
				amtDueText = new JTextField("$" + Customer.getRemainingBalance());

				amtDueText.setToolTipText("Balance Remaining"); // Change the tool tip for the text field
				amtDueText.setHorizontalAlignment(JLabel.CENTER);
				amtDueText.setLocation(290, 250);
				amtDueText.setSize(200, 25);
				//currencyField.setEditable(false);
				cardSwipeWindow.getContentPane().add(amtDueText);
				/*
				NumberFormat formatter = new DecimalFormat("#0.00");
				Customer customer = (Customer)Main.Customers.get(Main.currentCustNum);
				Main.mainWindow.remainingBalanceText.setText(formatter.format(customer.myCart.myRemBal));
				*/
			}
			Customer customer = (Customer)Main.Customers.get(Main.currentCustNum);
			String totalAmountPaid = Double.toString(customer.getAmountPaid());
			amtDueText.setText(Calculations.format(customer.myCart.myTaxTotal - customer.amountPaid));
			if(e.getSource() == fiveDollar )
			{	
				if( customer.amountPaid + 5.00 > customer.myCart.myTaxTotal )	
				{
					customer.giftCardBalance = (customer.getAmountPaid() + 5) - customer.myCart.myTaxTotal;
					customer.paidGiftCard((customer.myCart.myTaxTotal - customer.getAmountPaid()));	
					System.out.println("Remaining Gift Card Balance:");
					System.out.println(customer.getGiftCardBalance());
					
					//
					customer.myCart.myRemBal = customer.myCart.myTaxTotal - customer.amountPaid;
					amtPaidText.setText(Calculations.format(customer.amountPaid));
					amtDueText.setText(Calculations.format(customer.myCart.myTaxTotal - customer.amountPaid));
					
					
					Display.giftLabel = new JLabel("<html><div style=\"text-align: center;\">Transaction completed. <br> The remaining balance <br> on your gift card is: <html>");
					Display.giftLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
					Display.giftLabel.setLocation(450, 50);
					Display.giftLabel.setSize(400, 150);
					
					NumberFormat formatter = new DecimalFormat("#0.00");
					Display.giftCardBalanceLabel = new JLabel("$" + formatter.format(customer.getGiftCardBalance()));
					Display.giftCardBalanceLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
					Display.giftCardBalanceLabel.setLocation(523, 175);
					Display.giftCardBalanceLabel.setSize(200, 25);
					
					//Added 8/1 -Heath
					Display.giftCardCompletedPayment = new JButton("Done"); 
					Display.giftCardCompletedPayment.setLocation(515, 175+75+10);
					Display.giftCardCompletedPayment.setSize(100, 75);
					//ListenForButton lForGIFTCARDCOMPLETEDPAYMENTButton = new ListenForButton(); //Making object from within the object's class may be bad
					Display.giftCardCompletedPayment.addActionListener(Display.lForGIFTCARDCOMPLETEDPAYMENTButton);
					Main.mainWindow.getContentPane().add(Display.giftCardCompletedPayment);
					// -Heath

					
					Main.mainWindow.getContentPane().add(Display.giftLabel);
					Main.mainWindow.getContentPane().add(Display.giftCardBalanceLabel);
					Main.mainWindow.remove(Display.slideCardLabel);
					
					Main.mainWindow.repaint();
					
					
					cardSwipeWindow.dispose();
					myInstance = null;
				}
				else
					customer.paidGiftCard(5.0);	
				
					customer.myCart.myRemBal = customer.myCart.myTaxTotal - customer.amountPaid;
					amtPaidText.setText(Calculations.format(customer.amountPaid));
					amtDueText.setText(Calculations.format(customer.myCart.myTaxTotal - customer.amountPaid));
					Main.mainWindow.repaint();
			}
			else if( e.getSource() == tenDollar )
			{
				if(customer.amountPaid + 10.00 > customer.myCart.myTaxTotal)
				{
					customer.giftCardBalance = (customer.getAmountPaid() + 10) - customer.myCart.myTaxTotal;
					customer.paidGiftCard((customer.myCart.myTaxTotal - customer.getAmountPaid()));
					System.out.println("Remaining Gift Card Balance:");
					System.out.println(customer.getGiftCardBalance());
					
					customer.myCart.myRemBal = customer.myCart.myTaxTotal - customer.amountPaid;
					amtPaidText.setText(Calculations.format(customer.amountPaid));
					amtDueText.setText(Calculations.format(Cart.myRemBal));
					
					
					Display.giftLabel = new JLabel("<html><div style=\"text-align: center;\">Transaction completed. <br> The remaining balance <br> on your gift card is: <html>");
					Display.giftLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
					Display.giftLabel.setLocation(450, 50);
					Display.giftLabel.setSize(400, 150);
					
					NumberFormat formatter = new DecimalFormat("#0.00");
					customer.getGiftCardBalance();
					Display.giftCardBalanceLabel = new JLabel("$" + formatter.format(customer.getGiftCardBalance()));
					Display.giftCardBalanceLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
					Display.giftCardBalanceLabel.setLocation(523, 175);
					Display.giftCardBalanceLabel.setSize(200, 25);
					
					//Added 8/1 -Heath
					Display.giftCardCompletedPayment = new JButton("Done"); 
					Display.giftCardCompletedPayment.setLocation(515, 175+75+10);
					Display.giftCardCompletedPayment.setSize(100, 75);
					//ListenForButton lForGIFTCARDCOMPLETEDPAYMENTButton = new ListenForButton(); //Making object from within the object's class may be bad
					Display.giftCardCompletedPayment.addActionListener(Display.lForGIFTCARDCOMPLETEDPAYMENTButton);
					Main.mainWindow.getContentPane().add(Display.giftCardCompletedPayment);
					// -Heath
					
					Main.mainWindow.getContentPane().add(Display.giftLabel);
					Main.mainWindow.getContentPane().add(Display.giftCardBalanceLabel);
					Main.mainWindow.remove(Display.slideCardLabel);
					
					Main.mainWindow.repaint();
					
					
					cardSwipeWindow.dispose();
					myInstance = null;
				}
				else
					customer.paidGiftCard(10.0);	
				
				customer.myCart.myRemBal = customer.myCart.myTaxTotal - customer.amountPaid;
				amtPaidText.setText(Calculations.format(customer.amountPaid));
				amtDueText.setText(Calculations.format(customer.myCart.myTaxTotal - customer.amountPaid));
			}
			else if( e.getSource() == twentyFiveDollar )
			{
				if(customer.amountPaid + 25.00 > customer.myCart.myTaxTotal)
				{
					customer.giftCardBalance = (customer.getAmountPaid() + 25) - customer.myCart.myTaxTotal;
					customer.paidGiftCard((customer.myCart.myTaxTotal - customer.getAmountPaid()) );
					System.out.println("Remaining Gift Card Balance:");
					System.out.println(customer.getGiftCardBalance());
					
					customer.myCart.myRemBal = customer.myCart.myTaxTotal - customer.amountPaid;
					amtPaidText.setText(Calculations.format(customer.amountPaid));
					amtDueText.setText(Calculations.format(customer.myCart.myTaxTotal - customer.amountPaid));
					
					
					Display.giftLabel = new JLabel("<html><div style=\"text-align: center;\">Transaction completed. <br> The remaining balance <br> on your gift card is: <html>");
					Display.giftLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
					Display.giftLabel.setLocation(450, 50);
					Display.giftLabel.setSize(400, 150);
					
					NumberFormat formatter = new DecimalFormat("#0.00");
					Display.giftCardBalanceLabel = new JLabel("$" + formatter.format(customer.getGiftCardBalance()));
					Display.giftCardBalanceLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
					Display.giftCardBalanceLabel.setLocation(523, 175);
					Display.giftCardBalanceLabel.setSize(200, 25);
					
					//Added 8/1 -Heath
					Display.giftCardCompletedPayment = new JButton("Done"); 
					Display.giftCardCompletedPayment.setLocation(515, 175+75+10);
					Display.giftCardCompletedPayment.setSize(100, 75);
					//ListenForButton lForGIFTCARDCOMPLETEDPAYMENTButton = new ListenForButton(); //Making object from within the object's class may be bad
					Display.giftCardCompletedPayment.addActionListener(Display.lForGIFTCARDCOMPLETEDPAYMENTButton);
					Main.mainWindow.getContentPane().add(Display.giftCardCompletedPayment);
					// -Heath
					
					Main.mainWindow.getContentPane().add(Display.giftLabel);
					Main.mainWindow.getContentPane().add(Display.giftCardBalanceLabel);
					Main.mainWindow.remove(Display.slideCardLabel);
					
					Main.mainWindow.repaint();
					
					
					cardSwipeWindow.dispose();
					myInstance = null;
				}
				else
					customer.paidGiftCard(25.0);
				customer.myCart.myRemBal = customer.myCart.myTaxTotal - customer.amountPaid;
				amtPaidText.setText(Calculations.format(customer.amountPaid));
				amtDueText.setText(Calculations.format(customer.myCart.myTaxTotal - customer.amountPaid));
			}
			else if( e.getSource() == fiftyDollar )
			{
				if(customer.getAmountPaid() + 50.00 > customer.myCart.myTaxTotal)
				{
					customer.giftCardBalance = (customer.getAmountPaid() + 50) - customer.myCart.myTaxTotal;
					customer.paidGiftCard((customer.myCart.myTaxTotal - customer.getAmountPaid()));	
					System.out.println("Remaining Gift Card Balance:");
					System.out.println(customer.getGiftCardBalance());
					
					customer.myCart.myRemBal = customer.myCart.myTaxTotal - customer.amountPaid;
					amtPaidText.setText(Calculations.format(customer.amountPaid));
					amtDueText.setText(Calculations.format(Cart.myRemBal));
					
					
					Display.giftLabel = new JLabel("<html><div style=\"text-align: center;\">Transaction completed. <br> The remaining balance <br> on your gift card is: <html>");
					Display.giftLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
					Display.giftLabel.setLocation(450, 50);
					Display.giftLabel.setSize(400, 150);
					
					NumberFormat formatter = new DecimalFormat("#0.00");
					customer.getGiftCardBalance();
					Display.giftCardBalanceLabel = new JLabel("$" + formatter.format(customer.getGiftCardBalance()));
					Display.giftCardBalanceLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
					Display.giftCardBalanceLabel.setLocation(523, 175);
					Display.giftCardBalanceLabel.setSize(200, 25);
					
					
					//Added 8/1 -Heath
					Display.giftCardCompletedPayment = new JButton("Done"); 
					Display.giftCardCompletedPayment.setLocation(515, 175+75+10);
					Display.giftCardCompletedPayment.setSize(100, 75);
					//ListenForButton lForGIFTCARDCOMPLETEDPAYMENTButton = new ListenForButton(); //Making object from within the object's class may be bad
					Display.giftCardCompletedPayment.addActionListener(Display.lForGIFTCARDCOMPLETEDPAYMENTButton);
					Main.mainWindow.getContentPane().add(Display.giftCardCompletedPayment);
					// -Heath
					
					
					Main.mainWindow.getContentPane().add(Display.giftLabel);
					Main.mainWindow.getContentPane().add(Display.giftCardBalanceLabel);
					Main.mainWindow.remove(Display.slideCardLabel);
					
					Main.mainWindow.repaint();
					
					cardSwipeWindow.dispose();
					myInstance = null;
				}
				else
					customer.paidGiftCard(50.0);		
				
				customer.myCart.myRemBal = customer.myCart.myTaxTotal - customer.amountPaid;
				amtPaidText.setText(Calculations.format(customer.amountPaid));
				amtDueText.setText(Calculations.format(customer.myCart.myTaxTotal - customer.amountPaid));
				
			}
			else if( e.getSource() == cancelButton )
			{
				cardSwipeWindow.dispose();
				myInstance = null;
			}
			
			else if(e.getSource() == returnButtonGift )
			{
				NumberFormat formatter = new DecimalFormat("#0.00");
				//Customer customer = (Customer)Main.Customers.get(Main.currentCustNum);
				DisplayCart.textArea1.append("Gift payment:\n");
				DisplayCart.textArea2.append("$" + formatter.format(customer.paidBy.GiftCard) + "\n");
				//Main.mainWindow.remainingBalanceText.setText(formatter.format(customer.myCart.myRemBal));
				Main.mainWindow.lForButton.actionPerformed(e);
				Main.mainWindow.remove(Display.slideCardLabel);
				cardSwipeWindow.dispose();	
				myInstance = null;

			} 
			else if(e.getSource() == giftCardCompletedPayment) {
				Display.giftCardCompletedPayment.doClick();
			}
			
		}
	}

	public static CardSwipe getInstance() {
		// TODO Auto-generated method stub
		 if (myInstance == null)
	            myInstance = new CardSwipe();

	        return myInstance;
	}		

}
	
	

