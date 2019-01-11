/*
 * This is the super class for the SnackBar program with client classes of VendingMachine.java and Vendor.java. This 
 * class constructs the vending machine objects and creates the password field that is used to display the total 
 * sales when the machines are restocked.
 * 
 * Modified by Sharjil Mohsin
 * On March 2nd, 2017
 * Template provided by N. Yhard, created by Maria and Gary Litvin
 * Version 1.0.0
 */
 
// Imports resources used by the program.

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.Box;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

public class SnackBar extends JFrame
                      implements ActionListener
{
  // Sets the restocking password to "jinx".
	
  private static final String MY_PASSWORD = "jinx";
  private VendingMachine[] machines;

  public SnackBar()
  {
    super("Snack Bar");

    // Loads the coin icon for the vending machine buttons.
    
    ImageIcon coin = new ImageIcon("coin.gif");
    
    // Sets the colour value (RGB) for each of the different brandColours (R, G, B).

    Color brandColor1 = new Color(130, 30, 10); // r, g, b
    Color brandColor2 = new Color(255, 180, 0);
    Color brandColor3 = new Color(90, 180, 0);
    
    // Creates the vending machine objects and adds it to the window.

    VendingMachine[] machines =
    {
      //Creates three new vending machine objects within.
    		
      new VendingMachine("Java", brandColor1, 45, coin),
      new VendingMachine("JApple", brandColor2, 50, coin),
      new VendingMachine("Jinx", brandColor3, 35, coin)
    };
    
    this.machines = machines;
    
    int w = machines.length * (200+5);
    int h = 310;
    setMinimumSize(new Dimension(w, h));
    
    // Creates the GUI module for the structure of the vending machine.

    Box wall = Box.createHorizontalBox();
    wall.add(Box.createHorizontalStrut(5));
    for (VendingMachine machine : machines)
    {
      wall.add(machine);
      wall.add(Box.createHorizontalStrut(5));
    }

    JPanel service = new JPanel();
    service.add(new JLabel(" Service login: "));
    JPasswordField password = new JPasswordField("", 5);
    password.addActionListener(this);
    service.add(password);

    Container c = getContentPane();
    c.setBackground(Color.GRAY);
    c.add(wall, BorderLayout.CENTER);
    c.add(service, BorderLayout.SOUTH);
  }

  /*
   * This section of the program allows the user to access the password field and the
   * user presses the 'Enter' key afterwards. The program will check if the password
   * that was inputed is the same as the one constructed earlier. If the password 
   * matches, it will reset the stocks of the machines and show the total sales to the user.
   */
  public void actionPerformed(ActionEvent e)
  {
    JPasswordField password = (JPasswordField)e.getSource();
    String word = new String(password.getPassword());
    password.setText("");
    if (MY_PASSWORD.equals(word)) // Checks if the password is correct.
    {
      double amount = VendingMachine.getTotalSales(); // Accesses the total sales found in VendingMachine class.
      for (VendingMachine machine : machines)
      machine.reload();
      
      // Displays a pop-up windows that shows the total sales. 
        
      JOptionPane.showMessageDialog(null,
    		  String.format("Total sales: $%.2f\n", amount) + 
    	        "Machines reloaded",
    	        "Service", JOptionPane.INFORMATION_MESSAGE);
    }
    else
    {
    	
      // Login fails and a pop-up window will come showing an error message.
    	
      JOptionPane.showMessageDialog(null,
        "Login failed", "Service", JOptionPane.ERROR_MESSAGE);
    }
  }

  /*
   * This main method will construct the window for the GUI and initializes certain properties such as 
   * size, visibility and what it will do when it is closed.
   */

  public static void main(String[] args)
  {
    SnackBar window = new SnackBar();
    window.setLocation(50, 50);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setVisible(true);
  }
}

