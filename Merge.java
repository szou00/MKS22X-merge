public class Merge {

  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[]data){
    mergesort(data, 0, data.length-1);
  }

  //recursive helper function
  public static void mergesort(int[] data, int[] temp, int i, int j) {
    if (i>=j) {
      return;
      // temp[i] = data[j];
      // temp[j] = data[i];
    }
    mergesort(temp,data,i,j/2);
    mergesort(temp,data,j/2+1,j);
    int ic = 0; int jc = j/2+1;int x =0;
    while (ic != j/2+1 || jc != j+1) {
      if (data[ic] >= data[jc]) {
        temp[x] = data[ic];
        ic+=1;
        x+=1;
      }
      if (data[jc] > data[ic]) {
        temp[x] = data[jc];
        jc+=1;
        x+=1;
      }
    }
    if (ic == j/2+1) {
      for (int y = jc;y<j+1;y++) {
        temp[x] = data[y];
        x+=1;
      }
    }
    if (jc == j+1) {
      for (int y = ic;y<j/2+1;y++) {
        temp[x] = data[y];
        x+=1;
      }
    }
  }

}
