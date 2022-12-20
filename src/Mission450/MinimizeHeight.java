package Mission450;
import java.util.*;


/** GFG
 * Given an array arr[] denoting heights of N towers and a positive integer K,
 * you have to modify the height of each tower either by increasing or decreasing them by K only once.
 * After modifying, height should be a non-negative integer.
 * Find out the minimum possible difference of the height of shortest and longest towers
 * after you have modified each tower.
 */

public class MinimizeHeight {
    public static void main(String[] args) {

        int k = 5;
        int n = 10;
        int[] arr = {2, 6, 3, 4, 7, 2, 10, 3, 2, 1};

        System.out.println(getMinDiff(arr, n, k));
    }

    static int getMinDiff(int[] arr, int n, int k) {
        // code here
        if(n == 1) return 0;

        Arrays.sort(arr);

        // curr diff without modification
        int ans = arr[n-1] - arr[0];

        // curr minimum value after sorting
        int tempMin = arr[0];

        // curr max value after sorting
        int tempMax = arr[n-1];

        for(int i = 1 ; i < n ; i++){

            // if it is negative only one way of modification is possible
            if(arr[i] - k >= 0){

                //increasing starting value by k, then decreasing ith value, min val can change, so reassigned
                tempMin = Math.min(arr[0] + k, arr[i] - k);

                //increasing prev value by k, then decreasing last value, max val can change, so reassigned
                tempMax = Math.max(arr[i-1] + k, arr[n-1] - k);

                ans = Math.min(ans, tempMax - tempMin);
            }
        }

        return ans;
    }
}
