/**
 * 
 */
package master;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *  Common database operations should go here.
 */
public class databases extends JFrame{
	
	private static final long serialVersionUID = 1L; //Ignore		
	
	public static JButton MAclose;
	public static JPanel p1;	
	public static JLabel mainframeInfo;
	public static JFrame F1;
	public static JTextArea TA;
	
	public void showMainframeDetails()
	{	
	F1 = new JFrame("POS Mainframe");
	F1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	//this.setBounds(30, 30, 300, 300); //An alternate method for setting size and location of frame
	//F1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	F1.setSize(450, 500); //Where this method is invoked relative to other matters
	F1.setLocationRelativeTo(null); //Centers frame in the middle of the screen
	F1.setResizable(false);
	F1.setVisible(true);
	
	MAclose = new JButton("Return");
	MAclose.setLocation(400, 200);	
	MAclose.setSize(50, 25);
	//MAclose.setBounds(400,200,50,25);
	ListenForButton lForMAclose = new ListenForButton(); //Making object from within the object's class may be bad
	MAclose.addActionListener(lForMAclose);	
	//MAclose.isForegroundSet();
	F1.add(MAclose);
	
	
	TA = new JTextArea(Main.dailyTotalsSummary.toString());
	TA.setSize(400, 450);
	TA.setEditable(false);	
	//F1.add(TA);
	
	Color p1Color = Color.white;
	p1 = new JPanel();
	p1.setBackground(p1Color);	
	p1.add(TA);
	p1.add(MAclose);
	
	//F1.add(p1,BorderLayout.SOUTH);
	F1.add(p1,BorderLayout.CENTER);	
	
	}
	
	static class ListenForButton implements ActionListener 
	{		
		public void actionPerformed(ActionEvent e)
		{
			Main.mainWindow.lForButton.actionPerformed(e);
			if(e.getSource() == MAclose )
			{	
				F1.dispose();
				F1 = null;
			}
		}
	}
}


