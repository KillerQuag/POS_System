/**
 * 
 */
package master;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author John
 *  This will act as the customer.  It will call the other classes/agents to do 
 *  the checkout process.
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
		
		//Adds 1 transaction to POSMainframe
		dailyTotalsSummary.setNumOfTransactions();
		dailyTotalsSummary.setTotalTransaction(Calculations.getTotalPriceWithTax(customer.myCart));

		Main.Customers.add(customer);

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


