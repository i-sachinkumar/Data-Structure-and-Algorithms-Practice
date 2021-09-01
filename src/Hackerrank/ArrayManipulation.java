package Hackerrank;

/**
 * QUESTION:
 *
 * Hackerrank question link
 *
 *     {https://www.hackerrank.com/challenges/crush/problem}
 *
 *     Array Manipulation Question on Hackerrank
 *
 *     Starting with a 1-indexed array of zeros and a list of operations,
 *     for each operation add a value to each the array element between
 *     two given indices, inclusive. Once all operations have been performed,
 *     return the maximum value in the array.
 */

import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'arrayManipulation' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static long arrayManipulation(int n, List<List<Integer>> queries) {

        // this is the solution code
        long[] arr = new long[n];
        long max = 0;
        for (List<Integer> query : queries) {
            arr[query.get(0) - 1] += query.get(2);

            if (query.get(1) < n) {
                arr[query.get(1)] -= query.get(2);
            }
        }

        long sum = 0;
        for(int i = 0 ; i < n ; i++){
            sum += arr[i];
            if(max < sum) max = sum;
        }
        return max;
    }

}

public class ArrayManipulation {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int m = sc.nextInt();

        List<List<Integer>> queries = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            List<Integer> q = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                int en = sc.nextInt();
                q.add(en);
            }

            queries.add(q);

        }

        long result = Result.arrayManipulation(n, queries);
        System.out.println(result);
    }
}
