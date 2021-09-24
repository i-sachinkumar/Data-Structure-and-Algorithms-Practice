package Arrays;

/**
 * Question =>
 *
 * Given an array arr[] of integers of size N and a number X,
 * the task is to find the sum of subarray having
 * maximum sum less than or equal to the given value of X.
 *
 * Example 1:
 *
 * Input: N = 5, X = 11
 * arr[] = {1, 2, 3, 4, 5}
 * Output:  10
 * Explanation: Subarray having maximum
 * sum is {1, 2, 3, 4}.
 *
 * Example 2:
 *
 * Input: N = 5, X = 7
 * arr[] = {2, 4, 6, 8, 10}
 * Output:  6
 * Explanation: Subarray having maximum
 * sum is {2, 4} or {6}.
 *
 *
 * Your Task:
 * This is a function problem. You don't need to take any input,
 * as it is already accomplished by the driver code. You just need
 * to complete the function calculateMaxSumLength() that takes array arr,
 * integer N, and integer X as parameters and returns maximum
 * sum of any subarray that is less than or equal to x.
 *
 *
 *
 * Expected Time Complexity: O(N).
 * Expected Auxiliary Space: O(1).
 */

public class MaxSumSubArray {
    public static void main(String[] args) {

        long[] arr = {1, 2, 3, 4, 5};
        System.out.println(findMaxSubarraySum(arr,5,11));
        long[] arr2 = {2, 4, 6, 8, 10};
        System.out.println(findMaxSubarraySum(arr2,5,11));
    }

    static long findMaxSubarraySum(long[] arr, int N,int X)
    {
        //starting pointer of window
        int start = 0;

        //ending pointer of window
        int end = 0;

        //store subarray sum
        long sum = 0;

        //maximum sum
        long max = -1;

        while(end < N){
            while(sum <= X){
               max = Math.max(sum, max);
               sum += arr[end];
               end++;
            }
            sum -= arr[start];
            start++;
        }

        return max;
    }

}
