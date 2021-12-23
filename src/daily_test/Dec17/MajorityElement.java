package daily_test.Dec17;

// Qs Link = {https://leetcode.com/problems/majority-element/}

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2,2,4,6,4,1,1,1,1,5,1,1,4,1,1,1,1,5,1};

        System.out.println(majorityElement1(nums));
    }



    // 99.9 % faster
    public static int majorityElement1(int[] nums) {
        int max = nums[0];
        int count = 0;

        for(int i : nums){
            if(max == i) count++;
            else count--;
            if(count == 0){
                max = i;
                count = 1;
            }
        }
        return max;
    }

    // 47 % faster
    public static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    // 14% faster
    public static int majorityElement3(int[] nums) {

        Map<Integer, Integer> m = new HashMap<>();

        int n = nums.length;

        for (int num : nums) {
            if (m.containsKey(num)) {
                int prev = m.get(num);
                m.put(num, prev + 1);
                if (prev + 1 > n / 2) return num;
            }
            else {
                m.put(num, 1);
            }
        }
        return nums[0];
    }
}
