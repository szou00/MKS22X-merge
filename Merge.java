import java.util.Arrays;

public class Merge {

  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[]data){
    int[] temp = new int[data.length];

    //initializing temp data
    for (int i = 0; i < data.length; i++) {
      temp[i] = data[i];
    }
    mergesort(data, temp, 0, data.length-1);
  }

  //recursive helper function
  public static void mergesort(int[] data, int[]temp, int lo, int hi) {
    if (lo >= hi) {
      // System.out.println("returned lo: " +lo);
      return;
    }

    //middle value that splits right and left
    int mid = lo+(hi-lo)/2;

    // System.out.println(mid);

    mergesort(temp,data,lo,mid);
    mergesort(temp,data,mid+1,hi);
    // System.out.println(Arrays.toString(data));
    // System.out.println("lo: " + lo + " hi: " + hi);
    // System.out.println("mid: " + mid);
    // System.out.println("mid+1: " + (mid+1));
    // System.out.println("sort called");

    int b = lo; int e = mid; //keeps track of the indexes in both arrays
    int x = lo;
    // System.out.println(mid);
    while (b!=mid && e != hi) {
      // System.out.println("b: " + b + " x: " + x + " e: " + e);
      if (temp[b] <= temp[e]) {
        data[x] = temp[b];
        b+=1;
        // System.out.println("b: " + b);
        x+=1;
      }
      else {
        data[x] = temp[e];
        e+=1;
        x+=1;
      }
      // System.out.println("b: " + b);
    }
    while (b!= mid) {
      data[x] = temp[b];
      b+=1;
      x+=1;
      }
    while (e!= hi) {
      // System.out.println("b: " + b + " x: " + x + " e: " + e);
      data[x] = temp[e];
      // System.out.println("e: " + e);
      // System.out.println("temp[e]: " + temp[e]);
      e+=1;
      x+=1;
    }
    // System.out.println(Arrays.toString(data));
  }

  public static void main(String args[]) {
    int[] data1 = {38,27,43,3,9,82,12,10};

    mergesort(data1);
    System.out.println(Arrays.toString(data1));
  }

//   public static void main(String[]args){
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
//         Merge.mergesort(data2);
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

}
