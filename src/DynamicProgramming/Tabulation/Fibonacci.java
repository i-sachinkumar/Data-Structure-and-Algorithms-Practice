package DynamicProgramming.Tabulation;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(8));
    }

    public static int fibonacci(int n){
        int[] dp = new int[n+1];
        dp[1] = 1;

        for(int i = 0; i < n+1; i++){
            if(i + 1 < n+1) dp[i+1] += dp[i];
            if(i + 2 < n+1) dp[i+2] += dp[i];
        }

        return dp[n];
    }
}
