package daily_test.Dec13;

import java.util.Arrays;

// Qs link = {}

public class FirstMissingPositiveInteger {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1, 2, 3, 4, 5, 6, 7, 7 ,8,9,11,12}));
    }

    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int small = 0;
        int i = 0;
        for(; i < nums.length ; i++){
            if(nums[i] > 0){
                small = nums[i];
                break;
            }
        }
        if(small > 1) return 1;
        i++;
        for( ; i < nums.length ; i++){
            if(small == nums[i]);
            else if(small+1 == nums[i]) small++;
            else break;
        }
        return small+1;
    }
}
