package master;

import javax.swing.*;

//import master.Display.ListenForButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpWindow extends JFrame {
	
	private static HelpWindow myInstance;
	
	public JLabel helpLabel;
	public JButton cancelHelpButton;
	public JFrame helpFrame;
	
	public HelpWindow() {
		
		JPanel pane = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		//For each component to be added to this container:
		//...Create the component...
		//...Set instance variables in the GridBagConstraints instance...
		
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //Use a dismissal button like "Cancel help"
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setBounds(30, 30, 300, 300); //An alternate method for setting size and location of frame
		this.setSize(425, 150); //Where this method is invoked relative to other matters
		this.setLocationRelativeTo(null); //Centers frame in the middle of the screen
		this.setResizable(false);
		this.setVisible(true);
		
		helpLabel = new JLabel("Please wait, an attendant will be with you shortly");
		helpLabel.setFont(new Font("Ariel", Font.PLAIN, 18));
		c.weighty = 0.7;
		pane.add(helpLabel, c);
	
		this.add(pane);
		
		helpFrame = this;
		
		cancelHelpButton = new JButton("Cancel help");
		//cancelHelpButton.setLocation(520, 225);
		c.fill = GridBagConstraints.PAGE_END;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 2;
		pane.add(cancelHelpButton, c);
		cancelHelpButton.setSize(100, 50);
		ListenForButton lForCancelHelpButton = new ListenForButton(); //Making object from within the object's class may be bad
		cancelHelpButton.addActionListener(lForCancelHelpButton);
		
	}
	
	private class ListenForButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == cancelHelpButton) {
				helpFrame.dispose();
				myInstance = null;
			}
		}
	}
	
    public static HelpWindow getInstance() {
        if (myInstance == null)
            myInstance = new HelpWindow();

        return myInstance;
    }
    
    
}//End of HelpWindow class


