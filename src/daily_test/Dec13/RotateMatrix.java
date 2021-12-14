package daily_test.Dec13;

import java.util.Arrays;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(matrix);
        for(int[] e : matrix){
            System.out.println(Arrays.toString(e));
        }
    }

    public static void rotate(int[][] matrix) {

        // logic: first take transpose of matrix, then reverse each row;

        int n = matrix.length;
        for(int i = 0; i < n ; i++){

            // takin transpose: interchangig row i with col i
            for(int j = i+1 ; j < n ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }

            // reversing ith row after transpose
            reverse_row(matrix, i);
        }
    }


    // method to reverse rth row
    public static void reverse_row(int[][] a, int r){
        int n = a.length;
        for(int i = 0 ; i < n/2 ; i++){
            int temp = a[r][i];
            a[r][i] = a[r][n-1-i];
            a[r][n-1-i] = temp;
        }

    }

}
