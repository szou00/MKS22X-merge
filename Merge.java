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
      // if (data[lo] > data[hi]) {
      //   int temp = data[hi];
      //   data[hi] = data[lo];
      //   data[lo] = temp;
      // }
    }

    //initializing left array
    int[] beg = new int[data.length/2];
    for (int i = 0; i < beg.length; i++) {
      beg[i] = data[i];
    }

    //initializing right array
    int[] end = new int[data.length-data.length/2];
    for (int i = 0; i<end.length;i++) {
      end[i] = data[i+data.length/2];
    }

    mergesort(beg,0,beg.length-1);
    mergesort(end,beg.length,data.length-1);

    int b = 0; int e = 0; //keeps track of the indexes in both arrays
    int x = 0;
    int[] newary = new int[data.length];
    System.out.println("b: " + b + " e: " + e);
    while (b!=beg.length && e != end.length) {
      if (beg[b] <= end[e]) {
        System.out.println(beg[b] + " " + end[e]);
        newary[x] = beg[b];
        b+=1;
        x+=1;
      }
      else {
        newary[x] = end[e];
        e+=1;
        x+=1;
      }
    }
    while (b!= beg.length) {
      newary[x] = beg[b];
      b+=1;
      }
    while (e!= end.length) {
      newary[x] = end[e];
      e+=1;
    }
    System.out.println(Arrays.toString(newary));
  }
    // if (i>=j) {
    //   return;
    //   // temp[i] = data[j];
    //   // temp[j] = data[i];
    // }
    // mergesort(temp,data,i,j/2);
    // mergesort(temp,data,j/2+1,j);
    // int ic = 0; int jc = j/2+1;int x =0;
    // System.out.println("first array length: " + (j/2+1) + " second: " + (j+1));
    // while (ic != j/2+1) {
    //   System.out.println("ic: " +  ic + " jc: " + jc);
    //   System.out.println(ic == j/2+1);
    //   if (data[ic] >= data[jc]) {
    //     System.out.println("x: " + x);
    //     System.out.println("index of first array: " + ic);
    //     temp[x] = data[ic];
    //     ic+=1;
    //     x+=1;
    //   }
    //   else {
    //     System.out.println("x: " + x);
    //     System.out.println("index of second array: " + ic);
    //     temp[x] = data[jc];
    //     jc+=1;
    //     x+=1;
    //   }
    // }
    // if (ic == j/2+1) {
    //   for (int y = jc;y<j+1;y++) {
    //     temp[x] = data[y];
    //     x+=1;
    //   }
    // }
    // if (jc == j+1) {
    //   for (int y = ic;y<j/2+1;y++) {
    //     temp[x] = data[y];
    //     x+=1;
    //   }
    // }

  public static void main(String args[]) {
    int[] data1 = {38,27,43,3,9,82,10};

    mergesort(data1);
    System.out.println(Arrays.toString(data1));
  }

}
