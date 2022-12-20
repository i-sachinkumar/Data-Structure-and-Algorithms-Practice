package PlacementCompanies;

/*

IIT BHU
Q1. Rain Tapping
Q2. subset(unbounded knapsack)

Q3. Based on Binary search
Q4. You are given N x-coordinates points and one point (x,y) which is the
    location of company. You are also given one starting coordinate(which will
    be on X-axis only). Now you need to visit all the points including the company
    location such that your total distance is minimised.
    Here distance taken is Euclidean distance.

Q5. Bin packaging Problem
Q6. greedy Scheduling Problem








 */


import java.util.*;

public class JioShavn {
    public static void main(String[] args) {


        System.out.println(saavnQ3(12, new int[]{7,4,6,7,10, 3, 19, 15,20,5,6,8}, 4));

//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        while (n-- > 0){
//            char[] phone = sc.next().toCharArray();
//            StringBuilder ans = new StringBuilder();
//            Stack<Character> st = new Stack<>();
//            for(char c : phone){
//                if((c - '0')%2 == 1) ans.append(c);
//                else st.push(c);
//            }
//            while(!st.empty()){
//                ans.append(st.pop());
//            }
//
//            System.out.println(ans);
//        }











//        System.out.println(shavnQ1(2));
//        shavnQ2(35, 15);
    }


    //  Q1..
    static long trappingWater(int[] arr, int n) {
        int[] before_max = new int[n];  //vvi
        int[] after_max = new int[n];   //vvi
        for(int i = 1 ;i < n ; i++) before_max[i] = Math.max(before_max[i-1], arr[i-1]);
        for(int i = n-2 ;i >= 0 ; i--) after_max[i] = Math.max(after_max[i+1], arr[i+1]);
        long ans = 0;
        for (int i = 0; i < n ; i++){
            int min = Math.min(before_max[i], after_max[i]);
            if(min > arr[i]){
                ans += (min - arr[i]);
            }
        }
        return ans;
    }


    static int knapSack(int N, int W, int[] val, int[] wt){
        int[][] dp = new int[N+1][W+2];
        return  knapSack(N, W, 0, val, wt, dp);
    }
    static int knapSack(int N, int W, int i, int[] val, int[] wt, int[][] dp){
        if(i == N) return 0;
        if(dp[i][W] != 0) return dp[i][W];

        int pick = 0;
        if(W >= wt[i]) pick = val[i] + knapSack(N, W-wt[i], i, val, wt, dp);
        int notPick = knapSack(N, W, i+1, val, wt, dp);
        return dp[i][W] = Math.max(pick, notPick);
    }


    // Q3
    int binarysearch(int[] arr, int n, int k) {
        return binarysearch(arr, 0, n-1, k);
    }
    int binarysearch(int[] arr, int l, int r, int k) {
        if(l > r) return -1;
        int mid = (l+r)/2;
        if(arr[mid] == k) return mid;
        else if(arr[mid] > k) return binarysearch(arr, l, mid-1, k);
        return binarysearch(arr, mid+1, r, k);
    }




    static void shavnQ2(int n, int k){
        boolean[] vis = new boolean[n];
        int i = 0;
        while (!vis[0] || i != 0){
            vis[i] = true;
            i = (i+k)%n;
        }
        for(; i < n ; i++){
            if(!vis[i]) System.out.print(i + 1 + " ");
        }
    }

    static String shavnQ1(int n){
        Scanner sc = new Scanner(System.in);
        char[] phone  = sc.next().toCharArray();
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for (char c : phone) {
            if ((c - '0') % 2 == 1) ans.append(c);
            else st.push(c);
        }
        while (!st.empty()){
            ans.append(st.pop());
        }
        return ans.toString();
    }

    static int saavnQ3(int n, int[] arr, int d){
        int max = -1;
        int min = Integer.MAX_VALUE;
        int l = 0, r = 0, ans = 0;
        while (r < d){
            min = Math.min(min, arr[r]);
            max = Math.max(max, arr[r]);
            r++;
        }
        while (r < n){
            ans = Math.max(ans, max - min);
            int toOut = arr[l];
            int toIn = arr[r];
            max = Math.max(max, toIn);
            min = Math.min(min, toIn);
            if(toOut == max) max = max(arr, l+1, r);
            else if(toOut == min) min = min(arr, l+1, r);
            //System.out.println(ans);
            l++;
            r++;
        }
        ans = Math.max(ans, max - min);
        return ans;
    }
    static int max(int[] arr, int l, int r){
        int max = -1;
        for(int i = l ; i <= r ; i++){
            max = Math.max(max, arr[i]);
        }
        return max;
    }
    static int min(int[] arr, int l, int r){
        int min = Integer.MAX_VALUE;
        for(int i = l ; i <= r ; i++){
            min = Math.min(min, arr[i]);
        }
        //Arrays.sort(arr,Comparator.comparingInt());
        return min;
    }

}
