package Hackerrank;

import java.util.ArrayList;
import java.util.List;

public class TwoPulses {
    public static void main(String[] args) {

        List<String> grid = new ArrayList<>();
        grid.add("BBBBGBBBB");
        grid.add("BBBBGBBGB");
        grid.add("BBBBGBGGG");

        grid.add("BGGGGGGGB");

        grid.add("BBBBGBBBB");
        grid.add("BBBBGBBBB");
        grid.add("BBBBGBBBB");

        grid.add("BBBBGBBBB");

        System.out.println(twoPulse(grid));

    }

    public static int twoPulse(List<String> grid){

        //last row index
        int end_r = grid.size()-1;

        //last column index
        int end_c = grid.get(0).length()-1;

        //converting into matrix (2D Array)
        char[][] matrix = new char[end_r+1][end_c+1];
        for(int i = 0 ; i <= end_r ; i++){
            matrix[i] = grid.get(i).toCharArray();
        }

        return twoPulse(matrix,1,1,end_r,end_c);
    }

    public static int twoPulse(char[][] matrix, int start_r, int start_c, int end_r, int end_c) {

        // to store answer
        int ans = 1;

        for(int i = start_c ; i <= end_r-1 ; i++){
            for(int j = start_r ; j <= end_c-1; j++){
                if(matrix[i][j] == 'G') {
                    int level = 0;
                    while (isValid(matrix, level+1, i, j, end_r, end_c)) level++;
                    if (level == 1) {
                        ans *= ((4) + 1);
                    }
                    else if(level > 1){
                        for(int l = 1 ;  l <= level; l++){
                            blockUsedCell(matrix, l, i, j);


                            ans = Math.max(((4*l) + 1)*twoPulse(matrix,i+1,j, end_r,end_c),ans);
                        }
                        blockUsedCell(matrix, level, i, j);
                    }
                }
            }
        }

        return ans;
    }

    static boolean isValid(char[][] matrix, int level, int i , int j, int i_end, int j_end){
        //if outside matrix
        if(i-level < 0 || j-level < 0 || i+level>i_end || j+level>j_end) return false;

        //if bad cell is found
        if(matrix[i-level][j] == 'B' || matrix[i+level][j] == 'B' || matrix[i][j-level] == 'B' || matrix[i][j+level] == 'B') return false;

        //else good to go
        return true;
    }

    static void blockUsedCell(char[][] matrix, int level, int i , int j){
        matrix[i][j] = 'B';
        for(int p = 1 ; p <=level; p++){
            matrix[i][j+p] = 'B';
            matrix[i][j-p] = 'B';
            matrix[i+p][j] = 'B';
            matrix[i-p][j] = 'B';
        }
    }
}
