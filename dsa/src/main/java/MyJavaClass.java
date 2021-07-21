import com.harisewak.dsa.challenges.TestDataKt;

import static com.harisewak.dsa.challenges.TestDataKt.*;

public class MyJavaClass {
    public static void main(String[] args) {
        int size = 2;
        int possibilities = arrSize(size);
        System.out.println("possibilities for array size "+size+" are : "+possibilities);
    }

    /*
    Merge sort:
    Divide array into sub-arrays until only one element array is left
    Compare merge sub-arrays until all elements are sorted
    * */

    private void mergeSort(int[] arr, int lb, int ub) {
        if (lb == ub) return;
        int mid = (lb+ub) / 2;
        mergeSort(arr, lb, mid);
        mergeSort(arr, mid+1, ub);
//        merge(arr,lb,mid,mid+1,ub);
    }
}