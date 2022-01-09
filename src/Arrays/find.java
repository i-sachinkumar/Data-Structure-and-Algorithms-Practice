package Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class find {
    public static void main(String[] args) {
        int[] a = {Integer.MAX_VALUE, 13, 39, -5, 5, 19, 28, 0, -3000, -3, 1000, 100000, -6, 1800, 180093, 7374, 555, -44, -46, 666};

        System.out.println(time(a,-46));

    }

    static long time(int[] a, int n) {
        long t = System.nanoTime();
        for(int i = 0 ; i < 20000000; i++){
            binarySearch(a, 0, a.length-1, n);
        }

        return (System.nanoTime() - t)/20000000;
    }

    static int binarySearch(int arr[], int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid + 1, r, x);
        }

        // We reach here when element is not present
        // in array
        return -1;
    }


    static List<Integer> l = new ArrayList<>();
    static void combination(int[] a, int index, int r){
        if(index == r)
        System.out.println(l);

        for(int i = 1 ; i < a.length; i++)
        {
            l.add(a[index]);
            combination(a, index+1, i);
        }
    }
}
