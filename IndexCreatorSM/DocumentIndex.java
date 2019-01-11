/**
  * This is a client class of the ArrayList from the IndexEntry class. This class basically represents the entire
  * index of the document. It takes the words from the input file and stores it in an array. It also uses loops to go
  * through the input file and finds the line numbers of where the word is located, which is stored as an index. This
  * class finds the index for the words in the DocumentIndex and if the word isn't found, creates a new DocumentIndex
  * for it.
  * 
  * Created by Sharjil Mohsin
  * On April 14th, 2017
  * Version 1.0.0
  */

import java.util.ArrayList;

public class DocumentIndex extends ArrayList<IndexEntry>
{
    /*
     * This method creates an empty DocumentIndex with the default initial capacity.
     */
    public DocumentIndex()
    {
       super();
    }

    /*
     * This method creates an empty DocumentIndex with the given initial capacity that the method takes in.
     */
    public DocumentIndex(int Capacity)
    {
        super(Capacity);
    }

    /*
     * This method makes sure that the DocumentIndex contains the an IndexEntry for every word by calling the 
     * "foundOrInserted" method from this class. If the word that is taken into this method is not found in the 
     * DocumentIndex, the method creates a new IndexEntry for the word and then inserts it into the list in
     * alphabetical order. It also adds the index for the word that is found or inserted by calling the "add" method
     * from the IndexEntry class.
     */
    public void addWord(String word, int num)
    {
        get(foundOrInserted(word)).add(num);
    }

    /*
     * This method extracts all the word from the String variable "str" and for each word that is brought into the
     * method, this method will call the "addWord" method in this class. First, this method will create an array 
     * called words that will split the "non-word" characters. Using this, the method will use a for each loop to call
     * the "addWord" method for each word in the array, and the if-else statement here is used to filter out empty 
     * or characters that aren't a digit or a letter to make sure that none of the punctuation is listed in the 
     * ArrayList.
     */
    public void addAllWords(String str, int num)
    {
        String[] words = str.split("\\W+");
        for(String word : words)
        {
            if(word.length() > 0)
            {
                addWord(word, num);
            }
        }
    }

    /* 
     * This is a private helper method that traverses through the DocumentIndex and compares the word that is being 
     * taken in to the words in the objects of the IndexEntry class in the ArrayList. It compares to see the position
     * (line number) where the word would match. If the word in the IndexEntry is not already in that position, this
     * method creates and inserts a new IndexEntry number for the word at that position. In the end, the method returns
     * the position of the word that was either found or was inserted in the IndexEntry.
     */ 
    private int foundOrInserted(String word)
    {
        int num;
        int num1;
        
        for (num = 0; num < size(); num++)
        {
            num1 = get(num).getWord().compareToIgnoreCase(word);
            if(num1 == 0)
            {
                return num;
            }
            else if (num1 > 0)
            {
                break;
            }
        }
        
        add(num, new IndexEntry(word));
        return num;
    }
}