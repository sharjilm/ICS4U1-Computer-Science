/**
 * This is a client class of Benchmarks.java of the Benchmarks program. This class carries out the process of Insertion
 * Sort, where it sorts out each values in the array that is taken in to ascending order by initializing the sequence at
 * the first element and using a for loop to traverse through the array until it reaches the last element. It also uses
 * a while loop to save the next element and find a place to insert it among the first elements so that the order is 
 * preserved. It shifts the elements as necessary to the right and insert the saved one in the created vacant slot. This
 * makes sure that the beginning part of the array is sorted and the next elements are correctly inserted.
 * 
 * Modified by Sharjil Mohsin
 * On May 2nd, 2017  
 * Template provided by N. Yhard, created by Maria and Gary Litvin
 * Version 1.0.0
 */
public class InsertionSort
{
  // Sorts a[0], ..., a[a.length-1] in ascending order
  //   using Insertion Sort.
	
 /*
  * This method carries out the process of the Selection Sort. The method uses a for loop for the overall sorting to
  * make sure that all the elements in the "a" array is traversed for the sorting to take place. It creates a double
  * variable "aTemp" and then uses a while loop to shift the larger values to the right in order to make sure that
  * the values in the array is placed in an ascending order. The value of "n" increments by 1 and continues the proces
  * until it traverses through all the elements in the array.
  */ 
  public static void sort(double[] a)
  {
    for (int n = 1; n < a.length; n++)
    {
      /*
       *  The for loop initializes the variable "n" to 1, and traverses through the array until it reaches the last 
       *  element.
       */
      
      double aTemp = a[n];
      // Creates a double variable called "aTemp" which 

      /*
       * The integer variable "i" is created and given the value of "n". The while loop here is used if "i" is less than
       * 0 and if "aTemp" is less than the value of the i-1th element of the array. If it meets these conditions, then
       * the program will go backward from a[n-1] and shifts the elements to the right, while decrementing the value of
       * "i" by 1. This process will continue until a[i] <= aTemp. 
       */
      int i = n;
      while (i > 0 && aTemp < a[i-1])
      {
        a[i] = a[i-1];
        i--;
      }

      a[i] = aTemp;
      // Inserts the saved element of the aTemp into a[i].

      // Increment n (accomplished by n++ in the for loop).
    }
  }
}

