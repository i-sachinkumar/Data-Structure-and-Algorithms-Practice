package Reccursion.NQueenProblem;

import java.util.Scanner;


/**
 *  link of question on GeeksForGeeks
 *  https://practice.geeksforgeeks.org/problems/n-queen-problem0315/1#
 *
 *
 * Question
 *
 * The n-queens puzzle is the problem of placing n queens on a (n&times;n) chessboard such that
 * no two queens can attack each other.
 * Given an integer n, find all distinct solutions to the n-queens puzzle.
 * Each solution contains distinct board configurations of the n-queens&rsquo; placement,
 * where the solutions are a permutation of [1,2,3..n] in increasing order, here the number in the
 * ith place denotes that the ith-column queen is placed in the row with that number.
 *
 *
 *
 * Example 1:
 *
 * Input:
 * 1
 * Output:
 * [1]
 * Explanation:
 * Only one queen can be placed
 * in the single cell available.
 * Example 2:
 *
 * Input:
 * 4
 * Output:
 * [2 4 1 3 ] [3 1 4 2 ]
 * Explanation:
 * These are the 2 possible solutions.
 *
 *
 * Your Task:
 * You do not need to read input or print anything.
 * Your task is to complete the function nQueen() which takes n as
 * input parameter and returns a list containing all the possible
 * chessboard configurations in sorted order. Return an empty list if no solution exists.
 *
 *
 *
 * Expected Time Complexity: O(n!)
 * Expected Auxiliary Space: O(n2)
 *
 *
 *
 * Constraints:
 * 1 &le; n &le; 10
 */

public class Main {

    static int[][] chess;


    public static void main(String[] args) {
       // int[][] nqueen = nQueen(2);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        chess = new int[n][n];

        nQueen(chess,n, 0);

        for(int[] ints : chess){
            for(int i : ints){
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

    // By Recursion (Correct)
    static boolean nQueen(int[][] matrix, int n, int r){
        if(r >= n) return true;

        for(int c = 0 ; c < n ; c++){
            if(isSafe(n,r,c)){
                matrix[r][c] = 1;
                if(nQueen(matrix, n, r+1)) return true;
                matrix[r][c] = 0;
            }
        }
        return false;
    }



    // Using Loop (Not Working Yet)
    static int[][] nQueen(int n) {
        int[][] chess = new int[n][n];
        int[] col_info = new int[n];

        int i = 0;
        for(; i < n ;  i++){
            for(int j = col_info[i] ; j < n ;  j++){
                if(isSafe(n, i, j)){
                    col_info[i] = j+1;
                    chess[i][j] = 1;
                    break;
                }
                else if(j == n-1){
                    col_info[i] = 0;
                    i = i - 2;
                    break;
                }
            }
        }
        return chess;
    }



    // to check if queen is safe to place at chess[i][j]
    static boolean isSafe(int n, int i, int j) {

        // check in row
        for (int c = 0; c < n; c++) {
            if (chess[i][c] == 1 && c != j) return false;
        }

        // check in column
        for (int r = 0; r < n; r++) {
            if (chess[r][j] == 1 && r != i) return false;
        }

        // check for backward diagonal ( \ )
        int r = i, c = j;

        while (r > 0 && c > 0) {
            r--;
            c--;
            if (chess[r][c] == 1) return false;
        }

        r = i ; c = j;

        while (r < n - 1 && c < n - 1) {
            r++;
            c++;
            if (chess[r][c] == 1) return false;
        }

        // check for forward diagonal ( / )
            r = i ; c = j;

            while (r < n - 1 && c > 0) {
                r++;
                c--;
                if (chess[r][c] == 1) return false;
            }

            r = i ; c = j;

            while (r > 0 && c < n - 1) {
                r--;
                c++;
                if (chess[r][c] == 1) return false;
            }
        return true;
    }
}
