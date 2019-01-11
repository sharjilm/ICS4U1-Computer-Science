/**
 * This is a client class of Benchmarks.java of the Benchmarks program. This class carries out the process of Selection
 * Sort, where it sorts out each values in the array that is taken in to ascending order by initializing the sequence at
 * the first element and using a for loop to find the largest element among the "n" elements. It then swaps the largest
 * element found with the last element in the array and decrements the value of "n" by 1. The sorting continues until 
 * there is only one element left, as it has already been compared to every other elements and is guaranteed to be the
 * smallest.
 * 
 * Modified by Sharjil Mohsin
 * On May 2nd, 2017  
 * Template provided by N. Yhard, created by Maria and Gary Litvin
 * Version 1.0.0
 */
public class SelectionSort
{
	
  /*
   * This method carries out the process of the Selection Sort. The method uses a for loop for the overall sorting to
   * make sure that all the elements in the "a" array is traversed for the sorting to take place. It initializes the
   * variable "iMax" and then uses a for loop to search for the largest element in the array. It swaps the found element
   * with the last element and decrements the value of "n" by 1 and repeats the process.
   */
  public static void sort(double[] a)
  {
    for (int n = a.length; n > 1; n--)
    {
    // The for loop starts from the last element in the array and traverses through until it reaches the first element.

      int iMax = 0;
      // Initializes the integer variable called "iMax".
      
      /*
       * Uses a for loop to find the largest value among the first n elements. If the value of the current value is 
       * greater than the element that is being compared, which is the element of the iMax value, then the iMax value
       * is given the value of the variable "i".
       */
      for (int i = 1; i < n; i++)
      {
        if (a[i] > a[iMax])
          iMax = i;
      }
    
      /*
       * A double variable "aTemp" is created which is given the value of the element in the "a" array in the iMax-th
       * position. The value in the iMax-th position is then swapped with the value in the last element of the "a" array
       * so that the largest value is placed correctly, from where it will be moved again. 
       */
      double aTemp = a[iMax];
      a[iMax] = a[n-1];
      a[n-1] = aTemp;

    }
  }
}
