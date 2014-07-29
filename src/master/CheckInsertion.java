package master;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.imageio.ImageIO;
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
	
	private BufferedImage bckgrnd = null;
	Font btnFnt = new Font("Serif", Font.ITALIC, 36);
	
	private JLabel check;
	
	private JButton amount,
				    signatureBtn;
	
	private JDialog getAmount = null;
	

	/*public JLabel insertCheckLabel;
	public JButton returnToPayMethods;
	public JFrame insertCashFrame;
	public static JLabel remainingBalance;
	
	public static JButton hundredButton;
	public static JButton fiftyButton;
	public static JButton twentyButton;*/
	
	public CheckInsertion(){
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		this.setSize(1139, 542); 
		this.setLocationRelativeTo(null); //Centers frame in the middle of the screen
		this.setResizable(false);
		this.setVisible(true);

		
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
        
        signatureBtn = new JButton();
        signatureBtn.setBounds(620,350,470,80);
        signatureBtn.setFocusPainted(false);  // Sets Focus off for the button
        signatureBtn.setBorderPainted(false); // sets button boundaries off
        
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
            }
        });
 
		
        this.getContentPane().add(amount);
        this.getContentPane().add(signatureBtn);
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
	
	
}
	
