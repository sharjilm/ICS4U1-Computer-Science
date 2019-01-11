/**
  * This is the super class for the IndexCreator program with client classes of IndexEntry.java and DocumentIndex.java.
  * This main class will ask the user for the file name if the file name has not been included in the program, and 
  * then ask the user to name the output file. The program will then open the input file, read a line from the file 
  * and create an index from that line and this process continues until there are no more lines in the file. Then, 
  * the program write the entire index by writing one index at a time on the output file, and then the program closes
  * both the input and the output files.
  * 
  * 
  * Modified by Sharjil Mohsin
  * On April 14th, 2017
  * Template provided by N. Yhard, created by Maria and Gary Litvin
  * Version 1.0.0
  */

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

public class IndexMaker
{
  public static void main(String[] args) throws IOException
  {
    Scanner keyboard = new Scanner(System.in);
    // Sets the keyboard as an input for the console.
    String fileName;


    if (args.length > 0)
    // If the file name is already provided in the program.
      fileName = args[0];
    else
    // If the file name is not provided, then it asks the user the file name, and accepts the user's response.	
    {
      System.out.print("\nEnter input file name: ");
      fileName = keyboard.nextLine().trim();
    }

    BufferedReader inputFile =
                 new BufferedReader(new FileReader(fileName), 1024);
    // Reads the content of the file and stores it in buffer.

    
    if (args.length > 1)
    // If there are two files names provided, the second file name will be stored as the output file.
      fileName = args[1];
    else
    // If the second file name is not provided, then it asks the user the file name, and accepts the user's response.
    {
      System.out.print("\nEnter output file name: ");
      fileName = keyboard.nextLine().trim();
    }

    PrintWriter outputFile =
                 new PrintWriter(new FileWriter(fileName));
    // Opens the output file.


    DocumentIndex index = new DocumentIndex();
    // Calls the DocumentIndex subclass.

    String line;
    int lineNum = 0;
    while ((line = inputFile.readLine()) != null)
    // The while loop reads a line until it reaches the end of the file.	
    {
      lineNum++;
      // Increments line number by 1 if successfully read.
      index.addAllWords(line, lineNum);
      // Calls the "addAllWords" method from the DocumentIndex class.
    }

    for (IndexEntry entry : index)
    // This "for each" loop is used to loop through the length of the index and is stored in the "entry" variable.
      outputFile.println(entry);
      // Writes the entry in the output file.


    inputFile.close();
    // Closes the input file.
    outputFile.close();
    // Closes the output file.

    keyboard.close();
    // Releases the keyboard input.
    System.out.println("Done.");
  }
}
