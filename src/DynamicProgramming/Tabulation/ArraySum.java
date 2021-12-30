package DynamicProgramming.Tabulation;

import java.util.Arrays;

public class ArraySum {
    public static void main(String[] args) {

        System.out.println(canSum(7, new int[]{4,3,5}));
    }

    public static boolean canSum(int target , int[] nums){

        boolean[] dp = new boolean[target+1];
        dp[0] = true;

        for(int i = 0; i < target+1 ; i++){
            if(dp[i]) {
                for (int num : nums) {
                    if (i + num < target + 1) dp[i+num] = true;
                }
            }
        }

        System.out.println(Arrays.toString(dp));

        return dp[target];
    }
}
