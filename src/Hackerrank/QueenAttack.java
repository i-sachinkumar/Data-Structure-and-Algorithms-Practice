package Hackerrank;

/**
 * You will be given a square chess board with one queen
 * and a number of obstacles placed on it. Determine how many squares the queen can attack.
 *
 *
 * Complete the queensAttack function in the editor below.
 *
 * queensAttack has the following parameters:
 * - int n: the number of rows and columns in the board
 * - int k: the number of obstacles on the board
 * - int r_q: the row number of the queen's position
 * - int c_q: the column number of the queen's position
 * - int obstacles[k][2]: each element is an array of 2 integers, the row and column of an obstacle
 */

import java.util.List;

public class QueenAttack {
    public static void main(String[] args) {

    }


    public static int queensAttack2(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {


        int[] obstacle_distance = {n - c_q, c_q - 1, n - r_q, r_q - 1, Math.min(n - c_q, n - r_q), Math.min(c_q - 1, r_q - 1), Math.min(n - c_q, r_q - 1), Math.min(n - r_q, c_q - 1)};
        /**
         0 forward
         1 backward
         2 upward
         3 downward
         4 downward-forward diagonal
         5 upward-backward diagonal
         6 upward-forward diagonal
         7 downward-backward diagonal
         */

        for (List<Integer> o : obstacles) {
            int curr_col = o.get(1);
            int curr_row = o.get(0);

            if (r_q == curr_row) {
                if (c_q < curr_col) obstacle_distance[0] = Math.min(obstacle_distance[0], curr_col - c_q);
                else if (c_q > curr_col) obstacle_distance[1] = Math.min(obstacle_distance[1], c_q - curr_col);
            } else if (c_q == curr_col) {
                if (r_q < curr_row) obstacle_distance[2] = Math.min(obstacle_distance[2], curr_row - r_q);
                else if (r_q > curr_row) obstacle_distance[3] = Math.min(obstacle_distance[3], r_q - curr_row);
            } else if (Math.abs(curr_row - r_q) == Math.abs(curr_col - c_q)) {
                int dist = Math.abs(curr_row - r_q);

                if (curr_col > c_q && curr_row < r_q) obstacle_distance[4] = Math.min(obstacle_distance[4], dist);
                else if (curr_col < c_q && curr_row > r_q) obstacle_distance[5] = Math.min(obstacle_distance[5], dist);
                else if (curr_col > c_q && curr_row > r_q) obstacle_distance[6] = Math.min(obstacle_distance[6], dist);
                else if (curr_col < c_q && curr_row < r_q) obstacle_distance[7] = Math.min(obstacle_distance[7], dist);
            }
        }

        int total = 0;
        for(int i : obstacle_distance){
            total += i;
        }
        return total;
    }

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {

        int[][] chess = new int[n][n];
        r_q--;
        c_q--;

        chess[r_q][c_q] = 1;

        for(List<Integer> obstacle : obstacles){
            chess[obstacle.get(0)-1][obstacle.get(1)-1] = 2;
        }

        int count = 0;

        //forward
        for(int i = c_q+1 ; i < n ; i++){
            if(chess[r_q][i] == 0) count++;
            else break;
        }

        //backward
        for(int i = c_q-1 ; i >= 0 ; i--){
            if(chess[r_q][i] == 0) count++;
            else break;
        }

        //upward
        for(int i = r_q+1 ; i < n ; i++){
            if(chess[i][c_q] == 0) count++;
            else break;
        }

        //downward
        for(int i = r_q-1 ; i >= 0 ; i--){
            if(chess[i][c_q] == 0) count++;
            else break;
        }

        // downward-forward diagonal
        for(int i = r_q+1, j = c_q+1 ; i < n && j < n ; i++,j++){
            if(chess[i][j] == 0) count++;
            else break;
        }

        // upward-backward diagonal
        for(int i = r_q-1, j = c_q-1 ; i >=0 && j >=0 ; i--,j--){
            if(chess[i][j] == 0) count++;
            else break;
        }

        // upward-forward diagonal
        for(int i = r_q-1, j = c_q+1 ; i >= 0 && j < n ; i--,j++){
            if(chess[i][j] == 0) count++;
            else break;
        }

        // downward-backward diagonal
        for(int i = r_q+1, j = c_q-1 ; i < n && j >= 0 ; i++,j--){
            if(chess[i][j] == 0) count++;
            else break;
        }

        return count;
    }
}
