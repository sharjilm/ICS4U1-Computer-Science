/**
  * This is the client class of the mainShapes class of the DrawingShapes program. This class contains the methods
  * that the main class will call based on the user's choice of the shapes that they stated in the console. The first
  * method, printStars, will create a right angle triangle of stars with the first line showing being a single star.
  * The second method, printTriangle, will create a right angle triangle of stars with the last line showing being a 
  * single star. The third method, printTree, will create an equilateral triangle of stars with the first line showing 
  * being a single star. The fourth method, printDiamond, will create a diamond of stars with the first and last line 
  * showing being a single star. These methods all are recursive methods that will print out asterisks in the shape
  * desired by the user and in rows also stated by the user. This class also contains two additional methods that are
  * used to help with the creation of the shapes for the printTree method and the printDiamond method.
  * 
  * Created by Sharjil Mohsin
  * On April 19th, 2017
  * Version 1.0.0
  */

public class printShapes extends mainShapes {

	/*
	 * This method will be used if the user chose option 1, which is the option of printing out a right angle triangle
	 * of stars with the first line showing being a single star. It is a recursive method that uses an if-else statement.
	 * The conditions are that if the number of rows which are taken in equals to 0, then the method will simply return
	 * an empty string. If n, which represent the number of rows, does not equal to 0, then it will use a recursion 
	 * where a String variable x will call the printStars method again but with a decrementation of 1 from the number
	 * of rows for each loop. For each loop, there is an asterisk being added to the string. This makes sure that the
	 * method will start of with one asterisk at the top and will go to a new line where it takes the previous asterisk
	 * and keeps adding on and printing until it reaches the number of rows given to the user. The printed result is then
	 * returned to the main method where it is displayed to the user via the console.
	 */
	public static String printStars(int n){	
		
		if (n == 0) {
			return "";
		}	
		
		else {
			String x = printStars(n-1);
			x = x + "*";
			System.out.println(x);
			System.out.println();
			return x;
		}
	}
	
	/*
	 * This method will be used if the user chose option 2, which is the option of printing out a right angle triangle
	 * of stars with the last line showing being a single star. It is a recursive method that uses an if-else statement.
	 * The conditions are that if the number of rows which are taken in equals to 0, then the method will simply return
	 * an empty string. If n, which represent the number of rows, does not equal to 0, then the method will create an
	 * empty String variable called x. It then uses a for loop where it traverses through the rows and fills it 
	 * with the asterisks based on the number of rows that the user stated. After it puts down the asterisks, it will
	 * move on to the next row where it moves to a new line, prints out the asterisks, and then the return the variable
	 * x while calling the printTriangle method again but with a decrementation of 1 from the number of rows for each 
	 * loop. The printed result is then returned to the main method where it is displayed to the user via the console.
	 */
	public static String printTriangle(int n){	

		if (n == 0){
			return "";
		}
		
		
		else{
			String x = "";
			
			for (int i = 0; i < n; i++) {
				x = x + "*";
			}
			
			x += "\n";
			System.out.println(x);
			return x + printTriangle(n-1);
		}
	}
	
	/*
	 * This method will be used if the user chose option 3, which is the option of printing out an equilateral triangle 
	 * of stars with the first line showing being a single star. It is a recursive method that uses an if-else statement.
	 * The condition is that if i, a counter for the current row number that is initialized at 0, is less than the 
	 * number of rows, then the method will call the printTest method in this class and pass the variables i and n to 
	 * that method, which is then printed out. It will also use recursion where it will call the printTree method again 
	 * but this time increment the variable i by 1 and pass the same number of rows. The printed result is then returned
	 * to the main method where it is displayed to the user via the console.
	 */
	public static void printTree(int i, int n){
		// i acts as the counter for the current row number.
		if (i < n){
			System.out.println(printTest(i, n));	
			printTree(i+1, n);
		}
	}
		
	/*
	 * This method will be used if the user chose option 3, which is the option of printing out a diamond of stars with 
	 * the first and last line showing being a single star. It is a recursive method that uses an if-else statement. The
	 * condition is that if i, a counter for the current row number that is initialized at 0, is less than the 
	 * number of rows, then the method will call the printTest method in this class and pass the variables i and n to 
	 * that method, which is then printed out. It will use a recursion where it will call the printTree method but this 
	 * time increment the variable i by 1 with the same number of rows. This is for the top half of the diamond which
	 * resembles the equilateral triangle similar to option 3. The method will then call the printUtree method and pass
	 * the variables i and n to that method. This is for the bottom half of the diamond, which is an inverted 
	 * equilateral triangle. The printed result is then returned to the main method where it is displayed to the user 
	 * via the console.
	 */
	public static void printDiamond(int i, int n){
		
		if (i < n){
			System.out.println(printTest(i, n));	
			printTree(i+1, n);
						
			printUtree(i, n);
		}
    }
	
	/*
	 * This is an additional method that is made specifically for use with option 4, which creates a diamond of stars. 
	 * It will take the variable i, a counter for the current row number that is initialized at 0, from the 
	 * printDiamond method as well as the variable n, which is the number of rows that the user stated in the console.
	 * The condition is that if i, a counter for the current row number that is initialized at 0, is less than the 
	 * number of rows minus 1, then the method will first call the printUtree method again but this time increment the 
	 * variable i by 1 and pass the same number of rows. Then the method will call the printTest method in this class 
	 * and pass the variables i and n to that method, which is then printed out. This method is structured in the 
	 * exact opposite way of how the printTree method is structured, in order to complete the bottom half of the 
	 * diamond which is an inverted equilateral triangle. 
	 */
	public static void printUtree(int i, int n){
		
		if (i < n-1){
			printUtree(i+1, n);
			System.out.println(printTest(i, n));	
		}
	}
	
	/*
	 * This additional method is created specifically for use with options 3 and 4, which creates an equilateral 
	 * triangle of stars and a diamond of stars, respectively. It will take the variable i, a counter for the current 
	 * row number that is initialized at 0, from the printDiamond method as well as the variable n, which is the number 
	 * of rows that the user stated in the console. This method first creates an empty String variable called x. It 
	 * then uses a for loop to traverse through the rows that were stated by the user. The if-else statement within
	 * the for loop is used to add the asterisk to both sides from the center from the equilateral triangle or the
	 * diamond depending on the row that the program is currently traversing through. The if-else statement shows that
	 * if the variable i, is greater than or equal to the absolute value of k, which determines the distance from the
	 * center of the triangle or diamond, then it adds the asterisk to the desired rows. If this is not the case, then
	 * it just adds an empty string, or a blank. This method is called back to the printTree method and the printDiamond
	 * method.
	 */
	public static String printTest(int i, int n){
		String x = "";
		
		for (int k = -n+1; k < n; k++){
			
			if (i >= Math.abs(k)){
				x = x + "*";
			}
			else{
				x = x + " ";
			}
			
		}
		
		System.out.println();
		return x;
	}
		
}
