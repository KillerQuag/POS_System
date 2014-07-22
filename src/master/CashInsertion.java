package master;

import javax.swing.*;

import sun.awt.HorizBagLayout;
import master.Display.ListenForButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//This class simulates the process of inserting cash
public class CashInsertion extends JFrame{
	
	private static CashInsertion myInstance;

	public JLabel insertCashLabel;
	public JButton returnToPayMethods;
	public JFrame insertCashFrame;
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
	
	public CashInsertion(){
	
		JPanel pane = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		//GridBagLayout gridbag = new GridBagLayout(); messing around with gridbag settings ~wigmore
		//this.setLayout(gridbag);
		//For each component to be added to this container:
		//...Create the component...
		//...Set instance variables in the GridBagConstraints instance...
		
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //Use a dismissal button like "Cancel help"
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setBounds(30, 30, 300, 300); //An alternate method for setting size and location of frame
		this.setSize(425, 500); //Where this method is invoked relative to other matters
		this.setLocationRelativeTo(null); //Centers frame in the middle of the screen
		this.setResizable(false);
		this.setVisible(true);
		
		insertCashLabel = new JLabel("Please insert cash now.");//possibly add a return to payment methods option once this works
		insertCashLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
		c.weighty = 0.7;
		c.weightx = .7;
		c.anchor = GridBagConstraints.NORTH;
		c.fill = GridBagConstraints.HORIZONTAL;
		pane.add(insertCashLabel, c);
		
		this.add(pane);
		
		insertCashFrame = this;
		//button to return to payment methods (for splitting payments)
		
		
		
		//button for hundreds
		hundredButton = new JButton("$100");
		hundredButton.setFont(new Font("Ariel", Font.PLAIN, 12));
		c.anchor = GridBagConstraints.WEST;//align button to the far left
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0;
		c.gridx = 0;
		c.gridy = 0;
		pane.add(hundredButton, c);
		ListenForButton lFoHundredButton = new ListenForButton(); //Making object from within the object's class may be bad
		hundredButton.addActionListener(lFoHundredButton);
		
		//button for fiftys
		fiftyButton = new JButton("$50");
		fiftyButton.setFont(new Font("Ariel", Font.PLAIN, 12));
		c.gridx = 1;
		c.gridy = 0;
		pane.add(fiftyButton, c);
		ListenForButton lFoFiftyButton = new ListenForButton(); //Making object from within the object's class may be bad
		fiftyButton.addActionListener(lFoFiftyButton);
		
		//button for twankeys
		twentyButton = new JButton("$20");
		twentyButton.setFont(new Font("Ariel", Font.PLAIN, 12));
		c.gridx = 2; //align as close to last created button
		c.gridy = 0;
		pane.add(twentyButton, c);
		ListenForButton lFoTwentyButton = new ListenForButton(); //Making object from within the object's class may be bad
		twentyButton.addActionListener(lFoTwentyButton);
		
		//button for tens
		tenButton = new JButton("$10");
		tenButton.setFont(new Font("Ariel", Font.PLAIN, 12));
		c.gridx = 3; //align as close to last created button
		c.gridy = 0;
		pane.add(tenButton, c);
		ListenForButton lFoTenButton = new ListenForButton(); //Making object from within the object's class may be bad
		tenButton.addActionListener(lFoTenButton);
		
		//button for five-spots
		fiveButton = new JButton("$5");
		fiveButton.setFont(new Font("Ariel", Font.PLAIN, 12));
		c.gridx = 4; //align as close to last created button
		c.gridy = 0;
		pane.add(fiveButton, c);
		ListenForButton lFoFiveButton = new ListenForButton(); //Making object from within the object's class may be bad
		fiveButton.addActionListener(lFoFiveButton);
		
		//button for singles
		oneButton = new JButton("$1");
		oneButton.setFont(new Font("Ariel", Font.PLAIN, 12));
		c.gridx = 5; //align as close to last created button
		c.gridy = 0;
		pane.add(oneButton, c);
		ListenForButton lFoOneButton = new ListenForButton(); //Making object from within the object's class may be bad
		oneButton.addActionListener(lFoOneButton);
		
		returnToPayMethods = new JButton("Return to Payment Methods");
		returnToPayMethods.setFont(new Font("Ariel", Font.PLAIN, 18));
		c.anchor = GridBagConstraints.SOUTH;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weighty = 0.2;
		c.weightx = 0.7;
		c.gridx = 0;
		c.gridy = 0;
		pane.add(returnToPayMethods, c);
		returnToPayMethods.setSize(50, 50);
		ListenForButton lFoReturnToPayMethods = new ListenForButton(); //Making object from within the object's class may be bad
		returnToPayMethods.addActionListener(lFoReturnToPayMethods);
	}
	
	private class ListenForButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == returnToPayMethods) {
				insertCashFrame.dispose();
				myInstance = null;
			}
		}
	}
	
	public static CashInsertion getInstance() {
        if (myInstance == null)
            myInstance = new CashInsertion();

        return myInstance;
    }
}

/*selectPaymentLabel = new JLabel("<html>Select your payment method<html>"); //HTML can be added to JLabels to edit formatting "&#160;" adds a space
selectPaymentLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
selectPaymentLabel.setLocation(450, 50);
selectPaymentLabel.setSize(400, 150);

//cashButton
cashButton = new JButton("Cash");
cashButton.setLocation(500, 175);
cashButton.setSize(100, 75);
ListenForButton lForCashButton = new ListenForButton(); //Making object from within the object's class may be bad
cashButton.addActionListener(lForCashButton);

//checkButton
checkButton = new JButton("Check");
checkButton.setLocation(500, 175+75+10);
checkButton.setSize(100, 75);
ListenForButton lForCheckButton = new ListenForButton(); //Making object from within the object's class may be bad
checkButton.addActionListener(lForCheckButton);

//creditDebitButton
creditDebitButton = new JButton("Credit/Debit");
creditDebitButton.setLocation(500, 345);
creditDebitButton.setSize(100, 75);
ListenForButton lForCreditDebitButton = new ListenForButton(); //Making object from within the object's class may be bad
creditDebitButton.addActionListener(lForCreditDebitButton);
*/