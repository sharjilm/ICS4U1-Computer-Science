/*
 * This is the super class for the PublicKeyEncryption program with a client class of NewArray.java. It takes the
 * 2D array created in the NewArray class and filters out all the prime numbers using a for loop. It then prints
 * all these prime numbers onto the console and displays it to the user. 
 * 
 * Modified by Sharjil Mohsin
 * On April 4th, 2017
 * Template provided by N. Yhard, created by Maria and Gary Litvin
 * Version 1.0.0
 */

import java.util.Scanner;

public class Sieve
{
 public static String numRows;
 // Creates a public static String variable called numRows.
 public static String numColumns;
 // Creates a public static String variable called numColumns.
 private static int rows;
 // Creates private static integer variable called rows.
 private static int columns;
 // Creates private static integer variable called columns.

 /*
  * This method will take the 2D array created in the matrix method of the NewArray class and using a for loop, 
  * check through all the elements to see if the numbers are prime numbers or not. If the number is a prime number,
  * it will be placed in a 1D array called primeValue, which will be displayed on the console in rows of 20. 
  * If the number is not a prime number, it will be discarded and not displayed on the console.
  */
 
 public static boolean[][] startPrimes(int rows, int columns){
	  
	  boolean[][] isPrime = new boolean[rows][columns];
	  // This is the map of the prime numbers in the 2D array.

	  int[] primeValue = new int[rows*columns];
	  // Creates a 1D array that holds all the prime numbers.
  
	  for (int a = 0; a < rows*columns; a++){
		  // Traverses through the rows and columns of the 2D array.  
		  primeValue[a] = 0;
		  // Initializes the primeValue array.
		  }
	  
	  int[][] newMatrix = NewArray.matrix(rows, columns);
	  // Creates the newMatrix array and gives the number of rows and columns that are taken in.
  
	  int i = 0;
	  // Initializes the number of prime numbers at 0.
  
	  primeValue[i] = 2;
	  // Adds the first prime number which is 2.
	  i++;
	  // Increments to the next available slot in the array.
	  
	  for (int r = 0; r < newMatrix.length; r++){
		  // Traverses through the rows of the 2D array.
		  for (int c = 0; c < newMatrix[r].length; c++){
			  // Traverses through the columns of the 2D array.
			  boolean checker = true; 
			  // Creates the variable checker which will be true if it is a prime number.
			  if (newMatrix[r][c] > primeValue[i-1]){ 
				  // If the value of newMatrix is greater than the last prime number.  
				  
				  for (int k = 0; k < i; k++){
					  if (newMatrix[r][c] % primeValue[k] == 0){	  
					  // If the value is a multiple of the prime number, then it is not a new prime number. 
						  checker = false;
					      // Therefore, the checker checks it as false.		  
				 }
			 }
		
		 if (checker){
			 // If the checker is true, then it is a prime number. 
		 primeValue[i] = newMatrix[r][c];
		 // Adds the prime number into the 1D array.
		 i++;
		 // Increments the total number of prime numbers found.
		 isPrime[r][c] = true;
		 // Changes the current map as true.
		 }
		  }
	  }
  }
  
  System.out.println("There are " + i + " prime numbers in the array.");
  // Prints out to the console the number of prime numbers in the array.
  
  for (int j = 0; j < i; j++)
  {
	  if (j % 20 == 0)
	  // If the for loop reaches every 20th array.  
	  {
		  System.out.println();
		  // Prints out a new line which makes a new row.
	  }
	  System.out.print(primeValue[j] + "  ");
	  // Prints out all the prime number.
  }
  
  return isPrime;
  // Returns the variable isPrime, which holds all the prime numbers that it retrieved from the 2D array.
 }
  
 /*
  * This is the main method of the whole program. It prints out the questions asked to the user onto the console. 
  * After the user answers the two questions, the program will take the values that the user stated and then call
  * the callMatrix method from the newArray class and the startPrimes method from this class to display the number
  * of elements in the matrix and the number of prime numbers in the array.
  */
 
 public static void main(String[] args)
  {
    
    Scanner kboard = new Scanner(System.in);
    // Sets the keyboard as an input for the console.
    
    System.out.println("How many rows would you like in the array?");
    // Displays the question, "How many rows would you like in the array?" to the user.
    numRows = kboard.nextLine();
    // Stores the answer provided by the user in the numRows variable.
    
    System.out.println(); // Spacing.
    
    System.out.println("How many columns would you like in the array?");
    // Displays the question, "How many columns would you like in the array?" to the user.
    numColumns = kboard.nextLine();
    // Stores the answer provided by the user in the numColumns variable.
    
    kboard.close();
    // Stops the input so that the user does not input anything else into the console.
      
    rows = Integer.parseInt(numRows);
    // Parses the String variable numRows into an integer variable called rows.
    columns = Integer.parseInt(numColumns);
    // Parses the String variable numColumns into an integer variable called columns.

    System.out.println(); // Spacing.
    System.out.println("2D Array");
    // Prints out the line "2D Array".
    NewArray.callMatrix(rows, columns);
    // Calls the callMatrix method from the newArray class.
    System.out.println(); // Spacing.

    System.out.println(); // Spacing.
    System.out.println("1D Array");
    // Prints out the line "1D Array".
    Sieve.startPrimes(rows, columns);
    // Calls the startPrimes method from the Sieve class.
    System.out.println(); // Spacing.
   
    
  }  
}
