package Reccursion;

public class FloodFill {
    public static void main(String[] args) {
        int[][] m = {
                {2,3,3,4},
                {3,3,2,2},
                {2,2,2,2},
                {4,3,2,4}
        };
        int[][] mat = floodFill(m,1,2,0);

        for(int i = 0 ; i< 4 ; i++){
            for(int j = 0 ; j< 4 ; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] floodFill(int[][] matrix, int i, int j, int toFill){
        int prevFill  = matrix[i][j];
        if(prevFill == toFill) return matrix;
        floodFill(matrix, i, j, toFill, prevFill);
        return matrix;
    }

    static void floodFill(int[][] matrix, int i, int j, int toFill, int prevFill){
        if(matrix[i][j] != prevFill) return ;
        matrix[i][j] = toFill;

        if(i < matrix.length-1 && matrix[i+1][j] == prevFill)
        {
            floodFill(matrix, i+1, j , toFill, prevFill);
        }
        if(j < matrix[0].length-1 && matrix[i][j+1] == prevFill){
             floodFill(matrix, i, j+1 , toFill, prevFill);
        }
        if(i > 0 && matrix[i-1][j] == prevFill) {
             floodFill(matrix, i-1, j , toFill, prevFill);
        }
        if(j > 0 && matrix[i][j-1] == prevFill){
            floodFill(matrix, i, j-1 , toFill, prevFill);
        }
    }
}
