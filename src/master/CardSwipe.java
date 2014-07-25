package master;

import javax.swing.*;

//import master.Display.ListenForButton;

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
	
	public static JLabel chooseACardLabel;
	
	public static JTextField CardSwipeField;

	Point windowLocation;
	
	public void beginCardSwipe()
	{
	
	//this.setLocationRelativeTo();
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//this.setBounds(30, 30, 300, 300); //An alternate method for setting size and location of frame
	this.setSize(800, 600); //Where this method is invoked relative to other matters
	this.setLocationRelativeTo(null); //Centers frame in the middle of the screen
	this.setResizable(false);
	this.setVisible(true);
	
	//debitButton
	debitButton = new JButton("Debit");
	debitButton.setLocation(200, 175);
	debitButton.setSize(100, 75);
	ListenForButton lForDebitButton = new ListenForButton(); //Making object from within the object's class may be bad
	debitButton.addActionListener(lForDebitButton);
	this.getContentPane().add(debitButton);
	
	//creditButton
	creditButton = new JButton("Credit");
	creditButton.setLocation(320, 175);
	creditButton.setSize(100, 75);
	ListenForButton lForCreditButton = new ListenForButton(); //Making object from within the object's class may be bad
	creditButton.addActionListener(lForCreditButton);
	this.getContentPane().add(creditButton);
	
	
	//giftButton
	giftButton = new JButton("Gift");
	giftButton.setLocation(440, 175);
	giftButton.setSize(100, 75);
	ListenForButton lForGiftButton = new ListenForButton(); //Making object from within the object's class may be bad
	giftButton.addActionListener(lForGiftButton);
	this.getContentPane().add(giftButton);
	
	
	//Return to Payment Method
	returnButton = new JButton("Return to Payment Method");
	returnButton.setLocation(225, 380);
	returnButton.setSize(300, 75);
	Color returnBackgroundButton = Color.yellow;
	returnButton.setBackground(returnBackgroundButton );
	ListenForButton lForreturnButton = new ListenForButton(); //Making object from within the object's class may be bad
	returnButton.addActionListener(lForreturnButton);
	this.getContentPane().add(returnButton);
	
	
	chooseACardLabel = new JLabel("<html>Please select the type of card you are using.<html>");
	chooseACardLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
	chooseACardLabel.setLocation(200, 50);
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
			}
			else if(e.getSource() == creditButton )
			{
				//full payment be made with card? 
				Main.mainWindow.lForButton.actionPerformed(e);
			}
			else if(e.getSource() == giftButton )
			{
				//full payment to be made with gift card?
				Main.mainWindow.lForButton.actionPerformed(e);
			}
			else if(e.getSource() == returnButton )
			{
				
			}
		}
	}	
}
	
	

