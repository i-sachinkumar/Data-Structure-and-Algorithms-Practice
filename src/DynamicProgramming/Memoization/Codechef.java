package DynamicProgramming.Memoization;

/* package codechef; // don't place package name! */
/**
 * Question: (https://www.codechef.com/problems/MODULO3?itm_medium=potd&itm_campaign=potd)
 */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(solve(a,b, new HashMap<>() , new HashSet<>()));
        }
    }

    static int solve(int a, int b, Map<String, Integer> memo, Set<String> reps){
        if(a%3 == 0 || b%3 == 0) return 0;
        String key = a + "," + b;
        if( memo.containsKey(key)) return memo.get(key);
        if(!reps.add(key)) return 10000;


        int result1;
        if(Math.abs(a-b) == a) {
            result1 = 100000;
        }
        else {
            result1 = solve(Math.abs(a-b), b, memo, reps)+1;
        }
        memo.put(key, result1);

        int result2;
        if(Math.abs(a-b) == b) result2 = 100000;
        else result2 = solve(a, Math.abs(a-b), memo, reps)+1;
        memo.put(key,result2);

        int result = Math.min(result1, result2);
        memo.put(key, result);
        return result;
    }
}
