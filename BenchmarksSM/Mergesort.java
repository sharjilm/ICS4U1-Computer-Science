/**
 * This is a client class of Benchmarks.java of the Benchmarks program. This class carries out the process of Mergesort,
 * where it sorts out each values in the array that is taken in to ascending order by first taking the array and then
 * splitting it to half. Then, the class will compare the first element of the first array with the first element of 
 * the second array. The element is stored in a third array, which will collect all the elements in ascending order. 
 * Once the sorting is complete, the class will store the sorted elements in the original array and return the array
 * to the Benchmarks class, where it will calculate the time taken.
 * 
 * Modified by Sharjil Mohsin
 * On May 2nd, 2017  
 * Template provided by N. Yhard, created by Maria and Gary Litvin
 * Version 1.0.0
 */
public class Mergesort
{
  private static double[] temp;
  // Creates a private double array called "temp"

  /*
   * This method takes in an array called "a", and then assigns the length of the array in an integer variable "n". 
   * It also assigns "n" as an element position of the "temp" array, and then calls the recursiveSort method from this
   * class passing the array "a", the integer 0, and the integer value n-1.
   */
  public static void sort(double[] a)
  {
    int n = a.length;
    temp = new double[n];
    recursiveSort(a, 0, n-1);
  }
  
  /*
   * This method is a recursive method as it has the base case, which is that the array contains only 1 or 2 elements,
   * or if the array contains more than 2 elements, then it uses the recursive case. For the base case, this method 
   * will swap the first element with the last element. For the recursive case, the method will cut the array into two
   * smaller arrays and then send the task to the merge method, which is also located in this class.
   */
  private static void recursiveSort(double[] a, int from, int to)
  {
    if (to - from < 2)       // Base case: 1 or 2 elements
    {
      if (to > from && a[to] < a[from])
      {
        // swap a[to] and a[from]
        double aTemp = a[to]; a[to] = a[from]; a[from] = aTemp;
      }
    }
    else                     // Recursive case
    {
      int middle = (from + to) / 2;
      recursiveSort(a, from, middle);
      recursiveSort(a, middle + 1, to);
      merge(a, from, middle, to);
    }
  }

  
  /*
   * This method sorts out the elements from the two arrays created and merge the elements together by keeping it in
   * ascending order. First, it checks whether the first element from the first array or the first element from the 
   * second array is larger, which is then placed in the "temp" array. If one of the arrays is emptied out, all the
   * elements of the other array will then be taken and included at the end of the "temp" array to store the elements
   * in ascending order. The array "temp" is then stored in the "a" array.
   */
  private static void merge(double[] a, int from, int middle, int to)
  {
    int i = from, j = middle + 1, k = from;

    while (i <= middle && j <= to)
    {
      if (a[i] < a[j])
      {
        temp[k] = a[i];  
        i++;
      }
      else
      {
        temp[k] = a[j];
        j++;
      }
      k++;
    }

    while (i <= middle)
    {
      temp[k] = a[i];     
      i++;
      k++;
    }

    while (j <= to)
    {
      temp[k] = a[j];     
      j++;
      k++;
    }

    for (k = from; k <= to; k++)
      a[k] = temp[k];
  }
}
