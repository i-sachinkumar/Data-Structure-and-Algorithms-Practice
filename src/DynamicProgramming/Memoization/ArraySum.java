package DynamicProgramming.Memoization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArraySum {
    public static void main(String[] args) {

        // fast canSum
        System.out.println(fastCanSum(7, new int[]{2,3,4,7}, new HashMap<>()));
        System.out.println(fastCanSum(300,new int[]{7,14}, new HashMap<>()));

        System.out.println("*******************************************************************************");

        // slow can sum
        System.out.println(slowCanSum(7, new int[]{2,3,4,7}));
        //System.out.println(slowCanSum(300, new int[]{7,14}));

        System.out.println("********************************************************************************");

        //fast
        System.out.println(fastHowSum(7, new int[]{2,3,4,7}, new HashMap<>()));
        System.out.println(fastHowSum(300, new int[]{7,14}, new HashMap<>()));

        System.out.println("********************************************************************************");

        //slow
        System.out.println(slowHowSum(7, new int[]{2,3,4,7}));
        //System.out.println(slowHowSum(300, new int[]{7,14}));


        System.out.println("********************************************************************************");
        //fast
        System.out.println(fastBestSum(7, new int[]{2,3,4,7}, new HashMap<>()));
        System.out.println(fastBestSum(17, new int[]{2,3, 5,9,8,1,4,7}, new HashMap<>()));
        System.out.println(fastBestSum(300, new int[]{7,14}, new HashMap<>()));


        System.out.println("********************************************************************************");
        //slow
        System.out.println(slowBestSum(7, new int[]{2,3,4,7}));
        System.out.println(slowBestSum(17, new int[]{2,3, 5,9,8,1,4,7}));
        System.out.println(slowBestSum(300, new int[]{7,14}));

        String s = "ebvvjejv.f3nvjn.eeen";
        String[] words = s.split("[.]");

    }

    // check if sum of any num of element result to k
    // an element can be repeated infinitely to meet the sum = k if possible
    // otherwise return false

    // slow
    static boolean slowCanSum(int k, int[] arr){
        if(k == 0) return true;
        if(k < 0) return false;

        for (int j : arr) {
            if (slowCanSum(k - j, arr)) return true;
        }

        return false;
    }

    //fast
    static boolean fastCanSum(int k, int[] arr, Map<Integer, Boolean> memo){
        if(k == 0) return true;
        if(k < 0) return false;
        if(memo.containsKey(k)) return memo.get(k);

        for (int j : arr) {

            if (fastCanSum(k - j, arr, memo)) {
                memo.put(k, true);
                return true;
            } else memo.put(k, false);
        }

        memo.put(k, false);
        return false;
    }

    static List<Integer> slowHowSum(int k, int[] arr){
        if(k == 0) return new ArrayList<>();
        if(k < 0) return null;

        for (int j : arr) {
            List<Integer> result = slowHowSum(k - j, arr);
            if (result != null) {
                result.add(j);
                return result;
            }
        }

        return null;
    }

    //fast howSum
    static List<Integer> fastHowSum(int k, int[] arr, Map<Integer, List<Integer>> memo){
        if(k == 0) return new ArrayList<>();
        if(k < 0) return null;
        if(memo.containsKey(k)) return memo.get(k);

        for (int j : arr) {
            List<Integer> result = fastHowSum(k - j, arr, memo);
            if (result != null) {
                result.add(j);
                memo.put(k, result);
                return result;
            }
        }

        memo.put(k, null);
        return null;
    }




    //slow
    static List<Integer> slowBestSum(int k, int[] arr){
        if(k == 0) return new ArrayList<>();
        if(k < 0) return null;

        List<Integer> shortest = null;

        for (int j : arr) {
            List<Integer> result = slowBestSum(k - j, arr);
            if (result != null) {
                result.add(j);
                if(shortest == null || shortest.size() > result.size()){
                    shortest = result;
                }
            }
        }

        return shortest;
    }

    //fast
    static List<Integer> fastBestSum(int k, int[] arr, Map<Integer, List<Integer>> memo){
        if (memo.containsKey(k) && memo.get(k) != null) return new ArrayList<>(memo.get(k));
        else if(memo.containsKey(k)) return null;
        if(k == 0) return new ArrayList<>();
        if(k < 0) return null;


        List<Integer> shortest = null;

        for (int j : arr) {
            List<Integer> result = fastBestSum(k - j, arr, memo);
            if (result != null) {
                result.add(j);
                if(shortest == null || shortest.size() > result.size()){
                    shortest = new ArrayList<>(result);
                }
            }
        }
        if(shortest != null){
            List<Integer> s = new ArrayList<>(shortest);
            memo.put(k,s);
            return shortest;
        }

        memo.put(k, null);
        return null;
    }

}
