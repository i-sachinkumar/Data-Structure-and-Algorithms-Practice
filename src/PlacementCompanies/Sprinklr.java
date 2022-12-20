package PlacementCompanies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

/*
 A river has N checkpoints on left side and M checkpoints on the right side.
 P bridges are built connecting checkpoints across the river. Guards need to be placed on checkpoints,
 a guard can protect all the bridges on which this checkpoint is present.
 There can be more than one guard to protect a single bridge.
 Find the minimum number of guards required to protect all the bridges over the river.

 Example
 If N 4. M=3, P= 4, bridge = [(1, 3),(1, 2),(2, 2).(4. 1)].

 If we place a guard on checkpoint 1 on left side, then we can guard the bridge 1-3 and 1-2.
 If we place a guard on checkpoint 2 on left side, then we can guard the bridge 2-2.
 If we place a guard on checkpoint 4 on left side, then we can guard the bridge 4-1.
 Hence, minimum 3 guards are required to protect all the bridges.
 */
public class Sprinklr {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        int q = sc.nextInt();
        int[][] queries = new int[q][2];
        for(int i = 0 ; i < q ; i++){
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
        }
        int[][] ind_freq = new int[n][2];

        for(int i = 0 ; i < arr.length; i++){
            ind_freq[i][0] = i;
        }
        for(int[] query : queries){
            int l = query[0];
            int r = query[1];
            for(int j = l; j <= r; j++){
                ind_freq[j][1]++;
            }
        }

        Arrays.sort(ind_freq, Comparator.comparingInt(o -> o[1]));
        Arrays.sort(arr);
        int min = 0, max = 0;
        for(int i = 0, j = n-1; i < arr.length; i++, j--){
            min += (arr[i]*ind_freq[j][1]);
        }
        for(int i = 0; i < arr.length; i++){
            max += (arr[i]*ind_freq[i][1]);
        }

        System.out.println(min + " " + max);
    }


//    static void solve(int arr[], int[][] queries){
//        int n = arr.length;
//        int[][] ind_freq = new int[arr.length][];
//        for(int i = 0 ; i < arr.length; i++){
//            ind_freq[i][0] = i;
//        }
//        for(int[] query : queries){
//            int l = query[0];
//            int r = query[1];
//            for(int j = l; j <= r; j++){
//                ind_freq[j][1]++;
//            }
//        }
//
//        Arrays.sort(ind_freq, Comparator.comparingInt(o -> o[1]));
//        Arrays.sort(arr);
//        int min = 0, max = 0;
//        for(int i = 0, j = n-1; i < arr.length; i++, j--){
//            min += (arr[i]*ind_freq[j][1]);
//        }
//        for(int i = 0; i < arr.length; i++){
//            max += (arr[i]*ind_freq[i][1]);
//        }
//    }

    static int[] secondNextGreater(int[] arr, int x){
        int n = arr.length;
        return firstGreater(firstGreater(arr,x), x);
    }

    static int[] secondNextGreater2(int[] arr, int x){
        int n = arr.length;
        boolean[] poppedOnce = new boolean[n];
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i = 1; i < n ; i++){
            int next = arr[i];
            if(!st.empty()){
                int curr_ind = st.peek();
                Stack<Integer> popped = new Stack<>();
                while (arr[curr_ind] + x < next){
                    st.pop();
                    if(poppedOnce[curr_ind]){
                        ans[curr_ind] = next;
                    }
                    else{
                        poppedOnce[curr_ind] = true;
                        popped.push(curr_ind);
                    }
                    if(st.empty()) break;
                    curr_ind = st.peek();
                }
                st.push(i);
                while (!popped.empty()){
                    st.push(popped.pop());
                }
            }
        }
        while (!st.empty()){
            ans[st.pop()] = -1;
        }
        return ans;
    }

    static int[] firstGreater(int[] arr, int x){
        int n = arr.length;
        int[] firstGreater = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i = 1 ; i < n ; i++){
            int next = arr[i];
            if(!st.empty()){
                int curr_ind = st.peek();
                while (arr[curr_ind] >= 0 && next > x + arr[curr_ind]){
                    firstGreater[curr_ind] = next;
                    st.pop();
                    if(st.empty()) break;
                    curr_ind = st.peek();
                }
                st.push(i);
            }
        }
        while (!st.empty()){
            firstGreater[st.pop()] = -1;
        }
        return firstGreater;
    }

    static boolean[] solve(int[] num , int left , int right){
        int n = num.length;
        boolean[] ans = new boolean[n];
        for(int i = 0; i < n; i++){
            if(num[i] % (i+1) == 0){
                ans[i] = (left <= (num[i]/(i+1)) && (num[i]/(i+1)) <= right);
            }
            else ans[i] = false;
        }
        return ans;
    }

//    static boolean solution(int[] arr){
//        int[][] indexes = new int[arr.length][2];
//        int i = 0;
//        for(int el : arr){
//            indexes[i][0] = i;
//            indexes[i][1] = el;
//        }
//    }


    boolean solution(int[] arr) {
        int[] tp = arr.clone();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= arr[i - 1]) {
                String s1 = arr[i - 1] + "";
                String s2 = arr[i] + "";

                int pre = 0;
                if (i > 1) pre = arr[i - 2];
                int t1 = helper(s1, pre);
                int t2 = helper(s2, arr[i - 1]);

                arr[i - 1] = t1;
                tp[i] = t2;

                return check(tp) || check(arr);
            }
        }
        return true;
    }

    int helper(String s, int pre) {
        int tp = Integer.MAX_VALUE;
        if (s.length() == 1) {
            if (Integer.valueOf(s) > pre) return Integer.valueOf(s);
        }
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            char[] ch = c.clone();
            for (int j = 0; j < c.length; j++) {
                //if(i==j) continue;
                char temp = c[i];
                c[i] = c[j];
                c[j] = temp;
                String now = new String(c);

                if (Integer.valueOf(now) > pre) tp = Math.min(tp, Integer.valueOf(now));
                c = ch;
            }
            c = ch;
        }
        return tp == Integer.MAX_VALUE ? -1 : tp;
    }

    boolean check(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= arr[i - 1]) return false;
        }
        return true;
    }
}
