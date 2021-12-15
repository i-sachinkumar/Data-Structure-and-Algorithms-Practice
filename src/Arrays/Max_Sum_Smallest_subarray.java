package Arrays;


import java.util.Scanner;

/**
 * Question
 *
 * Hackerrank link:
 * (https://www.hackerrank.com/contests/week-8-code-hackathon/challenges/largest-sum-contiguous-subarray-5/problem)
 *
 * You will be given an array which consists of  elements.
 *
 * Your task is to calculate the Maximum Sum that can be formed by
 * the sum of contiguous sub-array of any length.
 *
 * If all the elements of given array are negative, print Invalid Input.
 *
 *
 * Input Format
 *
 * First line of input consists of a single digit  denoting the size of array,
 * Next line consists of  space-separated integers which are elements of the array.
 * Constraints
 *
 * Output Format
 *
 * A single line output with the required maximum sum or the message Invalid Input.
 *
 * Sample Input 0
 *
 * 8
 * -2 -3 4 -1 -2 1 5 -3
 * Sample Output 0
 *
 * 7
 * Explanation 0
 *
 * The Largest Possible SubArray with Maximum Sum is 4 -1 -2 1 5 and its sum is 7.
 *
 * Sample Input 1
 *
 * 9
 * -9 -8 -2 -4 -7 -3 -6 -1 -8
 * Sample Output 1
 *
 * Invalid Input
 * Explanation 1
 *
 * Since all the elements are negative, It is Invalid Input.
 */

public class Max_Sum_Smallest_subarray {
    public static void main(String[] args) {

        int[] nums = {-9, -8 ,-2 ,-4 ,-7 ,3, -6 ,-1, -8};

        int currSum = 0;
        int maxSum = 0;

        int maxNum = Integer.MIN_VALUE;

        for (int num : nums) {
            currSum += num;
            maxNum = Math.max(maxNum, num);

            if (currSum <= 0) {
                currSum = 0;
            } else {
                maxSum = Math.max(maxSum, currSum);
            }
        }

        if(maxNum < 0) System.out.println("invalid");
        else System.out.println(maxSum);
    }
}
