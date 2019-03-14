import java.util.*;
public class Quick {
  /*return the value that is the kth smallest value of the array.
 */
 public static int quickselect(int []data, int k){
   if (k >= data.length || k < 0) throw new ArrayIndexOutOfBoundsException(); //checks to see if k is a valid index
   int start = 0, end = data.length-1, pivot = partition(data, start, end);  //sets up initial values to run partition
	 while (k != pivot) { //while k is not = to pivot index, run the partition method, update the start/end
      pivot = partition(data, start, end);
			if (k < pivot) end = pivot - 1;
			else start = pivot + 1;
	 }
   return data[k]; //returns k when = to pivot index
 }
 public static int partition (int [] data, int start, int end){
    if (start == end) return start;
    Random r = new Random();
    int halfpass = 0;
    int median = 0;
    if ((data[start] <= data[end] && data[start] >= data[start + (end - start)/2]) || (data[start] >= data[end] && data[start] <= data[start + (end - start)/2])) median = start;
    if ((data[end] <= data[start] && data[end] >= data[start + (end - start)/2]) || (data[end] >= data[start] && data[end] <= data[start + (end - start)/2])) median = end;
    if ((data[start + (end - start)/2] <= data[end] && data[start + (end - start)/2] >= data[start]) || (data[start + (end - start)/2] >= data[end] && data[start + (end - start)/2] <= data[start])) median = start + (end - start)/2;
    int pivotIndex = median;
    //int pivotIndex = new Random().nextInt(end - start + 1) + start; //chooses initial pivot index randomly in the "current" data set
    int pivot = data[pivotIndex];
    swap(data, start, pivotIndex);  //places pivot in the beginning
    pivotIndex = start;
    while (end > start) { //loops through "current" data set to reorganize the values based on being > or < than pivot
      if (data[start] > pivot) {
          swap(data, start, end);
          end--;
        }
      else {start++;}
    }
    // returns the pivot index based on pivot and start
      if (data[start] < pivot) {
        swap(data, start, pivotIndex);
        return start;
      }
      else {
        swap(data, start - 1, pivotIndex);
        return start - 1;
      }
  }
  public static void swap(int[] d, int a, int b) {  //helper method to swap values in the data array
    int temp = d[a];
    d[a] = d[b];
    d[b] = temp;
  }
  /*Modify the array to be in increasing order.
 */
 public static void quicksort(int[] data) {
   qsH(data, 0, data.length - 1);
 }
 private static void qsH(int[] data, int start, int end) {
   if (end > start) {
      int i = partition(data, start, end);
      qsH(data, start, i - 1);
      qsH(data, i+1, end);
   }
 }

//   private int[] partitionDutch(int[] data, int lo, int hi){
//     int median = 0;
//     if ((data[lo] <= data[hi] && data[lo] >= data[data.length/2]) || (data[lo] >= data[hi] && data[lo] <= data[data.length/2]))
//     int[] medianList = {data[lo], data[hi], data[data.length/2]};
//
//     int pivotIndex = new Random().nextInt(hi - lo + 1); //chooses initial pivot index randomly in the "current" data set
//     int pivot = data[pivotIndex];
//     swap(data, 0, pivotIndex);  //places pivot in the beginning
//     while (hi > lo) { //loops through "current" data set to reorganize the values based on being > or < than pivot
//       if (data[lo] > pivot) {
//         swap(data, lo, hi);
//         hi--;
//       }
//       else if(data[lo] < pivot) {
//         swap(data, 0, lo);
//
//       }
//       else lo++;
//     }
//     //return an array [lt,gt]
// }
}
