package DynamicProgramming.Memoization;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    public static void main(String[] args) {

        //fast fibonacci result
        System.out.println(fastFibonacci(50, new HashMap<>()));


        //slow fibonacci result
        System.out.println(slowFibonacci(50));
    }

    public static long slowFibonacci(int n){
        if( n == 1) return 1;
        if( n == 2) return 1;

        return slowFibonacci(n-1) + slowFibonacci(n-2);
    }
    /*
                                [6]
                              /    \
                            [4]     [5]
                           /   \    /   \
                         [3]   [2] [4]  [3]
                          /\    /\  /\   /\.....

                          some node is repeating, so our recursion fn will also repeat to calculate
                          same value which it has already calculated
*/

    // memoization
    public static long fastFibonacci(int n , Map<Integer, Long> memo){
        if( n == 1) return 1;
        if( n == 2) return 1;
        if( memo.containsKey(n)) return memo.get(n);

        memo.put(n, fastFibonacci(n-1, memo) + fastFibonacci(n-2, memo));
        return memo.get(n);
    }
}
