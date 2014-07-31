package master;

import javax.swing.*;

//import sun.awt.HorizBagLayout;
import master.Display.ListenForButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

//This class simulates the process of inserting cash
public class CashInsertion extends JFrame { //Extending Display causes some issues with the blue button
	
	private static final long serialVersionUID = 1L;


	private static CashInsertion myInstance;

	public JLabel insertCashLabel;
	public static JButton returnToPayMethods;
	public JFrame insertCashFrame;
	public static JLabel amtPaid;
	public static JLabel amtRemaining;
	//cash buttons
	public static JButton hundredButton;
	public static JButton fiftyButton;
	public static JButton twentyButton;
	public static JButton tenButton;
	public static JButton fiveButton;
	public static JButton oneButton;
	//coin buttons
	public static JButton quarterButton;
	public static JButton dimeButton;
	public static JButton nickelButton;
	public static JButton pennyButton;
	
	public static JTextField amtPaidText;
	public static JTextField amtDueText;
	
	
	public CashInsertion(){
		
		NumberFormat formatter = new DecimalFormat("#0.00");
		Customer customer = (Customer)Main.Customers.get(Main.currentCustNum);
		//this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setBounds(30, 30, 300, 300); //An alternate method for setting size and location of frame
		this.setSize(800, 600); //Where this method is invoked relative to other matters
		
		//this.setLocationRelativeTo(null); //Centers frame in the middle of the screen
		this.setResizable(false);
		this.setVisible(true);
		this.getContentPane().setLayout(null);
		
		
		insertCashLabel = new JLabel("<html>Please insert cash now.<html>");//possibly add a return to payment methods option once this works
		insertCashLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
		insertCashLabel.setLocation(320, 0);
		insertCashLabel.setSize(400,100);
		this.getContentPane().add(insertCashLabel);
		
		insertCashFrame = this;
		
		//button for hundreds
		hundredButton = new JButton(new ImageIcon( getClass().getResource("Images/100bill.png") ) );
		hundredButton.setFont(new Font("Ariel", Font.PLAIN, 12));
		hundredButton.setLocation(120, 80);
		hundredButton.setSize(50, 116);
		insertCashFrame.getContentPane().add(hundredButton);
		ListenForButton lFoHundredButton = new ListenForButton();
		hundredButton.addActionListener(lFoHundredButton);
		
		//button for fiftys
		fiftyButton = new JButton(new ImageIcon(getClass().getResource("Images/50bill.png")));
		fiftyButton.setFont(new Font("Ariel", Font.PLAIN, 12));
		fiftyButton.setLocation(120 + 100, 80);
		fiftyButton.setSize(50, 116);
		insertCashFrame.getContentPane().add(fiftyButton);
		ListenForButton lFoFiftyButton = new ListenForButton(); //Making object from within the object's class may be bad
		fiftyButton.addActionListener(lFoFiftyButton);
		//fiftyButton.setIcon(new ImageIcon(getClass().getResource("Images/JaneDoe.png")))
		
		//button for twankeys
		twentyButton = new JButton(new ImageIcon(getClass().getResource("Images/20bill.png")));
		twentyButton.setFont(new Font("Ariel", Font.PLAIN, 12));
		twentyButton.setLocation(120 + 200, 80);
		twentyButton.setSize(50, 116);
		insertCashFrame.getContentPane().add(twentyButton);
		ListenForButton lFoTwentyButton = new ListenForButton(); //Making object from within the object's class may be bad
		twentyButton.addActionListener(lFoTwentyButton);
		
		//button for tens
		tenButton = new JButton(new ImageIcon(getClass().getResource("Images/10bill.png")));
		tenButton.setFont(new Font("Ariel", Font.PLAIN, 12));
		tenButton.setLocation(120 + 300, 80);
		tenButton.setSize(50, 116);
		insertCashFrame.getContentPane().add(tenButton);
		ListenForButton lFoTenButton = new ListenForButton(); //Making object from within the object's class may be bad
		tenButton.addActionListener(lFoTenButton);
		
		//button for five-spots
		fiveButton = new JButton(new ImageIcon(getClass().getResource("Images/5bill.png")));
		fiveButton.setFont(new Font("Ariel", Font.PLAIN, 12));
		fiveButton.setLocation(120 + 400, 80);
		fiveButton.setSize(50, 116);
		insertCashFrame.getContentPane().add(fiveButton);
		ListenForButton lFoFiveButton = new ListenForButton(); //Making object from within the object's class may be bad
		fiveButton.addActionListener(lFoFiveButton);
		
		//button for singles
		oneButton = new JButton(new ImageIcon(getClass().getResource("Images/1bill.png")));
		oneButton.setFont(new Font("Ariel", Font.PLAIN, 12));
		oneButton.setLocation(120 + 500, 80);
		oneButton.setSize(50, 116);
		insertCashFrame.getContentPane().add(oneButton);
		ListenForButton lFoOneButton = new ListenForButton(); //Making object from within the object's class may be bad
		oneButton.addActionListener(lFoOneButton);
		
		//button for quarters
		quarterButton = new JButton(new ImageIcon(getClass().getResource("Images/quarter.png")));
		quarterButton.setFont(new Font("Ariel", Font.PLAIN, 12));
		quarterButton.setLocation(220, 225);
		quarterButton.setSize(75, 75);
		insertCashFrame.getContentPane().add(quarterButton);
		ListenForButton lFoQuarterButton = new ListenForButton(); //Making object from within the object's class may be bad
		quarterButton.addActionListener(lFoQuarterButton);
		
		//button for dimes
		dimeButton = new JButton(new ImageIcon(getClass().getResource("Images/dime.png")));
		dimeButton.setFont(new Font("Ariel", Font.PLAIN, 12));
		dimeButton.setLocation(220 + 100, 225);
		dimeButton.setSize(75, 75);
		insertCashFrame.getContentPane().add(dimeButton);
		ListenForButton lFoDimeButton = new ListenForButton(); //Making object from within the object's class may be bad
		dimeButton.addActionListener(lFoDimeButton);
		
		//button for nickels
		nickelButton = new JButton(new ImageIcon(getClass().getResource("Images/nickel.png")));
		nickelButton.setFont(new Font("Ariel", Font.PLAIN, 12));
		nickelButton.setLocation(220 + 200, 225);
		nickelButton.setSize(75, 75);
		insertCashFrame.getContentPane().add(nickelButton);
		ListenForButton lFoNickelButton = new ListenForButton(); //Making object from within the object's class may be bad
		nickelButton.addActionListener(lFoNickelButton);
		
		//button for pennies
		pennyButton = new JButton(new ImageIcon(getClass().getResource("Images/penny.png")));
		pennyButton.setFont(new Font("Ariel", Font.PLAIN, 12));
		pennyButton.setLocation(220 + 300, 225);
		pennyButton.setSize(75, 75);
		insertCashFrame.getContentPane().add(pennyButton);
		ListenForButton lFoPennyButton = new ListenForButton(); //Making object from within the object's class may be bad
		pennyButton.addActionListener(lFoPennyButton);
		
		//return to payment methods
		returnToPayMethods = new JButton("Return to Payment Methods");
		returnToPayMethods.setFont(new Font("Ariel", Font.PLAIN, 18));
		returnToPayMethods.setLocation(265, 500);
		returnToPayMethods.setSize(300, 75);
		insertCashFrame.getContentPane().add(returnToPayMethods);
		ListenForButton lFoReturnToPayMethods = new ListenForButton(); //Making object from within the object's class may be bad
		returnToPayMethods.addActionListener(lFoReturnToPayMethods);
		
		//Customer thisOne = (Customer)Main.Customers.get(Main.currentCustNum);
		//double leftToPay = Cart.myTaxTotal - Customer.amountPaid;
		
		Main.mainWindow.remove(Main.welcomeLabel);
		Main.mainWindow.remove(Main.startTransactionButton);
		
		double printAmt = Customer.getAmountPaid();
		formatter.format(printAmt);
		amtPaidText = new JTextField("$" + (formatter.format(printAmt)), 15);
		

		//currencyField.setColumns(10); // Change the size of the text field
		//currencyField.setText("New Text Here"); // Change the initial value of the text field
		amtPaidText.setToolTipText("Amount paid"); // Change the tool tip for the text field
		amtPaidText.setHorizontalAlignment(JLabel.CENTER);
		amtPaidText.setLocation(300, 370);
		amtPaidText.setSize(200, 25);
		//currencyField.setEditable(false);
		insertCashFrame.getContentPane().add(amtPaidText);
		
		amtPaid = new JLabel("<html>Amount Paid:<html>");
		amtPaid.setFont(new Font("Ariel", Font.PLAIN, 12));
		amtPaid.setLocation(355, 300);
		amtPaid.setSize(400,100);
		this.getContentPane().add(amtPaid);
		
		amtRemaining = new JLabel("<html>Balance Remaining:<html>");
		amtRemaining.setFont(new Font("Ariel", Font.PLAIN, 12));
		amtRemaining.setLocation(345, 375);
		amtRemaining.setSize(400,100);
		this.getContentPane().add(amtRemaining);
		
		formatter.format(Cart.myTaxTotal);
		amtDueText = new JTextField("$" + formatter.format(customer.myCart.myTaxTotal - customer.getAmountPaid()));
		
		amtDueText.setToolTipText("Balance Remaining"); // Change the tool tip for the text field
		amtDueText.setHorizontalAlignment(JLabel.CENTER);
		amtDueText.setLocation(300, 450);
		amtDueText.setSize(200, 25);
		//currencyField.setEditable(false);
		insertCashFrame.getContentPane().add(amtDueText);		
			
	}

	private class ListenForButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			NumberFormat formatter = new DecimalFormat("#0.00");
			Customer customer = (Customer)Main.Customers.get(Main.currentCustNum);
			double cashThisTransaction = 0;
			
			//So Main can Listen
			Main.mainWindow.lForButton.actionPerformed(e);
		   
			if(e.getSource() == returnToPayMethods) {
				cashThisTransaction = cashThisTransaction + customer.getAmountPaid();
				DisplayCart.textArea1.append("Cash payment:\n");
				DisplayCart.textArea2.append("$" + formatter.format(cashThisTransaction) + "\n");
				Main.mainWindow.remainingBalanceText.setText(" ");
				Main.mainWindow.remainingBalanceText.setText(formatter.format(customer.myCart.myTaxTotal- cashThisTransaction));
				insertCashFrame.dispose();
				myInstance = null;
			}
			else if(e.getSource() == hundredButton) {
			//	System.out.println(customer.myCart.myTotalPrice);
			//	System.out.println(Cart.myTotalPrice);
				customer.paidCash(100.00);
				customer.setAmountPaidCash(100.00);
				Main.mainWindow.currencyField.setText(formatter.format(Main.dailyTotalsSummary.getTotalCash())); //This line updates the currencyField on the register screen as you insert cash. -Leah
			}
			else if(e.getSource() == fiftyButton) {
				customer.paidCash(50.00);
				customer.setAmountPaidCash(50.00);
				Main.mainWindow.currencyField.setText(formatter.format(Main.dailyTotalsSummary.getTotalCash()));
			}
			else if(e.getSource() == twentyButton) {
				customer.paidCash(20.00);
				customer.setAmountPaidCash(20.00);
				Main.mainWindow.currencyField.setText(formatter.format(Main.dailyTotalsSummary.getTotalCash()));

			}
			else if(e.getSource() == tenButton) {
				customer.paidCash(10.00);
				customer.setAmountPaidCash(10.00);
				Main.mainWindow.currencyField.setText(formatter.format(Main.dailyTotalsSummary.getTotalCash()));

			}
			else if(e.getSource() == fiveButton) {
				customer.paidCash(5.00);
				customer.setAmountPaidCash(5.00);
				Main.mainWindow.currencyField.setText(formatter.format(Main.dailyTotalsSummary.getTotalCash()));

			}
			else if(e.getSource() == oneButton) {
				customer.paidCash(1.00);
				customer.setAmountPaidCash(1.00);
				Main.mainWindow.currencyField.setText(formatter.format(Main.dailyTotalsSummary.getTotalCash()));

			}
			else if(e.getSource() == quarterButton) {
				customer.paidCash(0.25);
				customer.setAmountPaidCash(0.25);
				Main.mainWindow.currencyField.setText(formatter.format(Main.dailyTotalsSummary.getTotalCash()));

			}
			else if(e.getSource() == dimeButton) {
				customer.paidCash(00.10);
				customer.setAmountPaidCash(0.10);
				Main.mainWindow.currencyField.setText(formatter.format(Main.dailyTotalsSummary.getTotalCash()));

			}
			else if(e.getSource() == nickelButton) {
				customer.paidCash(00.05);
				customer.setAmountPaidCash(0.05);
				Main.mainWindow.currencyField.setText(formatter.format(Main.dailyTotalsSummary.getTotalCash()));

			}
			else if(e.getSource() == pennyButton) {
				customer.paidCash(0.01);
				customer.setAmountPaidCash(0.01);
				Main.mainWindow.currencyField.setText(formatter.format(Main.dailyTotalsSummary.getTotalCash()));
			}
			else if( e.getSource() == Main.mainWindow.mainframeAccess ){
				databases showDatabase = new databases();
				showDatabase.showMainframeDetails();
			}
			customer.myCart.myRemBal = customer.myCart.myTaxTotal - customer.amountPaid;			
			
			if(customer.amountPaid >= customer.myCart.myTaxTotal){
				Display.cashInsertComplete.doClick(); //This statement must be before the Display.changeDueField statement
				cashThisTransaction = cashThisTransaction + customer.getAmountPaid();
				DisplayCart.textArea1.append("Cash payment:");
				DisplayCart.textArea2.append("$" + formatter.format(cashThisTransaction));
				//Display.currencyField.setText("$" + formatter.format(Math.abs(customer.myCart.myTaxTotal - customer.getAmountPaid()))); //This is the field that shows how much cash as been inserted as you insert it -Heath
				Display.changeDueField.setText("$" + formatter.format(Math.abs(customer.myCart.myTaxTotal - customer.getAmountPaid()))); //This is the field that shows change to be returned to customer -Heath
				
				double changeDue = customer.myCart.myTaxTotal - customer.getAmountPaid();
				customer.setChangeDue(changeDue);
				//customer.paidCash(changeDue);
				Main.dailyTotalsSummary.setTotalCashReturned(changeDue);
				System.out.println("Change due:  $" + changeDue);
				//Display.currencyField.setHorizontalAlignment(JLabel.CENTER); //This is the field that shows how much cash as been inserted as you insert it -Heath
				Display.changeDueField.setHorizontalAlignment(JLabel.CENTER); //This is the field that shows change to be returned to customer -Heath
				Main.mainWindow.remainingBalanceText.setText(" ");
				Main.mainWindow.remainingBalanceText.setText("0.00");

				insertCashFrame.dispose();
				
			} else {
			amtPaidText.setText(formatter.format(customer.amountPaid));
			amtDueText.setText(formatter.format(customer.myCart.myRemBal));
			}
		}
		
	}
	
	public static CashInsertion getInstance() {
        if (myInstance == null)
            myInstance = new CashInsertion();

        return myInstance;
    }
}

