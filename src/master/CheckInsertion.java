package master;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.lang.NumberFormatException;

import javax.imageio.ImageIO;
import javax.swing.*;

//This class simulates the process of inserting a check
public class CheckInsertion extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private static CheckInsertion myInstance;

	public JFrame insertCheckFrame;
	public static JFrame errorFrame;
	
	public static JTextField amtDueText;
	
	private BufferedImage bckgrnd = null;
	Font btnFnt = new Font("Serif", Font.ITALIC, 36);
	
	private JLabel check;	
	
	private JButton amount,
				    signatureBtn,
				    payTo,
				    submitCheck;
	
	boolean amt = false;
	boolean sig = false;
	boolean pt = false;
	boolean sub = false;
	
	private JDialog getAmount = null;
	

	/*public JLabel insertCheckLabel;
	public JButton returnToPayMethods;
	public JFrame insertCashFrame;
	public static JLabel remainingBalance;
	
	public static JButton hundredButton;
	public static JButton fiftyButton;
	public static JButton twentyButton;*/
	
	public CheckInsertion(){
		
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setSize(1139, 542); 
		this.setLocationRelativeTo(null); //Centers frame in the middle of the screen
		this.setResizable(false);
		this.setVisible(true);

		//this.getContentPane().setLayout(null);
		
/*		ImageIcon background = createImageIcon("images/BlankCheck.png", "A blank check");
		JLabel theCheck = new JLabel("", background, JLabel.CENTER);

		//this.setSize(label1.getWidth(), label1.getHeight()); 
		
		JPanel sig = new JPanel();
		ImageIcon janeSig = createImageIcon("images/JaneDoe.png", "Jane's Signature");
		JLabel janeSigLabel = new JLabel(janeSig);
		janeSigLabel.setSize(275, 79);
		janeSigLabel.setLocation(900, 300);
		janeSigLabel.setOpaque(false);
		sig.add(janeSigLabel);
		*/
		
		//NEW CODE BY EDGAR
		
        try {
            bckgrnd = ImageIO.read(getClass().getResource("Images/BlankCheck.png"));
        } 
        catch (IOException e) {
            System.out.println("CheckInsertion could not find image for BlankCheck.png");
            e.printStackTrace();
        }
        
        check = new JLabel(new ImageIcon(bckgrnd));
        check.setBounds(0,0,1139,522);
		
        amount = new JButton();
        amount.setBounds(900,183,200,50);
        amount.setFont(btnFnt);
        amount.setFocusPainted(false); // Sets Focus off for the button
        amount.setBorderPainted(false); // sets button boundaries off
        amount.setOpaque(false);
        amount.setContentAreaFilled(false);
        
        signatureBtn = new JButton();
        signatureBtn.setBounds(620,350,470,80);
        signatureBtn.setFocusPainted(false);  // Sets Focus off for the button
        signatureBtn.setBorderPainted(false); // sets button boundaries off
        signatureBtn.setOpaque(false);
        signatureBtn.setContentAreaFilled(false);
        
        payTo = new JButton();
        payTo.setSize(470, 80);
        payTo.setBounds(180,140,470,80);  //X, Y, Wid, Hei
        payTo.setFocusPainted(false);  // Sets Focus off for the button
        payTo.setBorderPainted(false); // sets button boundaries off
        payTo.setOpaque(false);
        payTo.setContentAreaFilled(false);
        
        submitCheck = new JButton();
        submitCheck.setSize(20, 20);
        submitCheck.setBounds(5,5,20,20);
        submitCheck.setFocusPainted(false);  // Sets Focus off for the button
        submitCheck.setBorderPainted(false); // sets button boundaries off
        
           
        
        
        /*
         * The action listener of the button creates new fields that are placed in the dialog
         * then it gets the amount entered into the text field and place it on the invisible button.
         */
        
        amount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
		        getAmount = new JDialog(CheckInsertion.this,true);
		    	getAmount.setTitle("Enter Check Amount");
		    	getAmount.getContentPane().setLayout(null);
		    	getAmount.setBounds(450,350,230,120);
		    	
		    	JLabel lblname=new JLabel("Enter Amount: ");
		    	lblname.setBounds(20,10,100,25);
		    	
		    	final JTextField txtAmount = new JTextField();
		    	txtAmount.setBounds(120,10,80,25);
		    	
		    	JButton okAmount = new JButton("OK");
		    	okAmount.setBounds(60,50,80,25);
		    	
		    	okAmount.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent event) {
		            	amount.setText(txtAmount.getText());
		            	getAmount.setVisible(false);
		            	getAmount.dispose();		            	
		            	amt = true;
		            }
		    	});
		 
		    	getAmount.add(txtAmount);
		    	getAmount.add(lblname);
		    	getAmount.add(okAmount);
		    	getAmount.show();
            }
        });
        
        signatureBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	signatureBtn.setIcon(new ImageIcon(getClass().getResource("Images/JaneDoe.png")));
            	sig = true;
            }
        });
        
        payTo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	payTo.setIcon(new ImageIcon(getClass().getResource("Images/SMartTextSign.png")));
            	pt = true;
            }
        });
        
        submitCheck.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	Customer customer = (Customer)Main.Customers.get(Main.currentCustNum);
            	
            	if( amt && sig && pt )
            	{
            	
            	try{
            		if( Double.parseDouble(amount.getText()) == customer.getRemainingBalance() )
            		{
            			customer.paidCheck(Double.parseDouble( amount.getText() ) ); 

            			//Display.checkInsertComplete.doClick();
            			myInstance.dispose();
            			myInstance = null;
            		} else if ( Double.parseDouble(amount.getText()) < customer.getRemainingBalance() ) {
            			customer.paidCheck(Double.parseDouble( amount.getText() ) ); 
            			Display.paymentSelection.doClick();
            			myInstance.dispose();
            			myInstance = null;
            		}
            		else
            		{
<<<<<<< HEAD
<<<<<<< HEAD
            			NumberFormat formatter = new DecimalFormat("#0.00");
            			double changeDue = (Double.parseDouble( amount.getText()) - customer.getRemainingBalance());

            			customer.paidCheck(Double.parseDouble( amount.getText()));
            			customer.setChangeDue(changeDue);
            			customer.setAmountReturned(changeDue);            			
            			System.out.println("Change Due:   $" + customer.getChangeDue() + '\n');
            			//System.out.println("")
            			System.out.println("Cash Returned:   $" + Main.dailyTotalsSummary.getTotalCashReturned());
            			Display.checkInsertComplete.doClick();
            			Main.mainWindow.checkOverpayTextField.setText("	$" + formatter.format(changeDue));
            			
            			myInstance.dispose();            			
=======
=======
>>>>>>> origin/master
            			customer.paidCheck(Double.parseDouble( amount.getText() ) ); 
            			Display.checkInsertComplete.doClick();
            			DisplayCart.textArea1.append("Check payment:");
        				DisplayCart.textArea2.append("$" + Calculations.format(customer.paidBy.getCheck()));
        				//Display.currencyField.setText("$" + formatter.format(Math.abs(customer.myCart.myTaxTotal - customer.getAmountPaid()))); //This is the field that shows how much cash as been inserted as you insert it -Heath
        				Display.changeDueField.setText("");
        				Display.changeDueField.setText("$" + Calculations.format(Math.abs(customer.myCart.myTaxTotal - customer.getAmountPaid()))); //This is the field that shows change to be returned to customer -Heath
        				
        				double changeDue = Math.abs(customer.myCart.myTaxTotal - customer.getAmountPaid());
        				customer.setChangeDue(changeDue);
        				customer.setAmountReturned(changeDue);
        				//Main.dailyTotalsSummary.setTotalCashReturned(changeDue);
        				//System.out.println("Change due:  $" + changeDue);
        				Display.changeDueField.setHorizontalAlignment(JLabel.CENTER); //This is the field that shows change to be returned to customer -Heath

            			myInstance.dispose();
            			myInstance = null;
<<<<<<< HEAD
>>>>>>> origin/master
=======

>>>>>>> origin/master
            		}
            		
            	}
            	catch (NumberFormatException e){
            		System.out.println("Empty string or non number, change check amount.");	
            		
            	}             	
            	
            	}
            	else
            	{
            		System.out.println("Please make sure all required fields are filled out and resubmit your check.");
            		errorMessage();
            	}
            }                        
        }); 

		
        this.getContentPane().add(amount);
        this.getContentPane().add(signatureBtn);
        this.getContentPane().add(payTo);
		this.getContentPane().add(submitCheck);
		this.getContentPane().add(check);
		}
	
	public static CheckInsertion getInstance() {
        if (myInstance == null)
            myInstance = new CheckInsertion();

        return myInstance;
    }
	
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
	
	public static void errorMessage()
	{
		JPanel errorPanel;
		JLabel error;
		JButton close;
		
		errorFrame = new JFrame("Processing Error");
        errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        errorFrame.setSize(600, 200); 
        errorFrame.setLocationRelativeTo(null); //Centers frame in the middle of the screen
        errorFrame.setResizable(false);
        errorFrame.setVisible(true);      
        
        errorPanel = new JPanel();
        errorPanel.setSize(600, 200);
        errorPanel.setBackground(Color.white);  
        errorPanel.setLocation(0,0);
        
        error = new JLabel("<html>Please ensure all required fields are filled in and resubmit your check.<html>");
        error.setFont(new Font("Ariel", Font.PLAIN, 18));
        error.setLocation(20, 25);
        error.setSize(600, 100);
        errorFrame.add(error);
        
        close = new JButton("Close");        
        close.setLocation(260, 140);  
        close.setSize(75, 20);
        close.setFocusPainted(false); // Sets Focus off for the button
        close.setBorderPainted(false); // sets button boundaries off
        errorFrame.add(close);
        
        errorFrame.add(errorPanel);
        
        close.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				errorFrame.dispose();
			}
		});
	}
	
	/*public static void invalidAmount()
	{
		JPanel errorPanel;
		JLabel error;
		JButton close;
		
		errorFrame = new JFrame("Processing Error");
        errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        errorFrame.setSize(600, 200); 
        errorFrame.setLocationRelativeTo(null); //Centers frame in the middle of the screen
        errorFrame.setResizable(false);
        errorFrame.setVisible(true);      
        
        errorPanel = new JPanel();
        errorPanel.setSize(600, 200);
        errorPanel.setBackground(Color.white);  
        errorPanel.setLocation(0,0);
        
        error = new JLabel("<html>Check amount may not exceed the total balance due.<html>");
        error.setFont(new Font("Ariel", Font.PLAIN, 18));
        error.setLocation(90, 25);
        error.setSize(600, 100);
        errorFrame.add(error);
        
        close = new JButton("Close");        
        close.setLocation(260, 140);  
        close.setSize(75, 20);
        close.setFocusPainted(false); // Sets Focus off for the button
        close.setBorderPainted(false); // sets button boundaries off
        errorFrame.add(close);
        
        errorFrame.add(errorPanel);
        
        close.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				
				errorFrame.dispose();
			}
		});
	}*/
	
	
}
	
