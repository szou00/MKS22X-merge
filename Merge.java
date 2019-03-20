import java.util.Arrays;

public class Merge {

  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[]data){
    int[] temp = new int[data.length];
    mergesort(data, 0, data.length-1);
  }

  //recursive helper function
  public static void mergesort(int[] data, int lo, int hi) {
    if (lo >= hi) {
      // System.out.println("returned");
      return;
    }

    //initializing left array
    int[] beg = new int[data.length-data.length/2];
    for (int i = 0; i < beg.length; i++) {
      beg[i] = data[i];
    }

    //initializing right array
    int[] end = new int[data.length/2];
    for (int i = 0; i<end.length;i++) {
      end[i] = data[i+(data.length-data.length/2)];
    }

    // System.out.print("beg: ");
    // System.out.println(Arrays.toString(beg));
    // System.out.print("end: ");
    // System.out.println(Arrays.toString(end));
    mergesort(beg,0,beg.length-1);
    mergesort(end,beg.length,data.length-1);

    merge(data,beg,end);
  }

  public static void merge(int[] data, int[] beg, int[] end) {
    int b = 0; int e = 0; //keeps track of the indexes in both arrays
    int x = 0;
    // System.out.println("b: " + b + " e: " + e);
    while (b!=beg.length && e != end.length) {
      if (beg[b] <= end[e]) {
        // System.out.println(beg[b] + " " + end[e]);
        data[x] = beg[b];
        b+=1;
        x+=1;
      }
      else {
        data[x] = end[e];
        e+=1;
        x+=1;
      }
    }
    while (b!= beg.length) {
      data[x] = beg[b];
      b+=1;
      x+=1;
      }
    while (e!= end.length) {
      data[x] = end[e];
      e+=1;
      x+=1;
    }
    // System.out.println(Arrays.toString(beg));
    // System.out.println(Arrays.toString(end));
    // System.out.println(Arrays.toString(data));
  }

  public static void main(String[]args){
  System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  int[]MAX_LIST = {1000000000,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long qtime=0;
      long btime=0;
      //average of 5 sorts.
      for(int trial = 0 ; trial <=5; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        Merge.mergesort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    }
    System.out.println();
  }
}

}
