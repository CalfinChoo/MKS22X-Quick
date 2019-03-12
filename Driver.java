public class Driver {
  public static void main(String[] args) {
    int[] ary = { 2, 10, 15, 23, 0,  5};  //sorted :  {0,2,5,10,15,23}
    Quick test = new Quick();
    System.out.println(test.quickselect(ary, 2));
  }
}
