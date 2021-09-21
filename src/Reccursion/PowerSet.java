package Reccursion;

import java.util.*;

/**
 * Question
 *
 *
 * Given a string S find all possible subsequences of the string in lexicographically-sorted order.
 *
 * Example 1:
 *
 * Input : str = "abc"
 * Output: a ab abc ac b bc c
 * Explanation : There are 7 substrings that
 * can be formed from abc.
 * Example 2:
 *
 * Input: str = "aa"
 * Output: a a aa
 * Explanation : There are 3 substrings that
 * can be formed from aa.
 * Your Task:
 * You don't need to read ot print anything.
 * Your task is to complete the function AllPossibleStrings()
 * which takes S as input parameter and returns a list of all possible
 * substrings(non-empty) that can be formed from S in lexicographically-sorted order.
 *
 *
 * Expected Time Complexity: O(2n) where n is the length of the string
 * Expected Space Complexity : O(n * 2n)
 */

public class PowerSet {
    public static void main(String[] args) {

        List<String> l = AllPossibleStrings("abc");
        for (String s : l) {
            System.out.print(s + "  ");
        }

        System.out.println();


        permute_and_print_substring("abc",0);
    }

    public static List<String> AllPossibleStrings(String s)
    {
        List<String> list = new ArrayList<>();
        AllPossibleStrings(s, list, 0, "");
        //Collections.sort(list);
        return list;
    }

    public static void AllPossibleStrings(String s, List<String> list, int l, String temp){
        if(l == s.length()){
            if(!Objects.equals(temp, "")) list.add(temp);
            return;
        }

        AllPossibleStrings(s, list, l+1 , temp + s.charAt(l));

        AllPossibleStrings(s, list, l+1 , temp);

    }

    public static void permute_and_print_substring(String s, int j){
        if(j == s.length()){
            System.out.print(s+ "  ");
            return;
        }
        for(int i = j ; i < s.length(); i++ ) {
            s = swapChar(s, i, j);
            permute_and_print_substring(s,j + 1);
            s = swapChar(s, i, j);
        }
    }

    public static String swapChar(String s, int i, int j){
        char[] c = s.toCharArray();
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
        return String.valueOf(c);
    }
}
