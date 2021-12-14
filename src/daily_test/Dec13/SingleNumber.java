package daily_test.Dec13;

// Qs Link = {https://leetcode.com/problems/single-number/}

import java.util.Arrays;
import java.util.Collections;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {1,2,4,4,1,6,2,9,8,9,8};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        // 0 ^ n = n
        // n ^ n = 0
        // so xor of all paired num will be zero ans xor of zero and single num will be that single num
        int ans = 0;
        for (int num : nums) {
            ans = ans ^ num;
        }
        return ans;
    }
}
