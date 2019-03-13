public class Driver {
  public static void main(String[] args) {
    int[] ary = { 2, 10, 15, 23, 0,  5};  //sorted :  {0,2,5,10,15,23}
    int[] ary2 = { 2, 4, 10, 9, 15, 16, 8, 23, 0,  5};
    Quick test = new Quick();
    //System.out.println(test.quickselect(ary, 2));
    test.quicksort(ary2);
    for (int i : ary2) System.out.println(i);
  }
}
