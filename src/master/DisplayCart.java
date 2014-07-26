package master;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
//import javax.swing.JTable;
import javax.swing.JTextArea;

//import master.Display.ListenForButton;

public class DisplayCart extends Display {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static void display(Cart cart) {
		
		Customer customer = (Customer)Main.Customers.get(Main.currentCustNum);
		//WILL USE A GETTER TO LOAD THE TRANSACTION WINDOW (SET EQUAL TO BELOW VARIABLE)
		//******************************************************************************
	
		//Text area stuff
		textArea1 = new JTextArea(15, 20); // Set the default text for the text area
		textArea1.setText("         Items"); // If text doesn't fit on a line, jump to the next
		textArea1.setLineWrap(true); // Makes sure that words stay intact if a line wrap occurs
		textArea1.setWrapStyleWord(true); 
		//textArea1.setLocation(100, 100); 
		textArea1.setSize(275, 105);
		textArea1.setEditable(false); //Prevents the user from being able to change the text area's data
		
		textArea1.append("\n         --------\n");
		for (int i = 0; i < cart.getNumItemsInCart(); i++){
			textArea1.append(Integer.toString(i+1) + ". " + cart.items[i].getItemName());
			textArea1.append("\n ");
			//textArea1.append(cart.items[i].getItemName());
		}		
		textArea1.append("---------------------------------\n");
		textArea1.append("Sales Tax:" + "\n");
		textArea1.append("Total Price: " + "\n");
		
		textArea2 = new JTextArea(15, 20); // Set the default text for the text area
		textArea2.setText("   Price"); // If text doesn't fit on a line, jump to the next
		/*textArea2.setLineWrap(true); // Makes sure that words stay intact if a line wrap occurs
		textArea2.setWrapStyleWord(true); */
		//textArea2.setLocation(100, 100); 
		textArea2.setSize(275, 105);
		textArea2.setEditable(false);
		textArea2.append("\n  --------\n");
		for(int i = 0; i < cart.getNumItemsInCart(); i++){
			textArea2.append("$");
			textArea2.append(Double.toString(cart.items[i].getPrice()));
			textArea2.append("\n ");
		}

		textArea2.append("--------\n");
		textArea2.append("$" + customer.myCart.myTax + "\n");
		textArea2.append("$" + customer.myCart.myTaxTotal + "\n");

		
		
		
		
		scrollPane1 = new JScrollPane(textArea1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane1.setLocation(100, 100); 
		scrollPane1.setSize(175, 375);
		
		scrollPane2 = new JScrollPane(textArea2, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane2.setLocation(275, 100); 
		scrollPane2.setSize(75, 375);

		
		
		couponLabel = new JLabel("Do you have any coupons?");
		couponLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
		couponLabel.setLocation(450, 50);
		couponLabel.setSize(400, 150);
		
		yesButton = new JButton("Yes");
		yesButton.setLocation(450, 225);
		yesButton.setSize(100, 50);
		ListenForButton lForYesButton = new ListenForButton(); //Making object from within the object's class may be bad
		yesButton.addActionListener(lForYesButton);
		
		noButton = new JButton("No");
		noButton.setLocation(560, 225);
		noButton.setSize(100, 50);
		ListenForButton lForNoButton = new ListenForButton(); //Making object from within the object's class may be bad
		noButton.addActionListener(lForNoButton);

		helpButton = new JButton("Help");
		helpButton.setLocation(690, 518); //800, 600
		helpButton.setSize(100, 50);
		ListenForButton lForHelpButton = new ListenForButton(); //Making object from within the object's class may be bad
		helpButton.addActionListener(lForHelpButton);

		

	}
}
