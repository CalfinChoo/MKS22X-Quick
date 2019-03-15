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
      // int i = partition(data, start, end);
      // qsH(data, start, i - 1);
      // qsH(data, i+1, end);
      int[] i = partitionDutch(data, start, end);
      qsH(data, start, i[0] - 1);
      qsH(data, i[1] + 1, end);
   }
 }

  private static int[] partitionDutch(int[] data, int lo, int hi){
    if (lo == hi) return new int[] {lo, lo + 1};
    int median = 0;
    if ((data[lo] <= data[hi] && data[lo] >= data[lo + (hi - lo)/2]) || (data[lo] >= data[hi] && data[lo] <= data[lo + (hi - lo)/2])) median = lo;
    if ((data[hi] <= data[lo] && data[hi] >= data[lo + (hi - lo)/2]) || (data[hi] >= data[lo] && data[hi] <= data[lo + (hi - lo)/2])) median = hi;
    if ((data[lo + (hi - lo)/2] <= data[hi] && data[lo + (hi - lo)/2] >= data[lo]) || (data[lo + (hi - lo)/2] >= data[hi] && data[lo + (hi - lo)/2] <= data[lo])) median = lo + (hi - lo)/2;
    int pivotIndex = median;
    int pivot = data[pivotIndex];
    swap(data, lo, pivotIndex);  //places pivot in the lo

    int lt = lo, i = lo, gt = hi;
    while (i <= gt) { //loops through "current" data set to reorganize the values based on being > or < than pivot
      if (data[i] > pivot) { //if value at index > pivot value, swap to the gt (end) and decrement
        swap(data, i, gt);
        gt--;
      }
      else if(data[i] < pivot) { //if value is < than pivot instead, swap with lt and increment lt and index
        swap(data, i, lt);
        lt++; i++;
      }
      else i++;  // if value == pivot, skip over it
    }
    //return an array [lt,gt]
    return new int[] {lt, gt}; //returns array [lt, gt]
   }
}
