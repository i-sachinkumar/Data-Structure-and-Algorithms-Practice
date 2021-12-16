package daily_test.Dec15;


// Qs Link = {https://leetcode.com/problems/maximum-subarray/}

public class MaxSumSubArray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums) {
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

        if(maxNum <= 0) return maxNum;
        return maxSum;
    }

}
