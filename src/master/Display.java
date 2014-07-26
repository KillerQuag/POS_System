package master;

//import javax.swing.JFrame;
import javax.swing.*;

//import java.awt.Dimension;
//import java.awt.Toolkit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	
	///TEMPORARY//
	public static JButton cashInsertComplete;
	public static JButton checkInsertComplete;
	/////////////
	
	public static JLabel welcomeLabel;
	public static JLabel couponLabel;
	public static JLabel insertCouponLabel;
	public static JLabel selectPaymentLabel;
	public static JLabel insertCashLabel;
	public static JLabel slideCardLabel;
	public static JLabel changeDueLabel;
	public static JLabel insertCheckLabel;
	public static JLabel checkCompleteLabel;
	public static JLabel debitLabel;
	public static JLabel creditLabel;
	public static JLabel giftLabel;
	
	//Moved - AJV   //This will likely move to the main() function when removing the temp main() from this class
	public static JTextArea textArea1;
	public static JTextArea textArea2;
	//public static JTable textTable1;
	public static JScrollPane scrollPane1;
	public static JScrollPane scrollPane2;
	
	public static JTextField currencyField;
	public static JTextField changeDueField;
	public static JTextField signatureField;
	
	public static JPasswordField passwordField;
	
	
	/*public static void main(String[] a) { 	//Will want to remove this main() and 
				// put this constructor in the real main()
	}*/
	
	
	public Display() { 
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setBounds(30, 30, 300, 300); //An alternate method for setting size and location of frame
		this.setSize(800, 600); //Where this method is invoked relative to other matters
		this.setLocationRelativeTo(null); //Centers frame in the middle of the screen
		this.setResizable(false);
		this.setVisible(true);
		
		
		
		
		/*//This group is an alternate method to center frame in middle of screen
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width / 2) - (this.getWidth() / 2);
		int yPos = (dim.height / 2) - (this.getHeight() / 2);
		this.setLocation(xPos, yPos);
		*/

		
		//JPanel thePanel = new JPanel();
		welcomeLabel = new JLabel("Welcome!");
		welcomeLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
		welcomeLabel.setLocation(365, 150);
		welcomeLabel.setSize(150, 50);
		
		//setComponentZOrder(label1, 5); //An attempt to make the graphics go to background --- Deletion fodder 
		this.getContentPane().add(welcomeLabel);
		
		this.getContentPane().setLayout(null); //Setting Layout to null allows coordinate placement //Can't get backDrop to appear if layout is set to null
		
		startTransactionButton = new JButton("Start Transaction");
		startTransactionButton.setLocation(400-100, 225);
		startTransactionButton.setSize(200, 75);
		this.getContentPane().add(startTransactionButton);
		//ListenForButton lForButton = new ListenForButton();
		lForButton = new ListenForButton();
		startTransactionButton.addActionListener(lForButton);
		
		
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
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == startTransactionButton) {
				
				Main.StartTrans();
				/*mainWindow.remove(startTransaction);
				mainWindow.remove(welcomeLabel);
				
				mainWindow.getContentPane().add(couponLabel);
				mainWindow.getContentPane().add(yesButton);
				mainWindow.getContentPane().add(noButton);
				mainWindow.getContentPane().add(scrollbar1); // OLD W/O scroll bars ->   mainWindow.getContentPane().add(textArea1);
				
				mainWindow.repaint();
				*/
				//System.out.println(e.getSource().toString()); //For testing
			} else if(e.getSource() == helpButton) {
				
				//HelpWindow helpWindow = new HelpWindow();
				
				HelpWindow.getInstance();
				
			} else if(e.getSource() == yesButton) {
				
				////////////////////////////////////////////////////////////////////////////
				//TODO We will need another window to pop up separately for coupon insertion
				//CouponInsertion couponInsertionWindow = new CouponInsertion(); //Works, but not used so commented out because I don't like warnings
				////////////////////////////////////////////////////////////////////////////
				
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
				
				Main.mainWindow.getContentPane().add(insertCouponLabel);
				Main.mainWindow.getContentPane().add(proceedToCOButton);
				
				Main.mainWindow.repaint();
				
			} else if(e.getSource() == noButton || e.getSource() == proceedToCOButton) {
				
				//Clears proper labels and buttons
				if(e.getSource() == noButton) {				
					Main.mainWindow.remove(yesButton);
					Main.mainWindow.remove(noButton);
					Main.mainWindow.remove(couponLabel);
				} else if(e.getSource() == proceedToCOButton) {					
					Main.mainWindow.remove(insertCouponLabel);
					Main.mainWindow.remove(proceedToCOButton);
				}
				
				
				selectPaymentLabel = new JLabel("<html>Select your payment method<html>"); //HTML can be added to JLabels to edit formatting "&#160;" adds a space
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
				
				
				currencyField = new JTextField("$0.0", 15);
				//currencyField.setColumns(10); // Change the size of the text field
				//currencyField.setText("New Text Here"); // Change the initial value of the text field
				currencyField.setToolTipText("Amount paid"); // Change the tool tip for the text field
				currencyField.setLocation(450, 200);
				currencyField.setSize(200, 25);
				//currencyField.setEditable(false);
				
				//From account manager program - We may be able to use this to update the currencyFields 
				//balanceField.setText(Double.toString(me.getBalance()));
				//Otherwise may want to create a eventListener like in the midterm review
				
				/////////TEMPORARY CODE/////////
				//++++++++++++++++++++++++++++++
				cashInsertComplete = new JButton("SEND PAID EVENT");
				cashInsertComplete.setLocation(450, 175+75+10);
				cashInsertComplete.setSize(200, 75);
				ListenForButton lForCashInsertCompleteButton = new ListenForButton(); //Making object from within the object's class may be bad
				cashInsertComplete.addActionListener(lForCashInsertCompleteButton);
				Main.mainWindow.getContentPane().add(cashInsertComplete);
				//++++++++++++++++++++++++++++++
				//////END OF TEMPORARY CODE/////
				
				
				
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
				
				slideCardLabel = new JLabel("<html>Please slide your card<br> through the card reader<br> and follow the instructions<html>");
				slideCardLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
				slideCardLabel.setLocation(450, 50);
				slideCardLabel.setSize(400, 150);
				
				////////////////////////////////////////////////////////////////////////////
				//TODO We will need another window to pop up separately for simulating swiping a card 
				//CardSwipe cardSwipeWindow = new CardSwipe(); //Works, but not used so commented out because I don't like warnings
				////////////////////////////////////////////////////////////////////////////
				CardSwipe cardSwipeWindow = new CardSwipe();
				cardSwipeWindow.beginCardSwipe();						
				
				
				Main.mainWindow.remove(selectPaymentLabel);
				Main.mainWindow.remove(cashButton);
				Main.mainWindow.remove(checkButton);
				Main.mainWindow.remove(creditDebitButton);
				
				Main.mainWindow.getContentPane().add(slideCardLabel);
				
				Main.mainWindow.repaint();
				
			} else if(e.getSource() == cashInsertComplete) {
				
				changeDueLabel = new JLabel("<html>&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;Change due<html>");
				changeDueLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
				changeDueLabel.setLocation(450, 50);
				changeDueLabel.setSize(400, 150);
				
				changeDueField = new JTextField("$0.0", 15);
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
				
			} else if(e.getSource() == checkInsertComplete) {
				
				checkCompleteLabel = new JLabel("<html>&#160;&#160;&#160;&#160;Transaction completed. <br> Thank you for your business!<html>");
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
				
				debitLabel = new JLabel("<html>Please enter your pin number <br>"
											+ " &#160;&#160;&#160; followed by the enter key<html>");
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
				
				creditLabel = new JLabel("<html>Please provide signature <br> &#160;&#160;&#160;&#160;&#160;&#160;&#160; for transaction <html>");
				creditLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
				creditLabel.setLocation(450, 50);
				creditLabel.setSize(400, 150);
				
				
				signatureField = new JTextField("Write your signature here", 15);
				//currencyField.setColumns(10); // Change the size of the text field
				//currencyField.setText("New Text Here"); // Change the initial value of the text field
				signatureField.setToolTipText("Use your finger or the stylus"); // Change the tool tip for the text field
				signatureField.setLocation(450, 200);
				signatureField.setSize(200, 40);
				
				
				
				enterButton1 = new JButton("Enter");
				enterButton1.setLocation(450, 300);
				enterButton1.setSize(75, 50);
				
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
				
			} else if(e.getSource() == CardSwipe.giftButton) { //From CardSwipe class
				
				//If ( giftCardAmt >= totalCost ) == true
				giftLabel = new JLabel("<html>Transaction completed. <br> The remaining balance <br> on your gift card is: <html>");
				giftLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
				giftLabel.setLocation(450, 50);
				giftLabel.setSize(400, 150);
				
				Main.mainWindow.getContentPane().add(giftLabel);
				Main.mainWindow.remove(slideCardLabel);
				
				Main.mainWindow.repaint();
				
				System.out.println("Gift button pressed");
				
			} else if(e.getSource() == enterButton1) { //For credit
				
				//Submit data from field
				
			} else if(e.getSource() == clearButton1) {
				
				signatureField.setText(" ");
				
			}  else if(e.getSource() == enterButton2) { //For debit
				
				//Submit data from field
				String password;
				password = passwordField.getText();
				//password[password.length()];
				String[] strArray = new String[] {password};
				System.out.println(strArray[0]);
				
				/*
				String strName = "name";
				String[] strArray = new String[] {strName};
				System.out.println(strArray[0]); //prints "name"   
				 */
				
				
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
		}// End of actionPerformed(ActionEvent e)
	}// End of class ListenForButton
	
	
} //End of Display class
