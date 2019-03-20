import java.util.Arrays;

public class Merge {

  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[]data){
    int[] temp = new int[data.length];
    mergesort(data, temp, 0, data.length-1);
  }

  //recursive helper function
  public static void mergesort(int[] data, int[]temp, int lo, int hi) {
    if (lo >= hi) {
      // System.out.println("returned");
      return;
    }

    //middle value that splits right and left
    int mid = data.length-data.length/2;

    //initializing left side of the array
    for (int i = 0; i < mid; i++) {
      temp[i] = data[i];
    }

    //initializing right side of the array
    for (int i = mid; i<data.length;i++) {
      temp[i] = data[i+mid];
    }

    mergesort(temp,data,0,mid-1);
    mergesort(temp,data,mid,data.length-1);
    merge(temp,data,mid);
  }

  public static void merge(int[] data, int[] temp,int mid) {
    int b = 0; int e = mid; //keeps track of the indexes in both arrays
    int x = 0;
    while (b!=mid && e != data.length) {
      if (data[b] <= data[e]) {
        temp[x] = data[b];
        b+=1;
        x+=1;
      }
      else {
        temp[x] = data[e];
        e+=1;
        x+=1;
      }
    }
    while (b!= mid) {
      temp[x] = data[b];
      b+=1;
      x+=1;
      }
    while (e!= data.length) {
      temp[x] = data[e];
      e+=1;
      x+=1;
    }
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
