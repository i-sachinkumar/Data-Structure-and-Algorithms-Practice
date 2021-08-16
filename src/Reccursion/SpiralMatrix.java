package Reccursion;

public class SpiralMatrix {
    static int i = 0;

    public static void main(String[] args) {
        int[][] a =
                {
                        {1, 2, 3, 4},
                        {10, 11, 12, 5},
                        {9, 8, 7, 6}
                };
        int[] ans = new int[a.length * a[0].length];
        transverse(a, 0, a[0].length - 1, a.length - 1, 0, ans);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    public static void transverse(int[][] a, int r_s, int c_e, int r_e, int c_s, int[] ans) {
        for (int j = c_s; j <= c_e; j++) {
            ans[i] = a[r_s][j];
            i++;
            if (i == ans.length) return;
        }
        for (int j = r_s + 1; j <= r_e; j++) {
            ans[i] = a[j][c_e];
            i++;
            if (i == ans.length) return;
        }
        for (int j = c_e - 1; j >= c_s; j--) {
            ans[i] = a[r_e][j];
            i++;
            if (i == ans.length) return;
        }
        for (int j = r_e - 1; j > c_s; j--) {
            ans[i] = a[j][c_s];
            i++;
            if (i == ans.length) return;
        }
        transverse(a, r_s + 1, c_e - 1, r_e - 1, c_s + 1, ans);
    }
}
