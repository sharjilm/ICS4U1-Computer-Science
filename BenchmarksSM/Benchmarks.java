/**
  * This is the main class of the Benchmarks program which calls the other classes, SelectionSort.java,
  * InsertionSort.java, Mergesort.java, and Quicksort.java, for the sorting to take place. The purpose of this program
  * is for the user to enter the size of an array of their own choice and to select the method of sorting that they
  * want. Once the "run" button is clicked, the program will take in the value of the array size and parse it to an 
  * integer value in the RunButtonListener class, where it will create the amount of random numbers based on the array
  * size in the runSort method. The runSort method also calls the appropriate class for whichever sorting method the 
  * user chose and also calculates the average time it takes to sort out the random numbers in millisecond. The main
  * method of this class is resposible for the execution of the program as well as the number of runs of the sorting.
  * 
  * Modified by Sharjil Mohsin
  * On May 2nd, 2017  
  * Template provided by N. Yhard, created by Maria and Gary Litvin
  * Version 1.0.0
  */

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.util.Random;
import java.util.Arrays;

public class Benchmarks extends JFrame
{
  private static int numberOfRuns = 20;
  // Creates a private static integer variable called "numberOfRuns" with a value of 20.

  private JTextField arraySizeInput, display;
  private String sortMethodNames[] =
     {"Selection Sort", "Insertion Sort", "Mergesort", "Quicksort"};
  private JComboBox<String> chooseSortMethod;
  // Starting Java 7 JComboBox is type specific.  In earlier versions use
  // private JComboBox chooseSortMethod;

  private final long seed;
  // Creates a final long variable named "seed". 
  private int arraySize;
  // Creates an integer variable named "arraySize".

  /*
   * This method is a constructor of this class that first calls the super class, the JFrame of this program and
   * places a title for the program by calling it "Benchmarks". This method creates the main GUI structure of the 
   * program where it puts the label "Array Size:" and then the input box, where the user can put in any value of
   * the array size of their choice. It also creates JButton called "run" that allows the user to run the program
   * once the button is pressed. It creates another section on the program with the label "avg time (milliseconds)"
   * and a field beneath it with a yellow background that displays the time it takes for the program to sort the 
   * desired amount of numbers in the array in milliseconds. Finally, the method takes the variable named "seed" and
   * gives it a value of the current system time in milliseconds.
   */
  public Benchmarks()
  {
    super("Benchmarks");

    Container c = getContentPane();
    c.setLayout(new GridLayout(6, 1));

    c.add(new JLabel(" Array size: "));
    arraySizeInput = new JTextField(4);
    arraySizeInput.setText("1000");
    arraySizeInput.selectAll();
    c.add(arraySizeInput);

    chooseSortMethod = new JComboBox<String>(sortMethodNames);
    
    c.add(chooseSortMethod);

    JButton run = new JButton("Run");
    run.addActionListener(new RunButtonListener());
    c.add(run);

    c.add(new JLabel(" Avg Time (milliseconds): "));

    display = new JTextField("   Ready");
    display.setBackground(Color.YELLOW);
    display.setEditable(false);
    c.add(display);

    seed = System.currentTimeMillis();
  }
  
  /*
   * This method is used to access the subclasses of this class for whichever sorting method that the user chose.
   * It first creates the long variables "startTime", "endTime", and "totalTime". Then, it creates a variable
   * "generator" of Random type which is then given the value of the "seed" variable. This makes the "generator" 
   * variable act like a random number generator with an unpredictable seed. The seed isn't unpredictable, it changes 
   * with each millisecond on the clock. The for loop is then used to access the array that is taken into the method
   * and then fills the array with the random numbers of the quantity that is stated by the user. The variable 
   * "startTime" is used to take the time in milliseconds before the sorting begins. The switch statement is then used
   * to access the sorting subclass based on the user's choice. If the user chose the first option, which is "Selection
   * Sort", then the method uses a for loop to access the SelectionSort subclass for 20 runs and the subclass takes in
   * the array with the random numbers. If the user chose the second option, which is "Insertion Sort", then the method
   * uses a for loop to access the InsertionSort subclass for 20 runs and the subclass takes in the array with the 
   * random numbers. If the user chose the second option, which is "Mergesort", then the method uses a for loop to 
   * access the Mergesort subclass for 20 runs and the subclass takes in the array with the random numbers. If the user 
   * chose the fourth option, which is "Quicksort", then the method uses a for loop to access the Quicksort subclass for
   * 20 runs and the subclass takes in the array with the random numbers. The variable "endTime" is used to take the 
   * time in milliseconds after the sorting finished. The variable "totalTime" calculates the duration of the sorting
   * by subtracting the start time from the end time. In the end, the method returns the "totalTime" variable, which
   * contains the duration of the sorting in milliseconds.
   */
  private long runSort(double[] a, int sortMethod, int numberOfRuns)
  {
    long startTime, endTime, totalTime;
	
	Random generator = new Random(seed);
	
   	for(int k = 0; k < a.length; k++)
	{
   		a[k] = generator.nextDouble();
	}
		 
	startTime = System.currentTimeMillis();
		
	switch (sortMethod)
	{
	case 1:
		for(int i = 0; i < numberOfRuns; i++)
		{	
			SelectionSort.sort(a);	
		}
	break;
	
	case 2: 
		for(int i = 0; i < numberOfRuns; i++)
		{	
    		InsertionSort.sort(a);
		}
	break;
	
	case 3:
		for(int i = 0; i < numberOfRuns; i++)
		{	
    		Mergesort.sort(a);
		}
	break;
	
	case 4:
		for(int i = 0; i < numberOfRuns; i++)
		{	
    		Quicksort.sort(a);
		}
	break;   
	}

	endTime = System.currentTimeMillis(); 
    totalTime = endTime - startTime;
    
    return totalTime;
  }
  
  /*
   * This method is used to handle all the events that take place once the implements the ActionListener interface. 
   * This allows it to have the elements of the ActionListener interface, which is used for receiving action events. It 
   * first creates a variable "inputStr", which takes the number from the text box that the user put in and parses it as
   * the variable "arraySize", which was created earlier. It then checks if the number put into the text box is valid 
   * for the sorting to take place. If a number less than or equal to 0 is put in, or if a character other than a number
   * is put in, then the program will tell the user that the array size that was put in is invalid. Once the array size 
   * is put in, the method then stores the choice of the user from the drop down user as the integer variable 
   * "sortMethod". It also stores all the random numbers generated in the array called "a". It also creates the double 
   * variable "avgTime", which calls the runSort method within this class and takes in the "a" array, the options for 
   * the drop down menu, and the number of runs into the method. Finally, the method prints out the array size, the 
   * number of runs, and the average time it takes to sort each individual random numbers to the console.
   */
  private class RunButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      String inputStr = arraySizeInput.getText().trim();
      try
      {
        arraySize = Integer.parseInt(inputStr);
      }
      catch (NumberFormatException ex)
      {
        display.setText(" Invalid array size");
        arraySize = 0;
        return;
      }

      if (arraySize <= 0)
      {
        display.setText(" Invalid array size");
        return;
      }

      if (arraySize <= 0)
        return;

      int sortMethod = chooseSortMethod.getSelectedIndex() + 1;
      double a[] = new double[arraySize];
      double avgTime = (double)runSort(a, sortMethod, numberOfRuns)
                                                          / numberOfRuns;
      display.setText(String.format("  %.2f", avgTime));

      arraySizeInput.selectAll();
      arraySizeInput.requestFocus();
      System.out.println("Array size = " + arraySize +
            " Runs = " + numberOfRuns + " " +
            sortMethodNames[sortMethod - 1] + " avg time: " + avgTime);

    }
  }

  /*
   * This is the main method of the class. It first takes the "numberOfRuns" variable and assigns it a value of 20. 
   * This makes the default setting of the number of runs set to 20. If the user decides to enter a number as a command
   * line, the program uses an if-else statement to check whether the input is valid. If the value that is put into
   * the command line is not a number, then the program will return a message to the user saying that the parameter
   * that the user input was invalid. If the user puts a number, then the method will replace the current number of runs
   * with the value that was entered by the user.
   */
  public static void main(String[] args)
  {
    numberOfRuns = 20;
    if (args.length > 0)
    {
      int n = -1;
      try
      {
        n = Integer.parseInt(args[0].trim());
      }
      catch (NumberFormatException ex)
      {
        System.out.println("Invalid command-line parameter");
        System.exit(1);
      }
      if (n > 0)
        numberOfRuns = n;
    }

    /*
     * The following code is used to set the size of the window of the program that is going to be displayed to the
     * user. It also puts the code for the function of the close button when pressed. It makes sure that the program
     * is visible to the user.
     */
    Benchmarks window = new Benchmarks();
    window.setBounds(300, 300, 180, 200);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setVisible(true);
  }
}
