/**
  * This is the super class of the DrawingShapes program with a client class printShapes.java. This main class will ask
  * the user for the shape that they want to choose, and then ask the user for the number of rows that they want their
  * shape to be printed out as on the console. After the user has answered these questions, the program will call the
  * appropriate method based on the choice of the shape that the user made and the methods, which are in the subclass
  * printShapes, are going to print out the shapes using the rows that the user stated and display it onto the console.
  * 
  * Created by Sharjil Mohsin
  * On April 19th, 2017
  * Version 1.0.0
  */

import java.util.Scanner;

public class mainShapes {
	public static String choiceNumber;
	// Creates a public static String variable called choiceNumber.
	public static String numRows;
	// Creates a public static String variable called numRows.
	private static int number;
	 // Creates a private static integer variable called rows.
	private static int rows;
	 // Creates a private static integer variable called rows.

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		// Sets the keyboard as an input for the console.
		
		System.out.println("Choose a shape that you want to print as: \n1. Stars"
				+ "\n2. Triangle \n3. Tree \n4. Diamond");
		// Asks the user to choose the shape on the console.
		System.out.println(); // Spacing.
		choiceNumber = keyboard.nextLine();
		// Stores the answer provided by the user in the choiceNumber variable.
		
		System.out.println(); // Spacing.
		System.out.println("How many rows do you want for your desired shape?");
		// Asks the user about the number of rows they want for their shape.
		numRows = keyboard.nextLine();
		// // Stores the answer provided by the user in the numRows variable.
		
		keyboard.close();
		// Stops the input so that the user does not input anything else into the console.
		
		number = Integer.parseInt(choiceNumber);
		// Parses the String variable choiceNumber into an integer variable called number.
		rows = Integer.parseInt(numRows);
		// Parses the String variable numRows into an integer variable called rows.
		
		System.out.println(); // Spacing.
		
		/*
		 * This switch statement is used here so that for the option that the user chooses, the program will use that
		 * case and call the appropriate method from the printShapes subclass in order to print the shape and the rows
		 * that the user chose.
		 */
		switch (number) {
		
		case 1: printShapes.printStars(rows);
		/* 
		 * If the user chose option 1, it calls the printStars method from the printShapes class and print out a right
		 * angle triangle of stars with the first line showing being a single star using the amount of rows that the 
		 * user stated.
		 */
		
		break; // Terminates the process.
		
		case 2: printShapes.printTriangle(rows);
		/* 
		 * If the user chose option 2, it calls the printTriangle method from the printShapes class and print out a right
		 * angle triangle of stars with the last line showing being a single star using the amount of rows that the 
		 * user stated.
		 */
		
		break; // Terminates the process.
		
		case 3: printShapes.printTree(0, rows);
		/* 
		 * If the user chose option 3, it calls the printTree method from the printShapes class and print out an
		 * equilateral triangle of stars with the first line showing being a single star using the amount of rows that 
		 * the user stated.
		 */
		
		break; // Terminates the process.
		
		case 4: printShapes.printDiamond(0, (rows+1)/2);
		/* 
		 * If the user chose option 4, it calls the printDiamond method from the printShapes class and print out a
		 * diamond of stars with the first and last line showing being a single star using the amount of rows that 
		 * the user stated.
		 */
		
		break; // Terminates the process.
		
		default: System.out.println("Invalid input.");
		// If an option other than 1-4 is chosen, the program will tell the user that the selection is valid.
		
		break; // Terminates the process.
		
		}
		
		
	}

}
