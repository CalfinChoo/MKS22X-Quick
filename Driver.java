// import java.util.*;
public class Driver {
// 	public static void main(String[]args){
//   System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
//   int[]MAX_LIST = {1000000000,500,10};
//   for(int MAX : MAX_LIST){
//     for(int size = 31250; size < 2000001; size*=2){
//       long qtime=0;
//       long btime=0;
//       //average of 5 sorts.
//       for(int trial = 0 ; trial <=5; trial++){
//         int []data1 = new int[size];
//         int []data2 = new int[size];
//         for(int i = 0; i < data1.length; i++){
//           data1[i] = (int)(Math.random()*MAX);
//           data2[i] = data1[i];
//         }
//         long t1,t2;
//         t1 = System.currentTimeMillis();
//         Quick.quicksort(data2);
//         t2 = System.currentTimeMillis();
//         qtime += t2 - t1;
//         t1 = System.currentTimeMillis();
//         Arrays.sort(data1);
//         t2 = System.currentTimeMillis();
//         btime+= t2 - t1;
//         if(!Arrays.equals(data1,data2)){
//           System.out.println("FAIL TO SORT!");
//           System.exit(0);
//         }
//       }
//       System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
//     }
//     System.out.println();
//   }
// }
  public static void main(String[] args) {
    int[] ary = { 2, 10, 15, 23, 0,  0};  //sorted :  {0,2,5,10,15,23}
    int[] ary2 = { 2, 4, 10, 9, 15, 16, 8, 23, 0,  0, 4, 7, 9, 14};
    Quick test = new Quick();
    System.out.println(test.quickselect(ary, 2));
    // test.quicksort(ary2);
    // for (int i : ary2) System.out.println(i);
  }
}
// import java.util.Random;
// public class Driver{
// 	public static void fillRandom(int[] data){
// 	    Random r = new Random();
// 	    int index = 0;
// 	    for(int i = 0; i < data.length; i++){
// 	      data[i] =  i; //r.nextInt(data.length); fills with random numbers
// 	    }
// 	    for (int i = 0; i < data.length; i++){
// 	      int copy = data[i];
// 	      int rand = r.nextInt(data.length);
// 	      data[i] = data[rand];
// 	      data[rand] = copy;
// 	    }
// 	 }
//    public static void insertionSort(int[] data) {
//      for (int i = 1; i < data.length;i++) {
//        int current = data[i];
//        int tempI = i;
//        while (tempI > 0 && current < data[tempI-1]) {
//          data[tempI] = data[tempI-1];
//          tempI--;
//        }
//        data[tempI] = current;
//      }
//    }
// 	public static void printArray(int[] data){
// 		String out = "[";
// 		for(int i : data){
// 			out+=i;
// 			if (i != data[data.length-1]){
// 				out+=", ";
// 			}
// 		}
// 		System.out.println(out+"]");
// 	}
// 	public static void main(String[] args){
// 		Random r = new Random(); int sucesses = 0;
// 		int tests = 401; System.out.println("testing array sizes 1-400 having numbers from 0-n, asking for a random smallest int. (arrays do not contain duplicates)");
// 		for (int i = 1; i < tests; i++){
// 			int[] data = new int[i];
// 			int select = i <= 1 ? 0 : r.nextInt(i);
// 			fillRandom(data);
// 			//printArray(data);                                            |
// 			int result = Quick.quickselect(data, select); //sucess message V
// 			if (result == select) {++sucesses;}//System.out.println("your array of size "+i+" sucessfully found the "+select+"th smallest one"); ++sucesses;}
// 			else {
// 				if (data.length < 40) {System.out.print("final Array: "); printArray(data);System.out.println();}
// 				System.out.println("Uh Oh, your array of size "+i+" DID NOT find the "+select+"th smallest one. It returned " + result +" instead of " + select);
// 			}
// 		}
// 		System.out.println("******************************************");
// 		//System.out.println("***testing with duplicates in the array***");
// 		//tests++; int[] data = new int[10000];
// 		//for (int i = 0; i < 100; i++){data[i] = r.nextInt(2);} Quick.quickselect(data,500); Quick.quickselect(data,99);
// 		//if (Quick.quickselect(data,0) == 0){++sucesses;} //chance of this driver failing here ;)
// 		//else {System.out.println("uh oh a large array of ones and zeros did not work");}
// 		System.out.println("******************************************");
//
// 		System.out.println("You have had " + sucesses + " sucesses and " + (tests-sucesses-1) + " failures.");
// 		System.out.println( (sucesses == tests-1 ? "CONGRATULATIONS!!!" : "Uh Oh")+" Thats " + (sucesses / (tests-1.0)) * 100 + "% sucess rate.");
// 		if (sucesses <= tests-100) {System.out.println("Yikes!!! Maybe he won't test some of those cases right?");}
// 		else if (sucesses < tests-1) {System.out.println("Maybe if you compile and run again it will work.");}
//     System.out.println("******************************************");
//     System.out.println("TESTING QUICKSORT");
//     sucesses = 0;
//     for (int i = 1; i < tests; i++){
//       int[] data1 = new int[i];
//       fillRandom(data1);
//       Quick.quicksort(data1);
//       int[] answer1 = new int[i];
//       for (int j = 0;j < i;j++) {
//         answer1[j] = data1[j];
//       }
//       insertionSort(answer1);
//       boolean status = true;
//       for (int k = 0;k < i;k++) {
//         if (data1[k] != answer1[k]) {
//           status = false;
//         }
//       }
//       //printArray(data1);
//       //printArray(answer1);
//       if (status == true) {
//         sucesses++;
//       }
//     }
//     System.out.println("You have had " + sucesses + " sucesses and " + (tests-sucesses-1) + " failures.");
//     System.out.println( (sucesses == tests-1 ? "CONGRATULATIONS!!!" : "Uh Oh")+" Thats " + (sucesses / (tests-1.0)) * 100 + "% sucess rate.");
//   	}
//   }
