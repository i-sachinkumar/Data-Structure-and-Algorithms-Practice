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

    public static int twoPulse(List<String> grid) {

        //last row index
        int i_end = grid.size()-1;

        //last column index
        int j_end = grid.get(0).length()-1;

        //converting into matrix (2D Array)
        char[][] matrix = new char[i_end+1][j_end+1];
        for(int i = 0 ; i <= i_end ; i++){
            matrix[i] = grid.get(i).toCharArray();
        }

        // to store answer
        int ans = 1;

        for(int i = 1 ; i <= i_end-1 ; i++){
            for(int j = 1 ; j <= j_end-1; j++){
                if(matrix[i][j] == 'G') {
                    int level = 1;
                    while (isValid(matrix, level, i, j, i_end, j_end)) level++;
                    level--;
                    if (level >= 1) {
                        ans *= ((level * 4) + 1);
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
