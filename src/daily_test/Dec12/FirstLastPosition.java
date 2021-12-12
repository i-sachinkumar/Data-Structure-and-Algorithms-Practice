package daily_test.Dec12;

import java.util.Arrays;

/************ Question ***************************************************************************************************
 *
 * link = {https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/}
 *
 *
 * Given an array of integers nums sorted in non-decreasing order,
 * find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 *
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 * Example 3:
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 */

public class FirstLastPosition {
    public static void main(String[] args) {
        int[] a = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(a, target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];

        int ind = index(nums, target, 0, nums.length -1);

        int start = ind;
        int end = ind;

        if(ind != -1){
            for(int i = ind ; i < nums.length ; i++){
                if(nums[i] == target) end = i;
                else break;
            }
            for(int i = ind ; i >= 0 ; i--){
                if(nums[i] == target) start = i;
                else break;
            }
        }

        ans[0] = start;
        ans[1] = end;
        return ans;
    }


    public static int index(int[] arr, int x, int l , int r){
        if (r >= l) {
            int mid = l + (r - l)/2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return index(arr, x, l, mid-1);

            // Else the element can only be present
            // in right subarray
            return index(arr, x, mid+1, r);
        }

        // We reach here when element is not present
        // in array
        return -1;
    }
}
