package master;

import javax.swing.*;

//import sun.awt.HorizBagLayout;
import master.Display.ListenForButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//This class simulates the process of inserting cash
public class CashInsertion extends JFrame{
	
	private static final long serialVersionUID = 1L;

	private static CashInsertion myInstance;

	public JLabel insertCashLabel;
	public JButton returnToPayMethods;
	public JFrame insertCashFrame;
	public static JLabel remainingBalance;
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
	
	public static JTextField currencyField;
	
	public CashInsertion(){
	
		Cart cartCopy = new Cart();
		CartStorage cs = new CartStorage();
		cartCopy = cs.getCart();
		/*for (int i = 0; i < cartCopy.getNumItemsInCart(); i++){
			System.out.format("%-20s",(i+1) + ". " + cartCopy.items[i].getItemName());
			System.out.format("%15s", cartCopy.items[i].getPrice() + "\n");
			
		}*/
		boolean hasItems = cartCopy.hasItems();
		if(hasItems)
			System.out.printf("Has items.");
		else
			System.out.printf("NO ITEMS.");
				
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
		
		//String balRem = Double.toString(Calculations.getTotalPrice(cartCopy));
		//currencyField = new JTextField(balRem);
		currencyField = new JTextField("$0.00", 15);

		//currencyField.setColumns(10); // Change the size of the text field
		//currencyField.setText("New Text Here"); // Change the initial value of the text field
		currencyField.setToolTipText("Amount paid"); // Change the tool tip for the text field
		currencyField.setHorizontalAlignment(JLabel.CENTER);
		currencyField.setLocation(315, 400);
		currencyField.setSize(200, 25);
		//currencyField.setEditable(false);
		insertCashFrame.getContentPane().add(currencyField);
		
		remainingBalance = new JLabel("<html>Remaining Balance:<html>");
		remainingBalance.setFont(new Font("Ariel", Font.PLAIN, 12));
		remainingBalance.setLocation(355, 325);
		remainingBalance.setSize(400,100);
		this.getContentPane().add(remainingBalance);
	}

	private class ListenForButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == returnToPayMethods) {
				insertCashFrame.dispose();
				myInstance = null;
			}
			else if(e.getSource() == hundredButton) {
				currencyField.setText("$100.00");
				
			}
			else if(e.getSource() == fiftyButton) {
				//send amount to calculations
				
			}
			else if(e.getSource() == twentyButton) {
				//send amount to calculations
				
			}
			else if(e.getSource() == tenButton) {
				//send amount to calculations
				
			}
			else if(e.getSource() == fiveButton) {
				//send amount to calculations
				
			}
			else if(e.getSource() == oneButton) {
				//send amount to calculations
				
			}
			else if(e.getSource() == quarterButton) {
				//send amount to calculations
				
			}
			else if(e.getSource() == dimeButton) {
				//send amount to calculations
				
			}
			else if(e.getSource() == nickelButton) {
				//send amount to calculations
				
			}
			else if(e.getSource() == pennyButton) {
				//send amount to calculations
				
			}
		}
	}
	
	public static CashInsertion getInstance() {
        if (myInstance == null)
            myInstance = new CashInsertion();

        return myInstance;
    }
}

