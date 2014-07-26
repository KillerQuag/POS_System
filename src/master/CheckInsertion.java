package master;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

//This class simulates the process of inserting a check
public class CheckInsertion extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private static CheckInsertion myInstance;

	private Object BufferedImage;
	public JFrame insertCheckFrame;
	

	/*public JLabel insertCheckLabel;
	public JButton returnToPayMethods;
	public JFrame insertCashFrame;
	public static JLabel remainingBalance;
	
	public static JButton hundredButton;
	public static JButton fiftyButton;
	public static JButton twentyButton;*/
	
	public CheckInsertion(){
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Use a dismissal button like "Cancel help"
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setBounds(30, 30, 300, 300); //An alternate method for setting size and location of frame
		this.setSize(800, 600); //Where this method is invoked relative to other matters
		this.setLocationRelativeTo(null); //Centers frame in the middle of the screen
		this.setResizable(false);
		this.setVisible(true);
		this.getContentPane().setLayout(null);
		
		
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("c:/BlankCheck.jpg") );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		
		this.getContentPane().add(picLabel);
		
	}
	
	public static CheckInsertion getInstance() {
        if (myInstance == null)
            myInstance = new CheckInsertion();

        return myInstance;
    }
	
}
