package DynamicProgramming.Tabulation;

import java.util.ArrayList;

public class ArraySum {
    public static void main(String[] args) {

        System.out.println(canSum(7, new int[]{4,3,5}));
        System.out.println(howSum(7, new int[]{4,3,5}));

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

        return dp[target];
    }

    public static ArrayList howSum(int target, int[] nums){
        ArrayList[] dp = new ArrayList[target+1];
        dp[0] = new ArrayList<>();

        for(int i = 0 ; i < target+1; i++){
            if(dp[i] != null){
                for (int num : nums){
                    if(i + num < target+1){
                        ArrayList<Integer> curr = new ArrayList<>(dp[i]);
                        curr.add(num);
                        dp[i+num] = curr;
                    }
                }
            }
        }
        return dp[target];
    }
}
