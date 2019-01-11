/**
  * This is the main class of the XMLApplication program. The purpose of the program is that it is an XML database used 
  * to store a person's name, phone number, and email address for the user's convenience. The program first asks the
  * user a couple of questions asking whether they want to add or search entries into the program or to terminate the
  * program itself. If they want to add, the program prompts for the name, the phone number, and the email address of 
  * the person they are adding which is then stored into the XML database and displayed to the user. It is also written
  * onto the XML file which is stored into the hard drive. If the user wants to search an entry, the program prompts
  * for the person's name, for which it will display the XML code for sub-element containing the person's name. At the 
  * end, the program will ask the user whether they want to return to the main menu or to terminate the program.
  * 
  * Created by Sharjil Mohsin
  * On May 26th, 2017
  * Version 1.0.0
  */

import nu.xom.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
// Imports required for the program to work.

public class Main {
	
	public static String names;
	// Creates a public static String variable called names.
	public static String phones;
	// Creates a public static String variable called phones.
	public static String emails;
	// Creates a public static String variable called emails.
	public static String choiceNumber;
	// Creates a public static String variable called choiceNumber.
	public static String decisionNumber;
	// Creates a public static String variable called decisionNumber.
	public static String personName;
	// Creates a public static String variable called personName.
	private static int number;
	// Creates a private static String variable called number.
	private static int choice;
	// Creates a private static String variable called choice.
	
	public static Element friends = new Element("friends");
	// Creates a public static Element variable called friends, which is the XML's root node.
	public static Document doc = new Document(friends);
	// Creates a public static Document variable called doc, which holds the XML data.
	
	public static void main(String[] args) {
   
	Scanner keyboard = new Scanner(System.in);
	// Sets the keyboard as an input for the console.
	
	/*
	 * Asks the user what kind of entries do they want to do and prompts the user to enter a choice.
	 */
	System.out.println();
	System.out.println("What do you want to do: \n1. Add entries \n2. Search entries \n3. Exit the program");
	System.out.println();
	choiceNumber = keyboard.nextLine();
	System.out.println();
	
	number = Integer.parseInt(choiceNumber);
	// Parses the String variable choiceNumber into an integer variable called number.
	
	/*
	 * This switch statement is used here so that for the option that the user chooses, the program will use that
	 * case and asks the appropriate questions depending on whichever option the user chose.
	 */
	switch (number) {
	
	/*
	 * If the user chose option 1, the program will ask 3 questions to the user: the name, the phone number, and the 
	 * email address of the person they are entering. Then, the program will create an Element called friend for which
	 * there will be sub-elements called name, phone, and email. The name, phone, and email variables will hold the 
	 * responses from the user. The friend Element will be attached as the sub-element of the friends Element and the 
	 * elements name, phone, and email will be given the inputed name, phone, and email by the user. The following try 
	 * and catch statements are used to use the serializer which will format the XML data so that it will be easier to 
	 * be read by the user. The FileWriter and the BufferedWriter in the next try and catch statement create a new XML 
	 * file on the hard drive and write the data on it. It is then converted to an XML file which the user can access.
	 */
	case 1:
		System.out.println("What is the name of the person you want to add?");
		System.out.println();
		names = keyboard.nextLine();
		System.out.println();
		
		System.out.println("What is their phone number?");
		System.out.println();
		phones = keyboard.nextLine();
		System.out.println();
		
		System.out.println("What is their email address?");
		System.out.println();
		emails = keyboard.nextLine();
		System.out.println();
		  
		Element friend = new Element("friend");
	  	Element name = new Element("name");
	  	Element phone = new Element("phone");
	  	Element email = new Element("email");

	  	name.appendChild(names);
	  	phone.appendChild(phones);
	  	email.appendChild(emails);

	  	friends.appendChild(friend);
	  	friend.appendChild(name);
	  	friend.appendChild(phone);
	  	friend.appendChild(email);
	  	

	  	try
	  	  {
	  	   Serializer serializer = new Serializer(System.out);
	  	   serializer.setIndent(4);
	  	   serializer.setMaxLength(64);
	  	   serializer.write(doc);
	  	  }
	  	
	  	catch (IOException ex)
		   {
		   System.err.println(ex);
		   }
	  	
	  	try
		  {
	  	   FileWriter xmlfile = new FileWriter("myfile.xml");
		   BufferedWriter writer = new BufferedWriter(xmlfile);
		   writer.write(doc.toXML());
		   writer.close();
		  }

		catch (IOException e)
		   {

		   }
	  	break;
	
	/*
	 * If the user chose option 2, the program will ask the user for the name of the person they are searching up. The
	 * response from the user will be stored in the variable personName. Then, the program will create two new 
	 * variables: an Element variable called root that will retrieve the root element from the document, and the 
	 * Elements variable called friends which will retrieve the sub-elements of the root node. Next, a for loop is used
	 * which is used to traverse through the XML database to check whether any of the name sub-elements matches the
	 * name that was provided by the user. When found, the program will take that sub-element and display it to the 
	 * user.
	 */
	case 2:	
		System.out.println("What is the name of the person you are looking for?");
		System.out.println();
		personName = keyboard.nextLine();
		System.out.println();
		
		Element root = doc.getRootElement();
		Elements friends = root.getChildElements();	
		
		for (int j = 0; j < friends.size(); j++)
		  {
			if (friends.get(j).getFirstChildElement("name").getValue().equals(personName))
		      {
				System.out.println(friends.get(j).toXML());
				System.out.println();
			  }
		  }
		break;
	
	/*
	 * If the user chose option 3, the program will first stop the input so that the user does not input anything else 
	 * into the console. Then, it will terminate the whole program.
	 */
	case 3: keyboard.close(); 
	System.exit(0);
		break;
	  
	/*
	 * If the user entered an option other than 1, 2, or 3, the program will give an error message to the user saying
	 * that the input provided is invalid.	
	 */
	default: System.out.println("Invalid input.");
		break;
	
	}
  	
	/*
	 * The program will ask another question to the user where it asks whether the user want to enter another entry or
	 * to exit the program. The choice number that the user will provide will be stored in the variable decisionNumber.
	 */
	System.out.println("Do you wish to add another entry or exit the program?"
			+ "\n1. Add more entries \n2. Exit program");
	System.out.println();
	decisionNumber = keyboard.nextLine();
	System.out.println();
	
	choice = Integer.parseInt(decisionNumber);
	// Parses the String variable decisionNumber into an integer variable called choice.
	
	/*
	 * This switch statement is used here so that for the option that the user chooses, the program will use that
	 * case and take the appropriate action depending on whichever option the user chose.
	 */
	switch (choice){
	
	/*
	 * If the user chose option 1, the program will call the main method which will redirect itself back to the begin-
	 * ning where it will prompt the user to once again choose whether they want to add an entry, search an entry, or
	 * to close the program.
	 */
	case 1: main(new String[] {"a","b","c"});
	break;
	
	/*
	 * If the user chose option 2, the program will first stop the input so that the user does not input anything else 
	 * into the console. Then, it will terminate the whole program.
	 */
	case 2: keyboard.close(); 
	System.exit(0);
	break;
	
	/*
	 * If the user entered an option other than 1 or 2, the program will give an error message to the user saying that
	 * the input provided is invalid.	
	 */
	default: System.out.println("Invalid input.");
	break;
	}	
	
  }
 
}
