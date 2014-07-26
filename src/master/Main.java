/**
 * 
 */
package master;

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
	static Display mainWindow; 
	
	public static void main(String[] args) {
		// TODO Commented out the stuff below, not sure what is the most current
		// iteration of the code, I think Matt has the answer.
		mainWindow = new Display();	

	}
	
	public static void StartTrans() {
		// TODO Auto-generated method stub
		Cart cart = new Cart();
		cart = ProductScanner.populateCart(cart);
		Calculations.SortCart(cart);
		
		DisplayCart.display(cart);
		//Display.startTransactionButton.remove(mainWindow);
		mainWindow.remove(startTransactionButton);
		mainWindow.remove(welcomeLabel);
		mainWindow.repaint();
		//Display.welcomeLabel.remove(mainWindow);
		
		mainWindow.getContentPane().add(Display.couponLabel);
		mainWindow.getContentPane().add(Display.yesButton);
		mainWindow.getContentPane().add(Display.noButton);

		mainWindow.getContentPane().add(Display.scrollPane1); // OLD W/O scroll bars ->   mainWindow.getContentPane().add(textArea1);
		mainWindow.getContentPane().add(Display.scrollPane2);

		mainWindow.getContentPane().add(Display.helpButton);
		
		

		mainWindow.repaint();  //Critical after every refresh.
	}

}


