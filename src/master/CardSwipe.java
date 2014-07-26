package master;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//This class simulates the process of swiping a card (Debit, Credit or Gift)
public class CardSwipe extends JFrame 
{
	private static final long serialVersionUID = 1L; //Ignore
	
	public static JButton debitButton;
	public static JButton creditButton;
	public static JButton giftButton;
	public static JButton returnButton;
	public static JButton enterButton;
	
	//Gift card buttons
	public static JButton fiveDollar;
	public static JButton tenDollar;
	public static JButton twentyFiveDollar;
	public static JButton fiftyDollar;
	public static JButton cancelButton;
	
	public static JLabel chooseACardLabel;
	public static JLabel couponLabel;
	public static JLabel giftCardAmountLabel;
	//public static JLabel processingLabel;
	
	public static JTextField CardSwipeField;

	Point windowLocation;	
	
	static CardSwipe cardSwipeWindow;
	
	
	public void beginCardSwipe()
	{
	
	cardSwipeWindow = this;
	//this.setLocationRelativeTo();
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	//this.setBounds(30, 30, 300, 300); //An alternate method for setting size and location of frame
	this.setSize(550, 450); //Where this method is invoked relative to other matters
	//this.setLocationRelativeTo(null); //Centers frame in the middle of the screen
	this.setResizable(false);
	this.setVisible(true);
	this.setLocation(0, 0);
	
	//debitButton
	debitButton = new JButton("Debit");
	debitButton.setLocation(95, 160);
	debitButton.setSize(100, 75);
	ListenForButton lForDebitButton = new ListenForButton(); //Making object from within the object's class may be bad
	debitButton.addActionListener(lForDebitButton);
	this.getContentPane().add(debitButton);
	
	//creditButton
	creditButton = new JButton("Credit");
	creditButton.setLocation(210, 160);
	creditButton.setSize(100, 75);
	ListenForButton lForCreditButton = new ListenForButton(); //Making object from within the object's class may be bad
	creditButton.addActionListener(lForCreditButton);
	this.getContentPane().add(creditButton);
	
	
	//giftButton
	giftButton = new JButton("Gift");
	giftButton.setLocation(330, 160);
	giftButton.setSize(100, 75);
	ListenForButton lForGiftButton = new ListenForButton(); //Making object from within the object's class may be bad
	giftButton.addActionListener(lForGiftButton);
	this.getContentPane().add(giftButton);
	
	
	//Return to Payment Method
	returnButton = new JButton("Return to Payment Method");
	returnButton.setLocation(115, 280);
	returnButton.setSize(300, 75);
	Color returnBackgroundButton = Color.yellow;
	returnButton.setBackground(returnBackgroundButton );
	ListenForButton lForreturnButton = new ListenForButton(); //Making object from within the object's class may be bad
	returnButton.addActionListener(lForreturnButton);
	this.getContentPane().add(returnButton);
	
	
	chooseACardLabel = new JLabel("<html>Please select the type of card you are using.<html>");
	chooseACardLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
	chooseACardLabel.setLocation(90, 50);
	chooseACardLabel.setSize(400, 100);
	this.getContentPane().add(chooseACardLabel);
	
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
				
			}
			else if(e.getSource() == creditButton )
			{
				//full payment be made with card? 
				Main.mainWindow.lForButton.actionPerformed(e);				
				cardSwipeWindow.dispose();
			}
			else if(e.getSource() == giftButton )
			{
				//full payment to be made with gift card?
				Main.mainWindow.lForButton.actionPerformed(e);				
				//cardSwipeWindow.dispose();
				//cardSwipeWindow.remove(CardSwipeField);
				cardSwipeWindow.remove(creditButton);
				cardSwipeWindow.remove(debitButton);
				cardSwipeWindow.remove(giftButton);
				cardSwipeWindow.remove(returnButton);
				cardSwipeWindow.remove(chooseACardLabel);
				cardSwipeWindow.repaint();	
				
				fiveDollar = new JButton("$5");
				fiveDollar.setLocation(40, 170);
				fiveDollar.setSize(100, 75);
				ListenForButton lForFiveDollar = new ListenForButton(); //Making object from within the object's class may be bad
				fiveDollar.addActionListener(lForFiveDollar);
				cardSwipeWindow.getContentPane().add(fiveDollar);	
				
				tenDollar = new JButton("$10");
				tenDollar.setLocation(160, 170);
				tenDollar.setSize(100, 75);
				ListenForButton lFortenDollar = new ListenForButton(); //Making object from within the object's class may be bad
				tenDollar.addActionListener(lFortenDollar);
				cardSwipeWindow.getContentPane().add(tenDollar);					
				
				twentyFiveDollar = new JButton("$25");
				twentyFiveDollar.setLocation(280, 170);
				twentyFiveDollar.setSize(100, 75);
				ListenForButton lFortwentyFiveDollar = new ListenForButton(); //Making object from within the object's class may be bad
				twentyFiveDollar.addActionListener(lFortwentyFiveDollar);
				cardSwipeWindow.getContentPane().add(twentyFiveDollar);	
				
				fiftyDollar = new JButton("$50");
				fiftyDollar.setLocation(400, 170);
				fiftyDollar.setSize(100, 75);
				ListenForButton lForfiftyDollar = new ListenForButton(); //Making object from within the object's class may be bad
				fiftyDollar.addActionListener(lForfiftyDollar);
				cardSwipeWindow.getContentPane().add(fiftyDollar);	
				
				cancelButton = new JButton("Cancel");
				cancelButton.setLocation(200, 270);
				cancelButton.setSize(150, 75);
				Color cancelBackgroundColor = Color.yellow;
				cancelButton.setBackground(cancelBackgroundColor);
				ListenForButton lForcancelButton = new ListenForButton(); //Making object from within the object's class may be bad
				cancelButton.addActionListener(lForcancelButton);
				cardSwipeWindow.getContentPane().add(cancelButton);
				
				giftCardAmountLabel = new JLabel("<html>Gift Card<html>");
				giftCardAmountLabel.setFont(new Font("Ariel", Font.PLAIN, 20));
				giftCardAmountLabel.setLocation(230, 70);
				giftCardAmountLabel.setSize(200, 100);
				cardSwipeWindow.getContentPane().add(giftCardAmountLabel);		
				
			}	
			if(e.getSource() == fiveDollar )
			{				
				cardSwipeWindow.dispose();
			}
			else if( e.getSource() == tenDollar )
			{
				cardSwipeWindow.dispose();
			}
			else if( e.getSource() == twentyFiveDollar )
			{
				cardSwipeWindow.dispose();
			}
			else if( e.getSource() == fiftyDollar )
			{
				cardSwipeWindow.dispose();
			}
			else if( e.getSource() == cancelButton )
			{
				cardSwipeWindow.dispose();
			}
			
			else if(e.getSource() == returnButton )
			{
				Main.mainWindow.lForButton.actionPerformed(e);
				cardSwipeWindow.dispose();
				
				
			}
		}
	}		

}
	
	

