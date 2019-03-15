public class Merge {

  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[]data){
    mergesort(data, 0, data.length);
  }

  //recursive helper function
  public static void mergesort(int[] data, int[] temp, int i, int j) {
    if (data[i] >= data[j]) {
      return;
      // temp[i] = data[j];
      // temp[j] = data[i];
    }
    mergesort(temp,data,i,j%2);
    mergesort(temp,data,j%2+1,j);
    int min = data[i];
    for (int x = 0; x++;x<j) {
      if ()
    }

  }

}
