package DynamicProgramming.Memoization;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


/**
 * Given a TargetString and an array of Strings.
 * Check whether Target String can be made by combination of words from array
 *
 */

public class CanConstruct {
    public static void main(String[] args) {

        // fast
        System.out.println(canConstruct(
                "abcdef",
                new String[]{
                        "ab",
                        "cd",
                        "abc",
                        "bcd",
                        "def",
                        "feg"},
                new HashMap<>()
        ));
        System.out.println(canConstruct(
                "eeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[]{
                        "e",
                        "ee",
                        "eee",
                        "eeee"},
                new HashMap<>()));



        // slow
        System.out.println(canConstruct("abcdef", new String[]{"ab", "cd", "abc", "bcd", "def", "feg"}));
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[]{
                        "e",
                        "ee",
                        "eee",
                        "eeee"}));




        // fast
        System.out.println(countConstruct(
                "abcdef",
                new String[]{"ab", "cd", "abc", "bcd", "def", "feg"},
                new HashMap<>()));
        System.out.println(countConstruct(
                "eeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[]{
                        "e",
                        "ee",
                        "eee",
                        "eeee"},
                new HashMap<>()));



        // slow
        System.out.println(countConstruct("abcdef", new String[]{"ab", "cd", "abc", "bcd", "def", "feg"}));
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[]{
                        "e",
                        "ee",
                        "eee",
                        "eeee"}));

    }

    public static boolean canConstruct(String targetString, String[] wordBank) {
        if (targetString.equals("")) return true;

        for (String word : wordBank) {
            if (word.equals(targetString.substring(0, Math.min(word.length(), targetString.length())))
                    && canConstruct(targetString.substring(word.length()), wordBank))
                return true;
        }

        return false;
    }


    public static boolean canConstruct(String targetString, String[] wordBank, Map<String,Boolean> memo) {
        if (targetString.equals("")) return true;
        if (memo.containsKey(targetString)) return memo.get(targetString);

        for (String word : wordBank) {
            if (word.equals(targetString.substring(0, Math.min(word.length(), targetString.length())))
                    && canConstruct(targetString.substring(word.length()), wordBank, memo)){
                memo.put(targetString, true);
                return true;
            }

        }

        memo.put(targetString, false);
        return false;
    }


    public static int countConstruct(String target, String[] wordBank){
        if(target.equals("")) return 1;

        int totalCount = 0;
        for( String word : wordBank){
            if(target.indexOf(word) == 0){
                totalCount += countConstruct(target.substring(word.length()),wordBank);
            }
        }

        return totalCount;
    }


    //fast
    public static int countConstruct(String target, String[] wordBank, Map<String, Integer> memo){
        if(target.equals("")) return 1;
        if(memo.containsKey(target)) return memo.get(target);

        int totalCount = 0;
        for( String word : wordBank){
            if(target.indexOf(word) == 0){
                totalCount += countConstruct(target.substring(word.length()),wordBank, memo);
            }
        }

        memo.put(target, totalCount);
        return totalCount;
    }


    // TODO "yet to complete"
//    public static List<List<String>> allConstruct(String target, String[] wordBank){
//        if (target.equals("")) return new ArrayList<>(new ArrayList<>());
//
//        List<List<String>> result = new ArrayList<>();
//
//        for(String word : wordBank){
//            if(target.indexOf(word) == 0){
//                if()
//            }
//        }
//    }
}
