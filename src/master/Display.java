package master;

//import javax.swing.JFrame;
import javax.swing.*;

import com.sun.org.apache.bcel.internal.generic.BALOAD;

import master.CardSwipe.ListenForButton;

//import java.awt.Dimension;
//import java.awt.Toolkit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * @author Heath
 * Guessing all the UI draw stuff will go in here.
 */
public class Display extends JFrame {//extends POSRegister {

	//Line below is for serialization. I don't think we'll need it, but it gets rid of a warning sign so I added it.
	// and, no, I don't understand how to use this.
	private static final long serialVersionUID = 1L; //Ignore
	public ListenForButton lForButton;
	public CardSwipe cardSwipeWindow;
	
	//Employee Mainframe Access Buttons and Window
	public static JButton mainframeAccess;
	
	static RemindTask timer;
	
	//Declarations for all buttons and labels for customer transaction main window
	public static JButton startTransactionButton;
	
	public static JButton yesButton;
	public static JButton noButton;
	public static JButton proceedToCOButton;
	public static JButton cashButton;
	public static JButton checkButton;
	public static JButton creditDebitButton;
	public static JButton helpButton;
	public static JButton enterButton1;
	public static JButton clearButton1;
	public static JButton enterButton2;
	public static JButton clearButton2;
	
	public static JButton jButton1; 
	public static JButton jButton2; 
	public static JButton jButton3; 
	public static JButton jButton4; 
	public static JButton jButton5; 
	public static JButton jButton6; 
	public static JButton jButton7; 
	public static JButton jButton8; 
	public static JButton jButton9;
	public static JButton jButton0; 
	
	public static JButton altPaymentMethodButton;
	
	public static JButton creditCompletedPayment;
	public static JButton debitCompletedPayment;
	public static JButton giftCardCompletedPayment;
	public static JButton cashCompletedPayment;
	public static JButton checkCompletedPayment;
	
	///TEMPORARY//
	public static JButton cashInsertComplete;
	public static JButton checkInsertComplete;
	/////////////
	
	public static JLabel welcomeLabel;
	public static JLabel couponLabel;
	public static JLabel insertCouponLabel;
	public static JLabel selectPaymentLabel;
	public static JLabel insertCashLabel;
	public static JLabel insertCashLabel2;
	public static JLabel slideCardLabel;
	public static JLabel changeDueLabel;
	public static JLabel insertCheckLabel;
	public static JLabel checkCompleteLabel;
	public static JLabel debitLabel;
	public static JLabel creditLabel;
	public static JLabel giftLabel;
	public static JLabel transactionDeniedLabel;
	public static JLabel transactionApprovedLabel;
	public static JLabel background;
	public static JLabel remainingBalanceLabel;
	public static JLabel giftCardBalanceLabel;
	
	
	//Moved - AJV   //This will likely move to the main() function when removing the temp main() from this class
	public static JTextArea textArea1;
	public static JTextArea textArea2;
	
	//public static JTable textTable1;
	public static JScrollPane scrollPane1;
	public static JScrollPane scrollPane2;
	
	public static JTextField remainingBalanceText;
	public static JTextField currencyField;
	public static JTextField changeDueField;
	public static JTextField signatureField;
	
	public static JPasswordField passwordField;
	
	
	
	public Display() { 
		
		//this.setUndecorated(true);//remove comment on final build (or when navigation is stable throughout)
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setBounds(30, 30, 300, 300); //An alternate method for setting size and location of frame
		this.setSize(800, 600); //Where this method is invoked relative to other matters
		this.setLocationRelativeTo(null); //Centers frame in the middle of the screen
		this.setResizable(false);
		this.setVisible(true);
		//this.getContentPane().setBackground(new Color(0,162,255)); //How to color the background
			    
		timer = new RemindTask();
		
		
		/*//This group is an alternate method to center frame in middle of screen
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width / 2) - (this.getWidth() / 2);
		int yPos = (dim.height / 2) - (this.getHeight() / 2);
		this.setLocation(xPos, yPos);*/
		
		
		//newTransaction = new JButton("New Transaction"); //Still need this line
		//ListenForButton lForButton = new ListenForButton(); //Making object from within the object's class may be bad
		//newTransaction.addActionListener(lForButton); //Still need this line
		//newTransaction.doClick();
		//HEATH
		//JPanel thePanel = new JPanel();
		welcomeLabel = new JLabel("Welcome to S-Mart!");
		welcomeLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
		welcomeLabel.setLocation(320, 150);
		welcomeLabel.setSize(200, 100);
		
		//setComponentZOrder(label1, 5); //An attempt to make the graphics go to background --- Deletion fodder 
		this.getContentPane().add(welcomeLabel);
		
		this.getContentPane().setLayout(null); //Setting Layout to null allows coordinate placement //Can't get backDrop to appear if layout is set to null
		
		
		//add the mainframeAccess button to the main screen
		Color mainframeColor = Color.blue;		
		mainframeAccess = new JButton();
		mainframeAccess.setBackground(mainframeColor);
		ListenForButton lFormainframeAccess = new ListenForButton(); //Making object from within the object's class may be bad
		mainframeAccess.addActionListener(lFormainframeAccess);
		mainframeAccess.setSize(30, 15);
		mainframeAccess.setLocation(0, 0);		
		this.getContentPane().add(mainframeAccess);
				
		startTransactionButton = new JButton("Start Transaction");
		startTransactionButton.setLocation(400-100, 225);
		startTransactionButton.setSize(200, 75);
		this.getContentPane().add(startTransactionButton);
		//ListenForButton lForButton = new ListenForButton();
		lForButton = new ListenForButton();
		startTransactionButton.addActionListener(lForButton);
		
		remainingBalanceLabel = new JLabel("Remaining Balance:");
		remainingBalanceLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
		remainingBalanceLabel.setLocation(130, 390);
		remainingBalanceLabel.setSize(200, 100);
		
		remainingBalanceText = new JTextField();
		remainingBalanceText.setFont(new Font("Ariel", Font.PLAIN, 18));
		//remainingBalanceText.setEditable(false);
		remainingBalanceText.setLocation(150, 455);
		remainingBalanceText.setSize(100, 25);
		//HEATH*/
		
		/* Cannot get this to work properly **** Have not included MyCanvas class so this especially cannot work now ****
		 * Deletion fodder
		MyCanvas backDrop = new MyCanvas();
		backDrop.setLocation(300, 225);
		backDrop.setSize(200, 75);
		backDrop.setVisible(true);
		//backDrop.setComponentZOrder(backDrop, 100); //Doesn't seem to work for the MyCanvas class
		this.getContentPane().add(backDrop);
		*/
	}
	
	
	//Implement Listeners
	static class ListenForButton implements ActionListener {
		//@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) {
			NumberFormat formatter = new DecimalFormat("#0.00");
			//Customer customer = (Customer)Main.Customers.get(Main.currentCustNum);
			
			if(e.getSource() == creditCompletedPayment || e.getSource() == cashCompletedPayment) {
	
				if(e.getSource() == creditCompletedPayment) {
					Main.mainWindow.remove(transactionApprovedLabel);
				} else if(e.getSource() == cashCompletedPayment) {
					Main.mainWindow.remove(changeDueLabel);
					Main.mainWindow.remove(changeDueField);
					Main.mainWindow.remove(remainingBalanceText);
				}
				
				
				
				//Removing old transaction Swing components
				Main.mainWindow.getContentPane().remove(scrollPane1); // OLD W/O scroll bars ->   mainWindow.getContentPane().add(textArea1);
				Main.mainWindow.getContentPane().remove(scrollPane2);
				Main.mainWindow.getContentPane().remove(helpButton);
				Main.mainWindow.getContentPane().remove(remainingBalanceLabel);

				//JPanel thePanel = new JPanel();
				welcomeLabel = new JLabel("Welcome to S-Mart!");
				welcomeLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
				welcomeLabel.setLocation(320, 150);
				welcomeLabel.setSize(200, 100);
				System.out.println("newTransaction clicked");
				//setComponentZOrder(label1, 5); //An attempt to make the graphics go to background --- Deletion fodder 
				Main.mainWindow.getContentPane().add(welcomeLabel);
				
				Main.mainWindow.getContentPane().setLayout(null); //Setting Layout to null allows coordinate placement //Can't get backDrop to appear if layout is set to null
				
				/*
				//add the mainframeAccess button to the main screen
				Color mainframeColor = Color.blue;		
				mainframeAccess = new JButton();
				mainframeAccess.setBackground(mainframeColor);
				ListenForButton lFormainframeAccess = new ListenForButton(); //Making object from within the object's class may be bad
				mainframeAccess.addActionListener(lFormainframeAccess);
				mainframeAccess.setSize(30, 15);
				mainframeAccess.setLocation(0, 0);		
				Main.mainWindow.getContentPane().add(mainframeAccess);
				*/
						
				startTransactionButton = new JButton("Start Transaction");
				startTransactionButton.setLocation(400-100, 225);
				startTransactionButton.setSize(200, 75);
				Main.mainWindow.getContentPane().add(startTransactionButton);
				ListenForButton lForButton = new ListenForButton();
				lForButton = new ListenForButton();
				startTransactionButton.addActionListener(lForButton);
				
				remainingBalanceLabel = new JLabel("Remaining Balance:");
				remainingBalanceLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
				remainingBalanceLabel.setLocation(130, 390);
				remainingBalanceLabel.setSize(200, 100);
				
				remainingBalanceText = new JTextField();
				remainingBalanceText.setFont(new Font("Ariel", Font.PLAIN, 18));
				//remainingBalanceText.setEditable(false);
				remainingBalanceText.setLocation(150, 455);
				remainingBalanceText.setSize(100, 25);
				
				
			} else if(e.getSource() == startTransactionButton) {
				
				Main.StartTrans();
				
			}
			else if( e.getSource() == mainframeAccess ){
				databases showDatabase = new databases();
				showDatabase.showMainframeDetails();
			}
			else if(e.getSource() == helpButton) {
				
				HelpWindow.getInstance();
				
			} else if(e.getSource() == yesButton) {				 
				
				////////////////////////////////////////////////////////////////////////////
				//TODO We will need another window to pop up separately for coupon insertion
				//CouponInsertion couponInsertionWindow = new CouponInsertion(); //Works, but not used so commented out because I don't like warnings
				////////////////////////////////////////////////////////////////////////////
				CouponInsertion.getInstance();		
				
				
				insertCouponLabel = new JLabel("<html>Please insert all coupons<br>&#160;&#160;&#160;&#160;&#160;&#160;&#160;into the reader<html>"); //HTML can be added to JLabels to edit formatting "&#160;" adds a space
				insertCouponLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
				insertCouponLabel.setLocation(450, 50); 
				insertCouponLabel.setSize(400, 150);
				
				
				proceedToCOButton = new JButton("Proceed to checkout");
				proceedToCOButton.setLocation(450, 225);
				proceedToCOButton.setSize(200, 100);
				ListenForButton lForYesButton = new ListenForButton(); //Making object from within the object's class may be bad
				proceedToCOButton.addActionListener(lForYesButton);
				
				
				Main.mainWindow.remove(yesButton);
				Main.mainWindow.remove(noButton);
				Main.mainWindow.remove(couponLabel);
				Main.mainWindow.remove(mainframeAccess);
				
				Main.mainWindow.getContentPane().add(mainframeAccess);
				Main.mainWindow.getContentPane().add(insertCouponLabel);
				Main.mainWindow.getContentPane().add(proceedToCOButton);
				
				Main.mainWindow.repaint();
	
			} ///////////////////////////////////////////////////////////////////////////////////////////////
			else if(e.getSource() == mainframeAccess || e.getSource() == noButton || e.getSource() == proceedToCOButton 
					|| e.getSource() == altPaymentMethodButton || e.getSource() == CardSwipe.returnButton 
					|| e.getSource() == CardSwipe.returnButtonGift || e.getSource() == CashInsertion.returnToPayMethods) {
				
				
				//Clears proper labels and buttons
				Customer customer = (Customer)Main.Customers.get(Main.currentCustNum);
				//Laya's addition to set the total balance for POS Mainframe
				
				if (e.getSource() == noButton)
					Main.dailyTotalsSummary.setTotalTransaction(Calculations.getTotalPriceWithTax(customer.myCart));
				//String remBal = formatter.format(customer.myCart.myTaxTotal);
				//remainingBalanceText.setText(remBal);
				
				if(e.getSource() == noButton) {	
					//appends total later to give room for coupons (if any)
					//might want to move/get rid of this, but displays nicer
					String formattedTotal;
					formattedTotal = formatter.format(Cart.myTaxTotal);
					textArea1.append("Total: " + "\n");
					textArea2.append("$" + formattedTotal + "\n");
					Main.mainWindow.remove(yesButton);
					Main.mainWindow.remove(noButton);
					Main.mainWindow.remove(couponLabel);
				} else if(e.getSource() == proceedToCOButton) {					
					Main.mainWindow.remove(insertCouponLabel);
					Main.mainWindow.remove(proceedToCOButton);
				} else if(e.getSource() == altPaymentMethodButton) {
					Main.mainWindow.remove(transactionDeniedLabel);
					Main.mainWindow.remove(altPaymentMethodButton);
				}
				else if( e.getSource() == CardSwipe.returnButton ){
										
					Main.mainWindow.remove(slideCardLabel);
				}
				else if( e.getSource() == CardSwipe.returnButtonGift){
					
					//Main.mainWindow.remove(giftLabel);
					Main.mainWindow.remainingBalanceText.setText(formatter.format(customer.myCart.myRemBal));
				}
				else if( e.getSource() == CashInsertion.returnToPayMethods ){
					Main.mainWindow.remove(cashInsertComplete);
					Main.mainWindow.remove(currencyField);
					Main.mainWindow.remove(insertCashLabel);
					//Main.mainWindow.remainingBalanceText.setText(" ");
					
					
				}
				//This is the point that Payment methods gets to remaining balance text, so at this point, for some reason, at this point, myRemBal = 0
				Main.mainWindow.getContentPane().add(remainingBalanceText);
				Main.mainWindow.remainingBalanceText.setText("$ " + formatter.format(customer.myCart.myTaxTotal - customer.amountPaid));
				//remainingBalanceText.append(remBalance);
				
				selectPaymentLabel = new JLabel("<html>Select your payment method<html>"); //HTML can be added to JLabels to edit formatting "&#160;" adds a space
				selectPaymentLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
				selectPaymentLabel.setLocation(450, 50);
				selectPaymentLabel.setSize(400, 150);
				
				//cashButton
				cashButton = new JButton("Cash");
				cashButton.setLocation(515, 175);
				cashButton.setSize(100, 75);
				ListenForButton lForCashButton = new ListenForButton(); //Making object from within the object's class may be bad
				cashButton.addActionListener(lForCashButton);
				
				//checkButton
				checkButton = new JButton("Check");
				checkButton.setLocation(515, 175+75+10);
				checkButton.setSize(100, 75);
				ListenForButton lForCheckButton = new ListenForButton(); //Making object from within the object's class may be bad
				checkButton.addActionListener(lForCheckButton);
				
				//creditDebitButton
				creditDebitButton = new JButton("Credit/Debit");
				creditDebitButton.setLocation(515, 345);
				creditDebitButton.setSize(100, 75);
				ListenForButton lForCreditDebitButton = new ListenForButton(); //Making object from within the object's class may be bad
				creditDebitButton.addActionListener(lForCreditDebitButton);
				
				//Adding Labels and buttons
				Main.mainWindow.getContentPane().add(selectPaymentLabel);
				
				Main.mainWindow.getContentPane().add(cashButton);
				Main.mainWindow.getContentPane().add(checkButton);
				Main.mainWindow.getContentPane().add(creditDebitButton);
				
				Main.mainWindow.repaint();
				
			} else if(e.getSource() == cashButton) {	
			
				
				
				////////////////////////////////////////////////////////////////////////////
				//TODO We will need another window to pop up separately for cash insertion
				//CashInsertion cashInsertionWindow = new CashInsertion(); //Works, but not used so commented out because I don't like warnings
				////////////////////////////////////////////////////////////////////////////
				CashInsertion.getInstance();
					
				insertCashLabel = new JLabel("<html>Please insert cash now<html>");
				insertCashLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
				insertCashLabel.setLocation(450, 50);
				insertCashLabel.setSize(400, 150);
					
				/*insertCashLabel2 = new JLabel("<html>Remining Balance: <html>");
				insertCashLabel2.setFont(new Font("Ariel", Font.PLAIN, 18));
				insertCashLabel2.setLocation(450, 750);
				insertCashLabel2.setSize(400, 150);
				*/
					
				
				currencyField = new JTextField();
				//currencyField.setColumns(10); // Change the size of the text field
				currencyField.setText(formatter.format(Customer.myCart.myRemBal)); // Change the initial value of the text field
				currencyField.setToolTipText("Cash amount inserted"); // Change the tool tip for the text field
				currencyField.setLocation(450, 200);
				currencyField.setSize(200, 25);
				
				//currencyField.setEditable(false);
				//DisplayCart.textArea1.append("Cash payment:");
				//DisplayCart.textArea2.append(Double.toString(Customer.amountPaid));
				//From account manager program - We may be able to use this to update the currencyFields 
				//balanceField.setText(Double.toString(me.getBalance()));
				//Otherwise may want to create a eventListener like in the midterm review
				
				
				
				//   NOT temporary code  - Don't need button on screen but still need button workings -Heath
				cashInsertComplete = new JButton("SEND PAID EVENT"); //Still need this line
				//cashInsertComplete.setLocation(450, 175+75+10);
				//cashInsertComplete.setSize(200, 75);
				ListenForButton lForCashInsertCompleteButton = new ListenForButton(); //Making object from within the object's class may be bad
				cashInsertComplete.addActionListener(lForCashInsertCompleteButton); //Still need this line
				//Main.mainWindow.getContentPane().add(cashInsertComplete);
				
				
				
				
				
				Main.mainWindow.remove(selectPaymentLabel);
				Main.mainWindow.remove(cashButton);
				Main.mainWindow.remove(checkButton);
				Main.mainWindow.remove(creditDebitButton);
				
				Main.mainWindow.getContentPane().add(insertCashLabel);//removed because it screwed things up ~wigmore
				Main.mainWindow.getContentPane().add(currencyField);
				
				Main.mainWindow.repaint();
				
			} else if(e.getSource() == checkButton) {
				
				////////////////////////////////////////////////////////////////////////////
				//TODO We will need another window to pop up separately for cash insertion
				//CheckInsertion checkInsertionWindow = new CheckInsertion(); //Works, but not used so commented out because I don't like warnings
				////////////////////////////////////////////////////////////////////////////
				CheckInsertion.getInstance();
				insertCheckLabel = new JLabel("<html>Please insert check now<html>");
				insertCheckLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
				insertCheckLabel.setLocation(450, 50);
				insertCheckLabel.setSize(400, 150);
				
				currencyField = new JTextField("$0.0", 15);
				//currencyField.setColumns(10); // Change the size of the text field
				//currencyField.setText("New Text Here"); // Change the initial value of the text field
				currencyField.setToolTipText("Amount paid"); // Change the tool tip for the text field
				currencyField.setLocation(450, 200);
				currencyField.setSize(200, 25);
				//currencyField.setEditable(false);
				
				/////////TEMPORARY CODE/////////
				//++++++++++++++++++++++++++++++
				checkInsertComplete = new JButton("<html>SEND CHECK ACCEPTED<br> EVENT<html>");
				checkInsertComplete.setLocation(450, 175+75+10);
				checkInsertComplete.setSize(200, 75);
				ListenForButton lForCheckInsertCompleteButton = new ListenForButton(); //Making object from within the object's class may be bad
				checkInsertComplete.addActionListener(lForCheckInsertCompleteButton);
				Main.mainWindow.getContentPane().add(checkInsertComplete);
				//++++++++++++++++++++++++++++++
				//////END OF TEMPORARY CODE/////
				
				Main.mainWindow.remove(selectPaymentLabel);
				Main.mainWindow.remove(cashButton);
				Main.mainWindow.remove(checkButton);
				Main.mainWindow.remove(creditDebitButton);
				
				Main.mainWindow.getContentPane().add(insertCheckLabel);
				Main.mainWindow.getContentPane().add(currencyField);
				
				Main.mainWindow.repaint();
				
			} else if(e.getSource() == creditDebitButton) {
				
				slideCardLabel = new JLabel("<html><div style=\"text-align: center;\">Please slide your card <br> through the card reader<br> and follow the instructions<html>");
				slideCardLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
				slideCardLabel.setLocation(450, 50);
				slideCardLabel.setSize(400, 150);
				
				////////////////////////////////////////////////////////////////////////////
				//TODO We will need another window to pop up separately for simulating swiping a card 
				//CardSwipe cardSwipeWindow = new CardSwipe(); //Works, but not used so commented out because I don't like warnings
				////////////////////////////////////////////////////////////////////////////
				CardSwipe.getInstance();	
				
				Main.mainWindow.remove(selectPaymentLabel);
				Main.mainWindow.remove(cashButton);
				Main.mainWindow.remove(checkButton);
				Main.mainWindow.remove(creditDebitButton);
				
				Main.mainWindow.getContentPane().add(slideCardLabel);				
				Main.mainWindow.repaint();				
				
			} 
			
				else if(e.getSource() == cashInsertComplete) {
				
				changeDueLabel = new JLabel("<html><div style=\"text-align: center;\">&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;Change due<html>");
				changeDueLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
				changeDueLabel.setLocation(450, 50);
				changeDueLabel.setSize(400, 150);
				
				changeDueField = new JTextField("$0.0", 15);
				changeDueField.setText("$" + formatter.format(Math.abs(Customer.myCart.myTaxTotal - Customer.getAmountPaid())));
				changeDueField.setHorizontalAlignment(JLabel.CENTER);
				changeDueField.setToolTipText("Change to be returned to you"); // Change the tool tip for the text field
				changeDueField.setLocation(450, 200);
				changeDueField.setSize(200, 25);
				//currencyField.setEditable(false);
				
				
				///TEMPORARY CODE///////////
				Main.mainWindow.remove(cashInsertComplete);
				////////////////////////////
				
				Main.mainWindow.remove(insertCashLabel);
				Main.mainWindow.remove(currencyField);
				
				Main.mainWindow.getContentPane().add(changeDueLabel);
				Main.mainWindow.getContentPane().add(changeDueField);
				
				Main.mainWindow.repaint();
				
				cashCompletedPayment = new JButton("New Transaction"); //Still need this line
				ListenForButton lForButton = new ListenForButton(); //Making object from within the object's class may be bad
				cashCompletedPayment.addActionListener(lForButton); //Still need this line
				cashCompletedPayment.doClick();
				
			} 
		
				
				else if(e.getSource() == checkInsertComplete) {
				
				checkCompleteLabel = new JLabel("<html><div style=\"text-align: center;\">Transaction completed. <br> Thank you for your business!<html>");
				checkCompleteLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
				checkCompleteLabel.setLocation(450, 50);
				checkCompleteLabel.setSize(400, 150);
				
				
				///TEMPORARY CODE///////////
				Main.mainWindow.remove(checkInsertComplete);
				////////////////////////////
				
				Main.mainWindow.getContentPane().add(checkCompleteLabel);
				Main.mainWindow.remove(insertCheckLabel);
				Main.mainWindow.remove(currencyField);
				
				Main.mainWindow.repaint();
				
			} else if(e.getSource() == CardSwipe.debitButton) { //From CardSwipe class
				
				debitLabel = new JLabel("<html><div style=\"text-align: center;\">Please enter your pin number <br> followed by the enter key<html>");
				debitLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
				debitLabel.setLocation(450, 50);
				debitLabel.setSize(400, 150);
				
				passwordField = new JPasswordField();
				passwordField.setLocation(450, 200);
				passwordField.setSize(225, 25);
				passwordField.setHorizontalAlignment(JTextField.RIGHT);
				
				//in EnterButton listener 
				//passwordField.getPassword();
				//char[] mander;
				
				enterButton2 = new JButton("Enter");
				enterButton2.setLocation(600, 250);
				enterButton2.setSize(75, 50);
				ListenForButton lForEnterButton = new ListenForButton(); //Making object from within the object's class may be bad
				enterButton2.addActionListener(lForEnterButton);
				
				clearButton2 = new JButton("Clear");
				clearButton2.setLocation(600, 300);
				clearButton2.setSize(75, 50);
				ListenForButton lForClearButton = new ListenForButton(); //Making object from within the object's class may be bad
				clearButton2.addActionListener(lForClearButton);
				
				
				jButton0 = new JButton("0");
				jButton1 = new JButton("1"); 
				jButton2 = new JButton("2"); 
				jButton3 = new JButton("3"); 
				jButton4 = new JButton("4"); 
				jButton5 = new JButton("5"); 
				jButton6 = new JButton("6"); 
				jButton7 = new JButton("7"); 
				jButton8 = new JButton("8"); 
				jButton9 = new JButton("9");
				 
				
				jButton0.setLocation(550+50, 400-50);
				jButton1.setLocation(400+50, 400-50);
				jButton2.setLocation(450+50, 400-50);
				jButton3.setLocation(500+50, 400-50);
				jButton4.setLocation(400+50, 350-50);
				jButton5.setLocation(450+50, 350-50);
				jButton6.setLocation(500+50, 350-50);
				jButton7.setLocation(400+50, 300-50);
				jButton8.setLocation(450+50, 300-50);
				jButton9.setLocation(500+50, 300-50);
				
				
				jButton0.setSize(75, 50);
				jButton1.setSize(50, 50);
				jButton2.setSize(50, 50);
				jButton3.setSize(50, 50);
				jButton4.setSize(50, 50);
				jButton5.setSize(50, 50);
				jButton6.setSize(50, 50);
				jButton7.setSize(50, 50);
				jButton8.setSize(50, 50);
				jButton9.setSize(50, 50);
				
				
				ListenForButton lForNumberButton = new ListenForButton(); //Making object from within the object's class may be bad
				jButton0.addActionListener(lForNumberButton);
				jButton1.addActionListener(lForNumberButton);
				jButton2.addActionListener(lForNumberButton);
				jButton3.addActionListener(lForNumberButton);
				jButton4.addActionListener(lForNumberButton);
				jButton5.addActionListener(lForNumberButton);
				jButton6.addActionListener(lForNumberButton);
				jButton7.addActionListener(lForNumberButton);
				jButton8.addActionListener(lForNumberButton);
				jButton9.addActionListener(lForNumberButton);
				
				
				Main.mainWindow.getContentPane().add(jButton0);
				Main.mainWindow.getContentPane().add(jButton1);
				Main.mainWindow.getContentPane().add(jButton2);
				Main.mainWindow.getContentPane().add(jButton3);
				Main.mainWindow.getContentPane().add(jButton4);
				Main.mainWindow.getContentPane().add(jButton5);
				Main.mainWindow.getContentPane().add(jButton6);
				Main.mainWindow.getContentPane().add(jButton7);
				Main.mainWindow.getContentPane().add(jButton8);
				Main.mainWindow.getContentPane().add(jButton9);
				
				
				Main.mainWindow.getContentPane().add(passwordField);
				Main.mainWindow.getContentPane().add(enterButton2);
				Main.mainWindow.getContentPane().add(clearButton2);
				Main.mainWindow.getContentPane().add(debitLabel);
				Main.mainWindow.remove(slideCardLabel);
				
				Main.mainWindow.repaint();
				
				System.out.println("debit button pressed");
				
			} else if(e.getSource() == CardSwipe.creditButton) { //From CardSwipe class
				
				creditLabel = new JLabel("<html><div style=\"text-align: center;\">Please provide signature <br> for transaction <html>");
				creditLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
				creditLabel.setLocation(450, 50);
				creditLabel.setSize(400, 150);
				
				
				signatureField = new JTextField(15);
				//currencyField.setColumns(10); // Change the size of the text field
				//currencyField.setText("New Text Here"); // Change the initial value of the text field
				signatureField.setHorizontalAlignment(JLabel.CENTER);
				signatureField.setToolTipText("Use your finger or the stylus"); // Change the tool tip for the text field
				signatureField.setLocation(450, 200);
				signatureField.setSize(200, 40);
				
				
				
				enterButton1 = new JButton("Enter");
				enterButton1.setLocation(450, 300);
				enterButton1.setSize(75, 50);
				ListenForButton lForEnterButton1 = new ListenForButton(); //Making object from within the object's class may be bad
				enterButton1.addActionListener(lForEnterButton1);
				
				clearButton1 = new JButton("Clear");
				clearButton1.setLocation(575, 300);
				clearButton1.setSize(75, 50);
				ListenForButton lForClearButton = new ListenForButton(); //Making object from within the object's class may be bad
				clearButton1.addActionListener(lForClearButton);
				
				Main.mainWindow.getContentPane().add(enterButton1);
				Main.mainWindow.getContentPane().add(clearButton1);
				Main.mainWindow.getContentPane().add(signatureField);
				Main.mainWindow.getContentPane().add(creditLabel);
				Main.mainWindow.remove(slideCardLabel);
				
				Main.mainWindow.repaint();
				
				System.out.println("credit button pressed");
				
			}// else if(e.getSource() == CardSwipe.giftButton) { //From CardSwipe class
				//Customer customer = (Customer)Main.Customers.get(Main.currentCustNum);
			/*
				if( customer.getAmountPaid() >= customer.myCart.myTaxTotal )
				{
					
				giftLabel = new JLabel("<html><div style=\"text-align: center;\">Transaction completed. <br> The remaining balance <br> on your gift card is: <html>");
				giftLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
				giftLabel.setLocation(450, 50);
				giftLabel.setSize(400, 150);
				
				
				giftCardBalanceLabel = new JLabel("$" + customer.getGiftCardBalance());
				giftCardBalanceLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
				giftCardBalanceLabel.setLocation(523, 175);
				giftCardBalanceLabel.setSize(200, 25);
				
				Main.mainWindow.getContentPane().add(giftLabel);
				Main.mainWindow.getContentPane().add(giftCardBalanceLabel);
				Main.mainWindow.remove(slideCardLabel);
				
				Main.mainWindow.repaint();
				}
				*/
				//System.out.println("Gift button pressed");
				
			//}
		else if(e.getSource() == enterButton1) { //For credit

				//If we want to implement a way to approve or decline credit payment
				
				System.out.println("enterButton1 button pressed");
				
				if(signatureField.getText().equals("Rodion")) { //Would query a big database IRL
					
					System.out.println("sig Rodion button pressed");
					
					transactionDeniedLabel = new JLabel("<html><div style=\"text-align: center;\">Transaction has been denied. <br> Please choose a different <br> method of payment. <html>");
					transactionDeniedLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
					transactionDeniedLabel.setLocation(450, 50);
					transactionDeniedLabel.setSize(400, 150);
					
					
					altPaymentMethodButton = new JButton("Ok");
					altPaymentMethodButton.setLocation(515, 175+75+10);
					altPaymentMethodButton.setSize(100, 75);
					ListenForButton lForAltButton = new ListenForButton(); //Making object from within the object's class may be bad
					altPaymentMethodButton.addActionListener(lForAltButton);
					
					Main.mainWindow.remove(enterButton1);
					Main.mainWindow.remove(clearButton1);
					Main.mainWindow.remove(signatureField);
					Main.mainWindow.remove(creditLabel);
					
					Main.mainWindow.getContentPane().add(transactionDeniedLabel);
					Main.mainWindow.getContentPane().add(altPaymentMethodButton);
					
					Main.mainWindow.repaint();
					
				} else {
					System.out.println("sig " +signatureField.getText()+ " pressed");
					transactionApprovedLabel = new JLabel("<html><div style=\"text-align: center;\">Transaction has been approved. <br> Thank you for your business.<html>");
					transactionApprovedLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
					transactionApprovedLabel.setLocation(450, 50);
					transactionApprovedLabel.setSize(400, 150);
					
					
					
					Main.mainWindow.remove(enterButton1);
					Main.mainWindow.remove(clearButton1);
					Main.mainWindow.remove(signatureField);
					Main.mainWindow.remove(creditLabel);
					
					Main.mainWindow.getContentPane().add(transactionApprovedLabel);
					
					Main.mainWindow.repaint();
					//////////////////////////////////////////////////////////////////////////////////////////WORKING HERE
					/*
					newTransaction = new JButton("New Transaction"); //Still need this line
					ListenForButton lForButton = new ListenForButton(); //Making object from within the object's class may be bad
					newTransaction.addActionListener(lForButton); //Still need this line
					newTransaction.doClick();
					 */
					creditCompletedPayment = new JButton("New Transaction"); //Still need this line
					ListenForButton lForButton = new ListenForButton(); //Making object from within the object's class may be bad
					creditCompletedPayment.addActionListener(lForButton); //Still need this line
					
					
					
					//timer.run();
					
					creditCompletedPayment.doClick();
					
					
					//Main.mainWindow.waitBob();
					
				}
				
			} else if(e.getSource() == clearButton1) {
				
				signatureField.setText(" ");
				
			}  else if(e.getSource() == enterButton2) { //For debit
				
				//Submit data from field
				String password = passwordField.getText();
				
				char[] charArray = password.toCharArray();
				
				
				//Below is the Wigmore function
				if(charArray[password.length()-1] == '0') { //Would query a big database IRL
					
					transactionDeniedLabel = new JLabel("<html><div style=\"text-align: center;\">Transaction has been denied. <br> Please choose a different <br> method of payment. <html>");
					transactionDeniedLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
					transactionDeniedLabel.setLocation(450, 50);
					transactionDeniedLabel.setSize(400, 150);
					
					
					altPaymentMethodButton = new JButton("Ok");
					altPaymentMethodButton.setLocation(515, 175+75+10);
					altPaymentMethodButton.setSize(100, 75);
					ListenForButton lForAltButton = new ListenForButton(); //Making object from within the object's class may be bad
					altPaymentMethodButton.addActionListener(lForAltButton);
					
					
					Main.mainWindow.remove(debitLabel);
					Main.mainWindow.remove(passwordField);
					Main.mainWindow.remove(enterButton2);
					Main.mainWindow.remove(clearButton2);
					Main.mainWindow.remove(jButton0);
					Main.mainWindow.remove(jButton1);
					Main.mainWindow.remove(jButton2);
					Main.mainWindow.remove(jButton3);
					Main.mainWindow.remove(jButton4);
					Main.mainWindow.remove(jButton5);
					Main.mainWindow.remove(jButton6);
					Main.mainWindow.remove(jButton7);
					Main.mainWindow.remove(jButton8);
					Main.mainWindow.remove(jButton9);
					
					Main.mainWindow.getContentPane().add(transactionDeniedLabel);
					Main.mainWindow.getContentPane().add(altPaymentMethodButton);
					
					Main.mainWindow.repaint();
					
				} else {
					
					transactionApprovedLabel = new JLabel("<html><div style=\"text-align: center;\">Transaction has been approved. <br> Thank you for your business.<html>");
					transactionApprovedLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
					transactionApprovedLabel.setLocation(450, 50);
					transactionApprovedLabel.setSize(400, 150);
					
					Main.mainWindow.remove(debitLabel);
					Main.mainWindow.remove(passwordField);
					Main.mainWindow.remove(enterButton2);
					Main.mainWindow.remove(clearButton2);
					Main.mainWindow.remove(jButton0);
					Main.mainWindow.remove(jButton1);
					Main.mainWindow.remove(jButton2);
					Main.mainWindow.remove(jButton3);
					Main.mainWindow.remove(jButton4);
					Main.mainWindow.remove(jButton5);
					Main.mainWindow.remove(jButton6);
					Main.mainWindow.remove(jButton7);
					Main.mainWindow.remove(jButton8);
					Main.mainWindow.remove(jButton9);
					
					Main.mainWindow.getContentPane().add(transactionApprovedLabel);
					
					Main.mainWindow.repaint();
					
				}
				
				
				System.out.println(charArray[password.length()-1]);
				System.out.println(password);
				
			} else if(e.getSource() == clearButton2) {
				
				passwordField.setText("");
				
			} else if(e.getSource() == jButton0) {
				passwordField.setText(passwordField.getText() + '0');
			} else if(e.getSource() == jButton1) {
				passwordField.setText(passwordField.getText() + '1');
			} else if(e.getSource() == jButton2) {
				passwordField.setText(passwordField.getText() + '2');
			} else if(e.getSource() == jButton3) {
				passwordField.setText(passwordField.getText() + '3');
			} else if(e.getSource() == jButton4) {
				passwordField.setText(passwordField.getText() + '4');
			} else if(e.getSource() == jButton5) {
				passwordField.setText(passwordField.getText() + '5');
			} else if(e.getSource() == jButton6) {
				passwordField.setText(passwordField.getText() + '6');
			} else if(e.getSource() == jButton7) {
				passwordField.setText(passwordField.getText() + '7');
			} else if(e.getSource() == jButton8) {
				passwordField.setText(passwordField.getText() + '8');
			} else if(e.getSource() == jButton9) {
				passwordField.setText(passwordField.getText() + '9');
			} 
			
			
			
		}
		
		// End of actionPerformed(ActionEvent e)
	}// End of class ListenForButton
	
	public void waitBob() {
		try {
		    Thread.sleep(3000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}
	
	
	class RemindTask extends TimerTask {

        @Override
        public synchronized void run() {
            System.out.println("ReminderTask is completed by Java timer");
            try {
				timer.wait(5000);
				timer.notify();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            timer.cancel(); //Not necessary because we call System.exit
            //System.exit(0); //Stops the AWT thread (and everything else)
        }
    }


	
} //End of Display class
