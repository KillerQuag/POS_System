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
	public JButton startTransaction;
	
	public JButton yesButton;
	public JButton noButton;
	public JButton proceedToCOButton;
	public JButton cashButton;
	public JButton checkButton;
	public JButton creditDebitButton;
	
	public JLabel welcomeLabel;
	public JLabel couponLabel;
	public JLabel insertCouponLabel;
	public JLabel selectPaymentLabel;
	
	static Display mainWindow; //This will likely move to the main() function when removing the temp main() from this class
	public JTextArea textArea1;
	public JScrollPane scrollbar1;
	
	
	public static void main(String[] a) { 	//Will want to remove this main() and 
		mainWindow = new Display();			// put this constructor in the real main()
	}
	
	
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
		
		startTransaction = new JButton("Start Transaction");
		startTransaction.setLocation(400-100, 225);
		startTransaction.setSize(200, 75);
		this.getContentPane().add(startTransaction);
		ListenForButton lForButton = new ListenForButton();
		startTransaction.addActionListener(lForButton);
		
			
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
	private class ListenForButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == startTransaction) {
				
				//WILL USE A GETTER TO LOAD THE TRANSACTION WINDOW (SET EQUAL TO BELOW VARIABLE)
				String transactionText = " Tequila     $9.99\n Benadryl    $12.98";
				//******************************************************************************
				
				//Text area stuff
				textArea1 = new JTextArea(15, 20); // Set the default text for the text area
				textArea1.setText(transactionText); // If text doesn't fit on a line, jump to the next
				textArea1.setLineWrap(true); // Makes sure that words stay intact if a line wrap occurs
				textArea1.setWrapStyleWord(true); 
				textArea1.setLocation(100, 100); 
				textArea1.setSize(275, 105);
				textArea1.setEditable(false); //Prevents the user from being able to change the text area's data
				
				//Test text data
				textArea1.append("\n TMNT Action figure   $8.99");
				textArea1.append("\n TMNT Action figure   $8.99");
				textArea1.append("\n TMNT Action figure   $8.99");
				textArea1.append("\n TMNT Action figure   $8.99");
				textArea1.append("\n TMNT Action figure   $8.99");
				textArea1.append("\n TMNT Action figure   $8.99");
				//End of test text data
				
				scrollbar1 = new JScrollPane(textArea1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollbar1.setLocation(100, 100); 
				scrollbar1.setSize(275, 375);
				
				
				couponLabel = new JLabel("Do you have any coupons?");
				couponLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
				couponLabel.setLocation(410, 50);
				couponLabel.setSize(400, 150);
				
				yesButton = new JButton("Yes");
				yesButton.setLocation(410, 225);
				yesButton.setSize(100, 50);
				ListenForButton lForYesButton = new ListenForButton(); //Making object from within the object's class may be bad
				yesButton.addActionListener(lForYesButton);
				
				noButton = new JButton("No");
				noButton.setLocation(520, 225);
				noButton.setSize(100, 50);
				ListenForButton lForNoButton = new ListenForButton(); //Making object from within the object's class may be bad
				noButton.addActionListener(lForNoButton);
				
				
				mainWindow.remove(startTransaction);
				mainWindow.remove(welcomeLabel);
				
				mainWindow.getContentPane().add(couponLabel);
				mainWindow.getContentPane().add(yesButton);
				mainWindow.getContentPane().add(noButton);
				mainWindow.getContentPane().add(scrollbar1); // OLD W/O scroll bars ->   mainWindow.getContentPane().add(textArea1);
				
				mainWindow.repaint();
				
				//System.out.println(e.getSource().toString()); //For testing
				// End of if(e.getSource() == button1)
			} else if(e.getSource() == yesButton) {
				
				//textArea1.append("\n YES WAS PUSHED"); //For testing
				//System.out.println("YES WAS PUSHED"); //For testing
				
				
				
				//TODO We will need another window to pop up separately for coupon insertion
				//The constructor for that window would go here
				
				
				
				insertCouponLabel = new JLabel("<html>Please insert all coupons<br>&#160;&#160;&#160;&#160;&#160;&#160;&#160;into the reader<html>"); //HTML can be added to JLabels to edit formatting "&#160;" adds a space
				insertCouponLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
				insertCouponLabel.setLocation(450, 50);
				insertCouponLabel.setSize(400, 150);
				
				
				proceedToCOButton = new JButton("Proceed to checkout");
				proceedToCOButton.setLocation(450, 225);
				proceedToCOButton.setSize(200, 100);
				ListenForButton lForYesButton = new ListenForButton(); //Making object from within the object's class may be bad
				proceedToCOButton.addActionListener(lForYesButton);
				
				
				mainWindow.remove(yesButton);
				mainWindow.remove(noButton);
				mainWindow.remove(couponLabel);
				
				mainWindow.getContentPane().add(insertCouponLabel);
				mainWindow.getContentPane().add(proceedToCOButton);
				
				mainWindow.repaint();
				
			} else if(e.getSource() == noButton || e.getSource() == proceedToCOButton) {
				
				//Clears proper labels and buttons
				if(e.getSource() == noButton) {
					textArea1.append("\n NO WAS PUSHED"); //For testing
					System.out.println("NO WAS PUSHED"); //For testing
				
					mainWindow.remove(yesButton);
					mainWindow.remove(noButton);
					mainWindow.remove(couponLabel);
				} else if(e.getSource() == proceedToCOButton) {
					textArea1.append("\n proceedToCOButton WAS PUSHED"); //For testing
					System.out.println("proceedToCOButton WAS PUSHED"); //For testing
					
					mainWindow.remove(insertCouponLabel);
					mainWindow.remove(proceedToCOButton);
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
				mainWindow.getContentPane().add(selectPaymentLabel);
				
				mainWindow.getContentPane().add(cashButton);
				mainWindow.getContentPane().add(checkButton);
				mainWindow.getContentPane().add(creditDebitButton);
				
				mainWindow.repaint();
				
			} else if(e.getSource() == cashButton) {
				
			} else if(e.getSource() == checkButton) {
				
			} else if(e.getSource() == creditDebitButton) {
				
			}
		}// End of actionPerformed(ActionEvent e)
	}// End of class ListenForButton
}
