/*
 * This is a client class of the SnackBar class that creates the methods used for the buttons that deposit
 * money and performs some GUI functions as well. The GUI functions will create the buttons and the banners where
 * the deposited amount will be stored. This class also handles the functions that occur when the buttons are clicked 
 * and sends the price values to the Vendor client.
 * 
 * Modified by Sharjil Mohsin
 * On March 2nd, 2017
 * Template provided by N. Yhard, created by Maria and Gary Litvin
 * Version 1.0.0
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class VendingMachine extends JPanel
                            implements ActionListener
{
	
  // Initializes variables used by this class.
	
  private static final int FULL_STOCK = 5;
  private JButton deposit25c, deposit10c, deposit5c, go;
  private JTextField display;
  private Vendor vendor;
  boolean trayFull;
  Color brandColor;
  String brandName;

  public VendingMachine(String brand, Color color, int price, ImageIcon coin)
  {
    setBackground(Color.WHITE);
    brandColor = color;
    brandName = brand;

    JTextField banner = new JTextField("  " + brandName +
                                       "  " + price + "c  ");
    banner.setEditable(false);
    banner.setFont(new Font("Serif", Font.BOLD, 14));
    banner.setHorizontalAlignment(JTextField.CENTER);
    
    // Creates all buttons that are going to be used by the vending machines along with its action listeners.

    deposit25c = new JButton(" 25", coin);
    deposit25c.addActionListener(this);
    deposit10c = new JButton(" 10 ", coin);
    deposit10c.addActionListener(this);
    deposit5c = new JButton("  5 ", coin);
    deposit5c.addActionListener(this);
    go = new JButton("Buy");
    go.setBackground(Color.PINK);
    go.addActionListener(this);
    JPanel buttons = new JPanel(new GridLayout(3, 1, 5, 0));
    buttons.setBackground(Color.BLUE);
    buttons.add(deposit25c);
    buttons.add(deposit10c);
    buttons.add(deposit5c);
    
    // Creates the display that will show the total change given.	

    display = new JTextField("0  ");
    display.setFont(new Font("Monospaced", Font.BOLD, 16));
    display.setBackground(Color.YELLOW);
    display.setEditable(false);
    display.setHorizontalAlignment(JTextField.RIGHT);

    Box b1 = Box.createVerticalBox();
    b1.add(banner);
    b1.add(Box.createVerticalStrut(5));
    b1.add(display);
    b1.add(Box.createVerticalStrut(12));
    Box b2 = Box.createHorizontalBox();
    b2.add(Box.createHorizontalStrut(60));
    Box b3 = Box.createVerticalBox();
    b3.add(go);
    b3.add(Box.createVerticalStrut(8));
    b3.add(buttons);
    b2.add(b3);
    b1.add(b2);
    b1.add(Box.createVerticalStrut(5));
    add(b1);

    vendor = new Vendor(price, FULL_STOCK);
  }
  
  /*
   * This method reloads all the vending machines, resetting the stock back to 5 and resetting the text boxes
   * where the user's cash is displayed at zero.
   */

  public void reload()
  {
    vendor.setStock(FULL_STOCK);
    display.setText(" " + vendor.getDeposit() + "  ");
    repaint();
  }
  
  /*
   * This method is a link from the SnackBar class to the Vendor class that transfers the information through to
   * SnackBar. This was done to allow for easier changes to one of the classes without causing problems to other 
   * classes. 
   */
  
  public static double getTotalSales()
  {
	  double amt = Vendor.getTotalSales();
	  return amt;
  }
  
  /*
   * When one of the buttons is clicked, the listener will check to see what type of button was pressed (25c, 10c, or
   * 5c) and adds the appropriate amount of change to the vending machine's change storage. If the button pressed is
   * the 'Go' button, it will check to see if there is enough change to purchase the product and either sell or
   * give back the change.
   */

  public void actionPerformed(ActionEvent e)
  {
    JButton b = (JButton)e.getSource();

    if (b == deposit25c)
      vendor.addMoney(25);
    else if (b == deposit10c)
      vendor.addMoney(10);
    else if (b == deposit5c)
      vendor.addMoney(5);
    else if (b == go)
    {
      /*
       * Checks to see if there is enough stock and whether the user has put enough change into the machine. 
       * Gets the change from the operation afterwards.	
       */
    	
      trayFull = vendor.makeSale();
      int change = vendor.getChange();
      
      /*
       * If there is enough stock and the user has inserted enough change then a pop-up window will display the 
       * change and the type of drink purchased.
       */
      
      if (trayFull)          
      {
        repaint();
        JOptionPane.showMessageDialog(null,
          "Enjoy your " + brandName + "\n" + " Change " + change + "c",
          "Enjoy " + brandName, JOptionPane.PLAIN_MESSAGE);
        trayFull = false;
      }
      else if (change > 0)   // Gives the user the refund value.
      {
        JOptionPane.showMessageDialog(null,
          "Take " + change + "c back",
          "Money back", JOptionPane.ERROR_MESSAGE);
      }
    }
    
    /*
     * If the vending machine doesn't have enough stock it will display an error message, or else it will display
     * the amount deposited into the vending machine.
     */

    if (vendor.getStock() > 0)
      display.setText(" " + vendor.getDeposit() + "  ");
    else
      display.setText("Call service ");

    repaint();
  }
  
  // Handles graphics for the can icons.

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    final int x0 = getWidth() / 12;
    final int y0 = getHeight() / 2;
    final int yStep = 14;

    g.setColor(Color.BLACK);
    g.drawRect(x0, y0, 28, FULL_STOCK * yStep + 4);

    int y = y0 + 4, x = x0 + 4;
    int stock = vendor.getStock();
    int count = FULL_STOCK;

    while (count > 0)
    {
      if (count <= stock)
        drawCan(g, x, y);
      y += yStep;
      count--;
    }

    g.setColor(Color.BLUE);
    y += yStep;
    g.drawRect(x0, y - 4, 28, 18);

    if (trayFull)
      drawCan(g, x, y);
  }
  
  // Creates the can icon using the brand colours.

  private void drawCan(Graphics g, int x, int y)
  {
    g.setColor(brandColor);
    g.fillRoundRect(x, y, 20, 10, 4, 4);
    g.setColor(Color.WHITE);
    g.drawLine(x + 2, y + 4, x + 14, y + 4);
    g.drawLine(x + 2, y + 6, x + 14, y + 6);
  }
}

