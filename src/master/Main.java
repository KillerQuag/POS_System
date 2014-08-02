/**
 * 
 */
package master;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.KeyEvent;

/**
 *  This is the main.  There are many like it, but this one is ours.
 */

public class Main extends Display {

	private static final long serialVersionUID = 1L;  //Eclipse wants this garbage everywhere for some reason.

	public static Display mainWindow;
	public static ArrayList Customers = new ArrayList();
	public static int currentCustNum = 0;
	static POSMainframe dailyTotalsSummary;

	public static void main(String[] args) {
		mainWindow = new Display();	
		dailyTotalsSummary = new POSMainframe();
	}
	
	public static void StartTrans() {
		Customer customer = new Customer(); 
		Main.Customers.ensureCapacity(currentCustNum + 1);
		
		//Do all calculations
		customer.myCart = Calculations.SortCart(customer.myCart);
		customer.myCart.myPrice = Calculations.getTotalPrice(customer.myCart);
		customer.myCart.myWeight = Calculations.getTotalWeight(customer.myCart);
		customer.myCart.myTaxTotal = Calculations.getTotalPriceWithTax(customer.myCart);
		customer.myCart.myTax = Calculations.getTax(customer.myCart);
		customer.amountPaid = 0;//needs to be set to 0 for successive transactions
		customer.amountReturned = 0;
		
		//Adds 1 transaction to POSMainframe
		customer.resetPayments();
		dailyTotalsSummary.setNumOfTransactions();
		
		Main.Customers.add(customer);
		
		//Insert Scale exception code here.
		boolean weightError = new Scale().error();
		if (weightError){
			HelpWindow.getInstance();
			HelpWindow.getInstance().helpLabel.setText("<html><center>The scale and cart don't match weights.<br>Please wait."
					+ "<br>An attendant will be with you shortly.</center></html>");
		}

		DisplayCart.display( customer.getCart() );

		mainWindow.remove(startTransactionButton);
		mainWindow.remove(welcomeLabel);
		mainWindow.repaint();
				
		mainWindow.getContentPane().add(Display.couponLabel);
		mainWindow.getContentPane().add(Display.yesButton);
		mainWindow.getContentPane().add(Display.noButton);

		mainWindow.getContentPane().add(Display.scrollPane1); // OLD W/O scroll bars ->   mainWindow.getContentPane().add(textArea1);
		mainWindow.getContentPane().add(Display.scrollPane2);

		mainWindow.getContentPane().add(Display.helpButton);
	
		mainWindow.repaint();  //Critical after every refresh.
	}

}


