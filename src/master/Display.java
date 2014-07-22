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
	
	
	//Declarations for all buttons and labels for customer transaction main window
	public static JButton startTransactionButton;
	
	public static JButton yesButton;
	public static JButton noButton;
	public static JButton proceedToCOButton;
	public static JButton cashButton;
	public static JButton checkButton;
	public static JButton creditDebitButton;
	public static JButton helpButton;
	
	public static JLabel welcomeLabel;
	public static JLabel couponLabel;
	public static JLabel insertCouponLabel;
	public static JLabel selectPaymentLabel;
	public static JLabel insertCashLabel;
	public static JLabel slideCardLabel;
	
	//Moved - AJV   //This will likely move to the main() function when removing the temp main() from this class
	public static JTextArea textArea1;
	public static JTextArea textArea2;
	//public static JTable textTable1;
	public static JScrollPane scrollPane1;
	public static JScrollPane scrollPane2;
	
	public static JTextField currencyField;
	
	
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
		ListenForButton lForButton = new ListenForButton();
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
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == startTransactionButton) {
				
				Main.StartTrans();
				/*mainWindow.remove(startTransaction);
				mainWindow.remove(welcomeLabel);
				
				mainWindow.getContentPane().add(couponLabel);
				mainWindow.getContentPane().add(yesButton);
				mainWindow.getContentPane().add(noButton);
				mainWindow.getContentPane().add(scrollbar1); // OLD W/O scroll bars ->   mainWindow.getContentPane().add(textArea1);
				
				mainWindow.repaint();*/
				//System.out.println(e.getSource().toString()); //For testing
				// End of if(e.getSource() == button1)
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
				
				Main.mainWindow.remove(selectPaymentLabel);
				Main.mainWindow.remove(cashButton);
				Main.mainWindow.remove(checkButton);
				Main.mainWindow.remove(creditDebitButton);
				
				Main.mainWindow.getContentPane().add(insertCashLabel);
				Main.mainWindow.getContentPane().add(currencyField);
				
				Main.mainWindow.repaint();
				
			} else if(e.getSource() == checkButton) {
				
				////////////////////////////////////////////////////////////////////////////
				//TODO We will need another window to pop up separately for cash insertion
				//CheckInsertion checkInsertionWindow = new CheckInsertion(); //Works, but not used so commented out because I don't like warnings
				////////////////////////////////////////////////////////////////////////////
				
				insertCashLabel = new JLabel("<html>Please insert check now<html>");
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
				
				Main.mainWindow.remove(selectPaymentLabel);
				Main.mainWindow.remove(cashButton);
				Main.mainWindow.remove(checkButton);
				Main.mainWindow.remove(creditDebitButton);
				
				Main.mainWindow.getContentPane().add(insertCashLabel);
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
				
				Main.mainWindow.remove(selectPaymentLabel);
				Main.mainWindow.remove(cashButton);
				Main.mainWindow.remove(checkButton);
				Main.mainWindow.remove(creditDebitButton);
				
				Main.mainWindow.getContentPane().add(slideCardLabel);
				
				Main.mainWindow.repaint();
			}
		}// End of actionPerformed(ActionEvent e)
	}// End of class ListenForButton
}
