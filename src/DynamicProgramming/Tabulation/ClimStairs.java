package DynamicProgramming.Tabulation;

// Qs. Link = {https://leetcode.com/problems/climbing-stairs/}

public class ClimStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(6));
    }

    public static int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        if(1 < n+1)dp[1] = 1;
        if(2 < n+1)dp[2] = 1;

        for(int i = 0 ; i < n+1; i++){
            if(i+1 < n+1) dp[i+1] += dp[i];
            if(i+2 < n+1) dp[i+2] += dp[i];
        }
        return dp[n];
    }

}
