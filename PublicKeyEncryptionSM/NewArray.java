/*
 * This is the client class of the Sieve class that creates a 2D array that is populated with elements using a 
 * for loop. It also prints out each of these elements stored in the array onto the console in the designated rows 
 * and columns that the user stated.
 * 
 * Modified by Sharjil Mohsin
 * On April 4th, 2017
 * Template provided by N. Yhard, created by Maria and Gary Litvin
 * Version 1.0.0
 */

public class NewArray extends Sieve
{ 

  private static int elements;
  // Creates a static integer variable named elements.

  /*
   *  This method creates a 2D array called newMatrix that is going to be used to store all the elements. The method
   *  will then use a for loop to traverse through the rows and columns of the array stores each element in the 
   *  available slot. Finally, the method returns the newMatrix array to other methods that call this method.
   */
  
  public static int[][] matrix(int rows, int columns)
  {
	  elements = 0;
	  // Initializes the elements variable.
	  int[][] newMatrix = new int[rows][columns];
	  // Gives the newMatrix array the number of rows and columns that are taken in.
    
      // The for loop here is used to traverse through the two dimensional arrays and populates the array.
	  for (int r = 0; r < newMatrix.length; r++){
		// For loop for traversing through the rows.  
		  for (int c = 0; c < newMatrix[r].length; c++){
			// For loop for traversing through the columns. 
			  newMatrix[r][c] = elements;
			  // The newMatrix array is given the value of the counter.
			  elements++;
			  // The counter is incremented by one.
		  }
	  }
	  
	return newMatrix;
	// Returns the newMatrix array to other methods that calls the matrix method.
 
  }
 
  /*
   *  This method prints each elements in the table to the console by using a for loop to traverse through each
   *  element and printing out each element in the array. It also arranges the elements by the rows and columns 
   *  that the user directed to the program in the console.
   */

  public static void callMatrix(int rows, int columns){
	  int[][] newMatrix = matrix(rows, columns);  
	  System.out.println("There are " + (rows*columns) + " elements in the matrix.");
	  // Prints out the number of elements in the matrix.
	  
	  for (int r = 0; r < newMatrix.length; r++){
		// For loop for traversing through the rows.  
		   System.out.println(); // Spacing.
		   for (int c = 0; c < newMatrix[r].length; c++){
			// For loop for traversing through the columns. 
			   System.out.print(newMatrix[r][c] + "  ");
			   // Prints out the elements in the newMatrix array.
		   }
	   }
  }

}
