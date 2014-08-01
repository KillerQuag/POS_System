/**
 * 
 */
package master;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.KeyEvent;

/**
 * @author John
 *  This is the main.  There are many like it, but this one is ours.
 */

/** TODO
 * 
 * USE:
 * Format nubmers with Calculations.format(double)
 * 
 * Check insertion, Credit, Debit send events back to Display indicating transaction state
 * 
 * Uniform rounding calculation cause .19 seems to round to .20 in Display but .19 in console for Mainframe
 * Card Swipe instancing to fix Remaining balance display in Main windows
 * Credit/Debit/Gift card and Checks needs final transaction flows.  
 * 		IE, update remaining balance to 0 and put a line in for paid by credit/debit/card --Leah
 * Transaction CF branch dead ends, wait 5s then loop back to beginning "Welcome" screen
 * Add background image to Welcome screen, etc.
 * Mainframe blue button doeesn't work after clicking yes on Coupon - Matt
 * JUnit - JOHN
 * Class diagram... can autogenerate these, ask Edgar for the program name.
 * 
 * 
 * Wishlist:
 * 		after coupon insertion, go straight to select payment methods
 * 		clean up comments
 *		inventory quantity
 */
public class Main extends Display {

	private static final long serialVersionUID = 1L;  //Eclipse wants this garbage everywhere for some reason.
	/**
	 * @param args
	 */

	public static Display mainWindow;
	public static ArrayList Customers = new ArrayList();
	public static int currentCustNum = 0;
	static POSMainframe dailyTotalsSummary;

	public static void main(String[] args) {
		// TODO Commented out the stuff below, not sure what is the most current
		// iteration of the code, I think Matt has the answer.
		mainWindow = new Display();	
		dailyTotalsSummary = new POSMainframe();
		//Key1 listenForMain = new Key1();
		//database = new POSMainframe();
	}
	
	public static void StartTrans() {
		// TODO Auto-generated method stub

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
		
		//TODO  This needs to be put in the end state of the transaction to increment the array.
		//currentCustNum = currentCustNum++;
		
		mainWindow.getContentPane().add(Display.couponLabel);
		mainWindow.getContentPane().add(Display.yesButton);
		mainWindow.getContentPane().add(Display.noButton);

		mainWindow.getContentPane().add(Display.scrollPane1); // OLD W/O scroll bars ->   mainWindow.getContentPane().add(textArea1);
		mainWindow.getContentPane().add(Display.scrollPane2);

		mainWindow.getContentPane().add(Display.helpButton);
		mainWindow.getContentPane().add(remainingBalanceLabel);
		

		mainWindow.repaint();  //Critical after every refresh.
	}

}


