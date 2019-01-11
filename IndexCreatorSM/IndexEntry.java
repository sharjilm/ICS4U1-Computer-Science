/**
  * This is another class of the IndexCreator program that acts as a subclass of IndexMaker. This class has an 
  * ArrayList that has a subclass called DocumentIndex.java. This class takes the words that were stored in an array
  * in the DocumentIndex class and turns it in upper case letters. It stores the upper case words in an ArrayList
  * that was created in this class. It also takes the index for each words and attaches it to the words that are in
  * the ArrayList. In the end, the ArrayList is called by the main class, IndexMaker.java, where it is stored in the
  * output file and displayed to the user.
  * 
  * Created by Sharjil Mohsin
  * On April 14th, 2017
  * Version 1.0.0
  */

import java.util.ArrayList;

public class IndexEntry 
{
	
	private String word;
	private ArrayList<Integer> numsList;
	
	/*
	 * This constructor takes the given String variable "word" and converts the word to upper case completely. This 
	 * makes sure that the words on the output will be in upper case letters. It also initializes the ArrayList 
	 * called numsList and it is initialized as an ArrayList<Integer>.
	 */
	public IndexEntry(String word) 
	{
		this.word = word.toUpperCase();
		numsList = new ArrayList<Integer>();
	}
	
	/*
	 * The function of this method is to take the integer variable "num" and append it to numsList, but the
	 * condition has to be that it cannot be already in the list. This method counts the number of words in each
	 * line and then assigns the line number (index) for each word in the text file.
	 */
	public void add(int num) 
	{
		Integer Num = new Integer(num);
		if (!numsList.contains(Num)) {
			numsList.add(Num);
		}
	}
	
	/*
	 * This method returns the word when it is called.
	 */
	public String getWord() 
	{
		return word;
	}
	
	/*
	 * This method returns a string representation from the IndexEntry class in the format where it is turned into
	 * a word followed by a space, followed by numbers that are separated by a comma and space. This method takes the
	 * upper case words from the IndexEntry constructor and the line numbers that were derived in the "add" method and
	 * combines them together. This is then put in alphabetical order using the DocumentIndex class, which is a
	 * subclass of the ArrayList from this class.
	 */
	public String toString() 
	{
		String result = word;
        for (Integer num : numsList)
        {
            result += (" " + num + ",");
        }
        result = result.substring(0 , result.length() - 1);
        System.out.println(result);
        return result;
        
	}
}