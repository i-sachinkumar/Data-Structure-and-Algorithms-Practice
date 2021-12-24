package Hackerrank;

import java.math.BigInteger;

public class BigModifiedFibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacciModified(0, 1, 10));
    }

    public static BigInteger fibonacciModified(int t1, int t2, int n) {
        if (n == 1) return new BigInteger(String.valueOf(t1));
        if (n == 2) return new BigInteger(String.valueOf(t2));

        return fibonacciModified(t1, t2, n-1).multiply(fibonacciModified(t1, t2, n-1)).add(fibonacciModified(t1, t2, n-2));
    }
}
