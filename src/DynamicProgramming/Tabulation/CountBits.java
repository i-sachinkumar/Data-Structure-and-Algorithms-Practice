package DynamicProgramming.Tabulation;

// Qs. Link = {https://leetcode.com/problems/counting-bits/}

import java.util.Arrays;


public class CountBits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));

        System.out.println(Arrays.toString(countBitsFast(5)));
    }

    public static int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int i = 0 ; i < n+1;i++){
            int temp = i;
            int count = 0;
            while(temp > 0){
                if(ans[temp] != 0){
                    count += ans[temp];
                    break;
                }
                count++;
                temp = temp&(temp-1);
            }
            ans[i] = count;
        }
        return ans;
    }

    public static int[] countBitsFast(int n) {
        final int[] res = new int[n+1];
        for (int i = 1; i <= n; i++) {
            res[i] = res[i>>1] + (i&1);
        }
        return res;
    }


}
