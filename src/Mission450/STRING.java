package Mission450;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class STRING {
    public static void main(String[] args) throws IOException {

        //System.out.println(substrCount("abaaca", 2));

        double d = 1.0;
        System.out.println(d%1);

        if(true) return;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];
            int i = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for(String e : br.readLine().trim().split(" ")){
                int lund = Integer.parseInt(e);
                arr[i] = lund;
                if(map.containsKey(lund)) map.replace(lund, map.get(lund) + 1);
                else map.put(lund, 1);
                i++;
            }

            Map<Integer, ArrayList<Integer>> rev = new HashMap<>();
            for(Map.Entry<Integer, Integer> ee : map.entrySet()){
                if(rev.containsKey(ee.getValue())) rev.get(ee.getValue()).add(ee.getKey());
                else{
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(ee.getKey());
                    rev.put(ee.getValue(), l);
                }
            }

            ArrayList<Integer> values = new ArrayList<>(rev.keySet());
            Collections.sort(values);
            System.out.println(values);
            for(int k = values.size()-1 ; k >= 0 ; k--){
                int freq = values.get(k);
                ArrayList<Integer> nums = rev.get(freq);
                Collections.sort(nums);
                for(int e = 0 ; e < nums.size(); e++) {
                    for (int j = 0; j < freq; j++) {
                        if(e < nums.size() -1 && j < freq-1)System.out.println(nums.get(e) + " ");
                        else System.out.println(nums.get(e));
                    }
                }
            }

        }
    }


    public static String largestOddNumber(String num) {
        for(int i = num.length()-1; i>=0 ; i--){
            if((num.charAt(i) - '0')%2 == 1){
                return num.substring(0, i+1);
            }
        }
        return "";
    }

    String longestCommonPrefix(String[] arr, int n){
        // code here
        StringBuilder ans = new StringBuilder();
        for(int i = 0 ; true; i++){
            boolean found = true;
            if(i >= arr[0].length()) return ans.toString();
            char c = arr[0].charAt(i);
            for(String word : arr){
                if(i >= word.length()) return ans.toString();
                found = word.charAt(i) == c;
                if(!found) break;
            }
            if(!found) break;
            ans.append(c);
        }

        if(ans.length() > 0) return ans.toString();
        return "-1";
    }

    //print all subsequence
    void subseq(String s, String ans) {
        // your code here
        if (s.length() == 0) {
            System.out.print(ans + " ");
            return;
        }

        // We add adding 1st character in string
        subseq(s.substring(1), ans + s.charAt(0));

        // Not adding first character of the string
        // because the concept of subsequence either
        // character will present or not
        subseq(s.substring(1), ans);
    }


    static long substrCount(String S, int k) {
        return substrCount3(S, k);// - substrCount2(S, k-1);
    }

    static int substrCount2(String s, int k) {
        int l = 0;
        int r = 0;
        int[] arr = new int[26];
        int ans = 0;

        String ss = "";
        int count = 0;
        while(r < s.length()){
            char c = s.charAt(r);
            if(ss.length() < k){
                ss = ss + c;
                if(arr[c - 'a'] == 0){
                    count++;
                    arr[c - 'a']++;
                }
                r++;
            }
            else{
                if(count < k && arr[c - 'a'] == 0){
                    ss = ss + c;
                    count++;
                    arr[c - 'a']++;
                }
                else if(count == k && arr[c - 'a'] > 0){
                    ss = ss + c;
                }
                else{
                    ss = ss + c;
                    while(l < r && count(arr) > k){
                        char lc = s.charAt(l);
                        arr[lc - 'a']--;
                        ss = ss.substring(1);
                        l++;
                    }
                    r++;
                }
            }
            ans++;
        }
        return ans;
    }

    static int count(int[] arr){
        int c = 0;
        for(int i = 0 ; i < 26 ; i++){
            if(arr[i] > 0) c++;
        }
        return c;
    }


    static int substrCount3(String s, int k) {
        int l = 0;
        int r = 0;
        int[] arr = new int[26];
        int ans = 0;
        int count = 0;

        while(r < s.length()) {
            char c = s.charAt(r);
            if (count < k) {
                if (arr[c - 'a'] == 0) {
                    count++;
                }
                arr[c - 'a']++;
            } else if (arr[c - 'a'] > 0) {
                arr[c - 'a']++;
                r++;
            } else {
                int n = r-l+1;
                ans += (n*(n+1)/2);
                arr[c - 'a']++;
                count++;
                while (l < r && count > k) {
                    char lc = s.charAt(l);
                    arr[lc - 'a']--;
                    l++;
                }
            }
            r++;
        }
        int n = r-l+1;
        ans += (n*(n+1)/2);
        return ans;
    }

    /** TODO
     * https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string3411/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=longest-palindrome-in-a-string
     */

}
