package daily_test.Dec12;

/************* Questions *******************************************************************************************************************
 *
 * link = {https://leetcode.com/problems/remove-duplicates-from-sorted-array/}
 *
 *
 * Given an integer array nums sorted in non-decreasing order,
 * remove the duplicates in-place such that each unique element appears only once.
 * The relative order of the elements should be kept the same.
 *
 * Since it is impossible to change the length of the array in some languages,
 * you must instead have the result be placed in the first part of the array nums.
 * More formally, if there are k elements after removing the duplicates,
 * then the first k elements of nums should hold the final result.
 * It does not matter what you leave beyond the first k elements.
 *
 * Return k after placing the final result in the first k slots of nums.
 *
 * Do not allocate extra space for another array.
 * You must do this by modifying the input array in-place with O(1) extra memory.
 */

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] a = {0,0,1,1,1,2,2,3,3,4};
        int unique_length = removeDuplicates(a);
        for (int i = 0 ; i < unique_length ;i++) {
            System.out.print(a[i] + " ");
        }
    }
    public static int removeDuplicates(int[] nums) {
        int front = 1;
        int back = 1;

        while(front < nums.length){
            if(nums[front] != nums[front-1]){
                nums[back] = nums[front];
                back++;
            }
            front++;
        }
        return back;
    }
}
