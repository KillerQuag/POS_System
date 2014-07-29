package master;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.*;

/*import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JPanel;*/

//This class simulates the process of inserting a check
public class CheckInsertion extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private static CheckInsertion myInstance;

	public JFrame insertCheckFrame;
	public static JTextField amtDueText;
	

	/*public JLabel insertCheckLabel;
	public JButton returnToPayMethods;
	public JFrame insertCashFrame;
	public static JLabel remainingBalance;
	
	public static JButton hundredButton;
	public static JButton fiftyButton;
	public static JButton twentyButton;*/
	
	protected ImageIcon createImageIcon(String path,
            String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
		System.err.println("Couldn't find file: " + path);
		return null;
		}
	}
	
	public CheckInsertion(){
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Use a dismissal button like "Cancel help"
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setBounds(30, 30, 300, 300); //An alternate method for setting size and location of frame
		//Where this method is invoked relative to other matters
		this.setSize(1129, 532); 
		this.setLocationRelativeTo(null); //Centers frame in the middle of the screen
		this.setResizable(false);
		this.setVisible(true);
		//this.getContentPane().setLayout(null);
		
	/*	amtDueText = new JTextField("Fuck you", 20);
		amtDueText.setSize(100, 100);
		amtDueText.setLocation(100, 100);
		this.getContentPane().add(amtDueText);*/
		
		ImageIcon background = createImageIcon("images/BlankCheck.png", "A blank check");
		JLabel theCheck = new JLabel("", background, JLabel.CENTER);
		ListenForButton lForSig = new ListenForButton();
		ListenForButton lForTo = new ListenForButton();
		ListenForButton lForAmount = new ListenForButton();
		ListenForButton lForDate = new ListenForButton();
		//this.setSize(label1.getWidth(), label1.getHeight()); 
		
		JPanel sig = new JPanel();
		ImageIcon janeSig = createImageIcon("images/JaneDoe.png", "Jane's Signature");
		JLabel janeSigLabel = new JLabel(janeSig);
		janeSigLabel.setSize(275, 79);
		janeSigLabel.setLocation(900, 300);
		janeSigLabel.setOpaque(false);
		sig.add(janeSigLabel);
		
		
		//theCheck.addActionListener(lForBG);
		
		this.getContentPane().add(theCheck);
		this.getContentPane().add(sig);
		
		/*BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("c:/BlankCheck.jpg") );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		
		this.getContentPane().add(picLabel);
		//Graphics.this.drawImage(myPicture, 0, 0, null);*/
		this.repaint();
	}

	
	public static CheckInsertion getInstance() {
        if (myInstance == null)
            myInstance = new CheckInsertion();

        return myInstance;
    }
	
	private class ListenForButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*NumberFormat formatter = new DecimalFormat("#0.00");
			Customer customer = (Customer)Main.Customers.get(Main.currentCustNum);
			double cashThisTransaction = 0;*/
			
			//So Main can Listen
			/*Main.mainWindow.lForButton.actionPerformed(e);
		   
			if(e.getSource() == returnToPayMethods) {
				cashThisTransaction = cashThisTransaction + customer.getAmountPaid();
				DisplayCart.textArea1.append("Cash payment:");
				DisplayCart.textArea2.append("$" + formatter.format(cashThisTransaction));
				insertCashFrame.dispose();
				myInstance = null;
			}
			else if(e.getSource() == hundredButton) {
			//	System.out.println(customer.myCart.myTotalPrice);
			//	System.out.println(Cart.myTotalPrice);
				customer.paidCash(100.00);
			
			}*/
		}
	}
	
}
	
