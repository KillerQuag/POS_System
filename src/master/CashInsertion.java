package master;

import javax.swing.*;

//import sun.awt.HorizBagLayout;
import master.Display.ListenForButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//This class simulates the process of inserting cash
public class CashInsertion extends Display{
	
	private static final long serialVersionUID = 1L;

	private static CashInsertion myInstance;

	public JLabel insertCashLabel;
	public JButton returnToPayMethods;
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
		
		//this.removeAll();  Pristine whiteness delivered.		

		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //Use a dismissal button like "Cancel help"
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setBounds(30, 30, 300, 300); //An alternate method for setting size and location of frame
		this.setSize(800, 600); //Where this method is invoked relative to other matters
		this.setLocationRelativeTo(null); //Centers frame in the middle of the screen
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
		hundredButton = new JButton("$100");
		hundredButton.setFont(new Font("Ariel", Font.PLAIN, 12));
		hundredButton.setLocation(120, 100);
		hundredButton.setSize(75, 75);
		insertCashFrame.getContentPane().add(hundredButton);
		ListenForButton lFoHundredButton = new ListenForButton();
		hundredButton.addActionListener(lFoHundredButton);
		
		//button for fiftys
		fiftyButton = new JButton("$50");
		fiftyButton.setFont(new Font("Ariel", Font.PLAIN, 12));
		fiftyButton.setLocation(120 + 100, 100);
		fiftyButton.setSize(75, 75);
		insertCashFrame.getContentPane().add(fiftyButton);
		ListenForButton lFoFiftyButton = new ListenForButton(); //Making object from within the object's class may be bad
		fiftyButton.addActionListener(lFoFiftyButton);
		
		//button for twankeys
		twentyButton = new JButton("$20");
		twentyButton.setFont(new Font("Ariel", Font.PLAIN, 12));
		twentyButton.setLocation(120 + 200, 100);
		twentyButton.setSize(75, 75);
		insertCashFrame.getContentPane().add(twentyButton);
		ListenForButton lFoTwentyButton = new ListenForButton(); //Making object from within the object's class may be bad
		twentyButton.addActionListener(lFoTwentyButton);
		
		//button for tens
		tenButton = new JButton("$10");
		tenButton.setFont(new Font("Ariel", Font.PLAIN, 12));
		tenButton.setLocation(120 + 300, 100);
		tenButton.setSize(75, 75);
		insertCashFrame.getContentPane().add(tenButton);
		ListenForButton lFoTenButton = new ListenForButton(); //Making object from within the object's class may be bad
		tenButton.addActionListener(lFoTenButton);
		
		//button for five-spots
		fiveButton = new JButton("$5");
		fiveButton.setFont(new Font("Ariel", Font.PLAIN, 12));
		fiveButton.setLocation(120 + 400, 100);
		fiveButton.setSize(75, 75);
		insertCashFrame.getContentPane().add(fiveButton);
		ListenForButton lFoFiveButton = new ListenForButton(); //Making object from within the object's class may be bad
		fiveButton.addActionListener(lFoFiveButton);
		
		//button for singles
		oneButton = new JButton("$1");
		oneButton.setFont(new Font("Ariel", Font.PLAIN, 12));
		oneButton.setLocation(120 + 500, 100);
		oneButton.setSize(75, 75);
		insertCashFrame.getContentPane().add(oneButton);
		ListenForButton lFoOneButton = new ListenForButton(); //Making object from within the object's class may be bad
		oneButton.addActionListener(lFoOneButton);
		
		//button for quarters
		quarterButton = new JButton("0.25");
		quarterButton.setFont(new Font("Ariel", Font.PLAIN, 12));
		quarterButton.setLocation(220, 225);
		quarterButton.setSize(75, 75);
		insertCashFrame.getContentPane().add(quarterButton);
		ListenForButton lFoQuarterButton = new ListenForButton(); //Making object from within the object's class may be bad
		quarterButton.addActionListener(lFoQuarterButton);
		
		//button for dimes
		dimeButton = new JButton("0.10");
		dimeButton.setFont(new Font("Ariel", Font.PLAIN, 12));
		dimeButton.setLocation(220 + 100, 225);
		dimeButton.setSize(75, 75);
		insertCashFrame.getContentPane().add(dimeButton);
		ListenForButton lFoDimeButton = new ListenForButton(); //Making object from within the object's class may be bad
		dimeButton.addActionListener(lFoDimeButton);
		
		//button for nickels
		nickelButton = new JButton("0.05");
		nickelButton.setFont(new Font("Ariel", Font.PLAIN, 12));
		nickelButton.setLocation(220 + 200, 225);
		nickelButton.setSize(75, 75);
		insertCashFrame.getContentPane().add(nickelButton);
		ListenForButton lFoNickelButton = new ListenForButton(); //Making object from within the object's class may be bad
		nickelButton.addActionListener(lFoNickelButton);
		
		//button for pennies
		pennyButton = new JButton("0.01");
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
		
		Customer thisOne = (Customer)Main.Customers.get(Main.currentCustNum);
		//double leftToPay = Cart.myTaxTotal - Customer.amountPaid;
		
		this.remove(welcomeLabel);
		this.remove(startTransactionButton);
		
		double printAmt = Customer.getAmountPaid();
		amtPaidText = new JTextField("$" + Double.toString(printAmt ), 15);
		

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
		
		
		amtDueText = new JTextField("$" + Double.toString(Cart.myTaxTotal), 15);
		
		amtDueText.setToolTipText("Balance Remaining"); // Change the tool tip for the text field
		amtDueText.setHorizontalAlignment(JLabel.CENTER);
		amtDueText.setLocation(300, 450);
		amtDueText.setSize(200, 25);
		//currencyField.setEditable(false);
		insertCashFrame.getContentPane().add(amtDueText);
	
	}

	private class ListenForButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Customer customer = (Customer)Main.Customers.get(Main.currentCustNum);
			String totalAmountPaid = Double.toString(customer.getAmountPaid());
			if(e.getSource() == returnToPayMethods) {
				insertCashFrame.dispose();
				myInstance = null;
			}
			else if(e.getSource() == hundredButton) {
				
				customer.setAmountPaid(100.00);
				System.out.println( customer.getAmountPaid() );	
			}
			else if(e.getSource() == fiftyButton) {
				customer.setAmountPaid(50.00);
				
			}
			else if(e.getSource() == twentyButton) {
				customer.setAmountPaid(20.00);
				
			}
			else if(e.getSource() == tenButton) {
				customer.setAmountPaid(10.00);
				
			}
			else if(e.getSource() == fiveButton) {
				customer.setAmountPaid(5.00);
				
			}
			else if(e.getSource() == oneButton) {
				customer.setAmountPaid(1.00);
				
			}
			else if(e.getSource() == quarterButton) {
				customer.setAmountPaid(0.25);
				
			}
			else if(e.getSource() == dimeButton) {
				customer.setAmountPaid(00.10);
				
			}
			else if(e.getSource() == nickelButton) {
				customer.setAmountPaid(00.05);
				
			}
			else if(e.getSource() == pennyButton) {
				customer.setAmountPaid(0.01);
				
			}
			customer.myCart.myRemBal = customer.myCart.myTaxTotal - customer.amountPaid;
			amtPaidText.setText(Double.toString(customer.amountPaid));
			amtDueText.setText(Double.toString(Calculations.round(Cart.myRemBal, 2)));
		}
	}
	
	public static CashInsertion getInstance() {
        if (myInstance == null)
            myInstance = new CashInsertion();

        return myInstance;
    }
}

