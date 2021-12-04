package Hackerrank;

import java.util.*;

public class NonDivisibleSubset {
    public static void main(String[] args) {

        List<Integer> set = new ArrayList<>(List.of(10, 19, 12, 10, 24, 25, 22));

        System.out.println(nonDivisibleSubset(4,set));

    }

    static int nonDivisibleSubset(int k , List<Integer> s){

        Set<Integer> set = new HashSet<>(s);
        s.clear();

        int count = 0;

        int[] freq = new int[k];

        for(Integer each: set){
            s.add(each%k);
            freq[each%k]++;
        }

        if(freq[0] > 0) count++;
        if(k%2==0 && freq[k/2]>0) count++;
        for(int i = 1 ; 2*i < k ; i++){
            count += Math.max(freq[i], freq[k-i]);
        }

        return count;
    }


//    static void permute(List<Integer> s, int l , int r, List<List<Integer>> subsets){
//        if(l ==r) subsets.add(s);
//
//        for(int i = l ; i<= r ; i++){
//
//            swap(s, i, l);
//
//            permute(s, l+1, r,subsets);
//
//            swap(s, i, l);
//        }
//    }
//
//
//    static int add(List<Integer> s){
//        int sum = 0;
//        for (Integer integer : s) {
//            sum += integer;
//        }
//        return sum;
//    }
//
//    static void swap(List<Integer> s, int i, int j){
//        int temp = s.get(i);
//        int temp1 = s.get(j);
//        s.set(i, temp1);
//        s.set(j, temp);
//    }
}
