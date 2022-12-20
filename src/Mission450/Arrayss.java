package Mission450;

import java.util.Arrays;
import java.util.Comparator;

public class Arrayss {
    public static void main(String[] args) {

    }


    //Qs : https://practice.geeksforgeeks.org/problems/reverse-spiral-form-of-matrix4033/1
    public int[] reverseSpiral(int R, int C, int[][] a){
        int sr = 0;
        int sc = 0;
        int er = R-1;
        int ec = C-1;
        int[] ans = new int[R*C];
        int i = 0;
        //Arrays.sort(a, Comparator.comparingInt(o -> o[0]).thenComparingInt());
        while (i < ans.length){
            //left to right;
            for(int j = sc ; j <= ec; j++){
                ans[i] = a[sr][j];
                i++;
            }
            if(i >= ans.length) break;
            sr++;
            //top to bottom
            for(int j = sr; j <= er; j++){
                ans[i] = a[j][ec];
                i++;
            }
            if(i >= ans.length) break;
            ec--;
            //right to left;
            for(int j = ec; j>= sc; j--){
                ans[i] = a[er][j];
                i++;
            }
            if(i >= ans.length) break;
            er--;
            // bottom to top
            for(int j = er; j >= sr; j--){
                ans[i] = a[j][sc];
                i++;
            }
            if(i >= ans.length) break;
            sc++;
        }
        for(int l = 0, r = ans.length-1; l < r; l++,r--){
            int temp = ans[l];
            ans[l] = ans[r];
            ans[r] = temp;
        }
        return ans;
    }
}
