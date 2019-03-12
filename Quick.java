import java.util.*;
public class Quick {
  /*return the value that is the kth smallest value of the array.
 */
 public static int quickselect(int []data, int k){
   if (k >= data.length || k < 0) throw new ArrayIndexOutOfBoundsException(); //checks to see if k is a valid index
   int start = 0, end = data.length-1, pivot = partition(data, start, end);  //sets up initial values to run partition
	 while (k != pivot) { //while k is not = to pivot index, run the partition method, update the start/end
      pivot = partition(data, start, end);
			if (k < pivot) end = pivot;
			else start = pivot;
	 }
   return data[k]; //returns k when = to pivot index
 }
 public static int partition (int [] data, int start, int end){
    int pivotIndex = new Random().nextInt(end - start + 1); //chooses initial pivot index randomly in the "current" data set
    int pivot = data[pivotIndex];
    swap(data, 0, pivotIndex);  //places pivot in the beginning
    while (end > start) { //loops through "current" data set to reorganize the values based on being > or < than pivot
      if (data[start] > pivot) {
        swap(data, start, end);
        end--;
      }
      else start++;
    }
    // returns the pivot index based on pivot and start
      if (data[start] < pivot) {
        swap(data, start, 0);
        return start;
      }
      else {
        swap(data, start - 1, 0);
        return start - 1;
      }
  }
  public static void swap(int[] d, int a, int b) {  //helper method to swap values in the data array
    int temp = d[a];
    d[a] = d[b];
    d[b] = temp;
  }
}
