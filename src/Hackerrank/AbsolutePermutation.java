package Hackerrank;

// Qs Link = {https://www.hackerrank.com/challenges/absolute-permutation/problem}

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AbsolutePermutation {
    public static void main(String[] args) {

    }

    public static List<Integer> absolutePermutation(int n, int k) {

        // to store answer in order
        List<Integer> ans = new ArrayList<>();

        // to check the number to add is present or not
        Set<Integer> s = new HashSet<>();


        // 1-based indexing
        for(int i = 1; i <= n ; i++){
            int numToAdd ;

            // either (i-k) or (i+k) will have an absolute difference of k with i

            //check if i-k is in range as well as not present in the ans
            if((i - k) > 0 && s.add(i-k)) numToAdd = i-k;

            //check if i+k is in range as well as not present in the ans
            else if((i + k) <= n && s.add(i+k)) numToAdd = i+k;

            // if at any point now way to move further as none of above condition met,  so return -1
            else return new ArrayList<>(List.of(-1));

            // if anyone of above condition met, 
            ans.add(numToAdd);
        }
        return ans;
    }

}

