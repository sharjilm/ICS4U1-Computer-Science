/*
 * This is a client class of the SnackBar class that implements a vendor that sells one kind of items that the user
 * chooses. This class also carries out sales transactions in the vending machine when the user attempts to purchase
 * an item, and returns the change to the user.
 * 
 * Modified by Sharjil Mohsin
 * On March 2nd, 2017
 * Template provided by N. Yhard, created by Maria and Gary Litvin
 * Version 1.0.0
 */

public class Vendor
{
	
	// Initializes variables used by this class. 

	private int stock;
	private int price;
	private int deposit;
	public static double totalSales = 0;
	private int change;

  /*
   * Constructs the Vendor object sets the price and stock of one of the items. Runs three times for each of the
   * vending machines. 	
   */
	
  public Vendor(int price, int stock)
  {
    this.price = price;
    this.stock = stock;
  }

  // Sets the remaining amount of cans in the vending machines.
  
  public void setStock(int stock) 
  {
	  this.stock = stock;
  }

  // When accessed, this method will return the amount of cans remaining in the vending machine.
  
  public int getStock()
  {
	  return stock;
  }

  /*
   * When one of the buttons that add money to the vending machine is pressed, it will add the value to the total
   * deposit amount in the vending machine. 
   */
  
  public void addMoney(int cash)
  {
    deposit += cash;
  }

  // This method will return the amount of money in the machine when called. 

  public int getDeposit()
  {
    return deposit;
  }

  /*
   * When the user tries to purchase a drink, the method checks if the user can afford it. If so, then the sale goes 
   * through reducing the stock by one, saving the total sales by adding itself with its price divided by 100, and then
   * calculating the amount change. If the user cannot afford it, the program will return the amount deposited to the
   * user. 
   */ 
  
  public boolean makeSale()
  {
    if(stock > 0 && deposit >= price)
    {
    	/*
    	 *  After the amount change is calculated, the deposit is reset back to zero and the method will return a 
    	 *  true value.
    	 */
    	stock = stock - 1;
    	totalSales = totalSales + ((double) price)/100;
    	change = deposit - price; 
    	deposit = 0; 
    	return true;
    }
    else {
    change = deposit;
    deposit = 0;
	return false;
    }
  }

  /*
   * This method resets the amount of change while simultaneously returning the value to the command that called
   * it.
   */
  
  public int getChange()
  {
	int storedChange = change;
    change = 0;
    return storedChange;
  }
  
  // Has the same function as the getChange method but with the total revenue.

  public static double getTotalSales()
	{
		double totalRevenue = totalSales;
		totalSales = 0;
		return totalRevenue;
	}

}