/**
 * This is a client class of Benchmarks.java of the Benchmarks program. This class carries out the process of Quicksort,
 * where it sorts out each values in the array that is taken in to ascending order by taking the array and picking a
 * pivot, which will be the marker. The class will then start incrementing from the left side and decrementing from the
 * right side and swap values and swap with the pivot if necessary to sort the array in ascending order. Once the sorting
 * is complete, the class will store the sorted elements in the original array and return the array to the Benchmarks 
 * class, where it will calculate the time taken.
 * 
 * Modified by Sharjil Mohsin
 * On May 2nd, 2017  
 * Template provided by N. Yhard, created by Maria and Gary Litvin
 * Version 1.0.0
 */
public class Quicksort
{

  /*
   * This method will take the array that is taken in and pass it to the "recursiveSort" method within this class. It
   * will pass the array, the integer 0, as well as the last element in the array.
   */
  public static void sort(double[] a)
  {
    recursiveSort(a, 0, a.length - 1);
  }

  
  /*
   * This method will carry out the Quicksort of the array. First, it will pick a pivot. Then the method will start 
   * from both ends of the array and compare that value to the pivot. If the element on the left is not greater than the
   * pivot, it increments the index on the left side. Similarly, if the element on the right is not less than the pivot,
   * then it decrements the index on the right side. When it reaches a deadlock, both elements are swapped and both 
   * indices are moved. If the left and right side elements meet at a certain position, the pivot is swapped with one of
   * the elements that have been met. This process continues until all the elements in the array are in ascending order. 
   */
  private static void recursiveSort(double[] a, int from, int to)
  {
    if (from >= to)
      return;

    int p = (from + to ) / 2;

    int i = from;
    int j = to;
    while (i <= j)
    {
      if (a[i] <= a[p])
        i++;
      else if (a[j] >= a[p])
        j--;
      else
      {
        swap (a, i, j);
        i++;
        j--;
      }
    }

    if (p < j)        {
      swap (a, j, p);
      p = j;
    }
    else if (p > i)
    {
      swap (a, i, p);
      p = i;
    }

    recursiveSort(a, from, p - 1);
    recursiveSort(a, p + 1, to);
  }

  private static void swap (double[] a, int i, int j)
  {
    double temp = a[i]; a[i] = a[j]; a[j] = temp;
  }
}
