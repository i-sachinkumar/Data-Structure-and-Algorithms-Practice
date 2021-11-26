package Hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * We define a magic square to be an  matrix of distinct positive integers from
 * to  where the sum of any row, column, or diagonal of length  is always equal
 * to the same number: the magic constant.
 *
 * You will be given a  matrix  of integers in the inclusive range .
 * We can convert any digit  to any other digit  in the range  at cost of .
 * Given , convert it into a magic square at minimal cost. Print this cost on a new line.
 *
 * Note: The resulting magic square must contain distinct integers in the inclusive range .
 *
 * Example
 *
 * $s = [[5, 3, 4], [1, 5, 8], [6, 4, 2]]
 *
 * The matrix looks like this:
 *
 * 5 3 4
 * 1 5 8
 * 6 4 2
 * We can convert it to the following magic square:
 *
 * 8 3 4
 * 1 5 9
 * 6 7 2
 * This took three replacements at a cost of .
 *
 * Function Description
 *
 * Complete the formingMagicSquare function in the editor below.
 *
 * formingMagicSquare has the following parameter(s):
 *
 * int s[3][3]: a  array of integers
 * Returns
 *
 * int: the minimal total cost of converting the input square to a magic square
 * Input Format
 *
 * Each of the  lines contains three space-separated integers of row .
 *
 * Constraints
 *
 * Sample Input 0
 *
 * 4 9 2
 * 3 5 7
 * 8 1 5
 * Sample Output 0
 *
 * 1
 * Explanation 0
 *
 * If we change the bottom right value, , from  to  at a cost of ,
 * becomes a magic square at the minimum possible cost.
 *
 * Sample Input 1
 *  4 8 2
 *  4 5 7
 *  6 1 6
 * Sample Output 1
 *
 * 4

 */

public class MagicMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> matrix = new ArrayList<>();

        System.out.println("Enter a matrix: \n e.g. \n 4 9 2\n 3 5 7\n 8 1 5");

        for(int i = 0 ; i < 3 ; i++){
            matrix.add(new ArrayList<>());
            for(int j = 0 ; j < 3  ; j++){
                matrix.get(i).add(sc.nextInt());
            }
        }


        System.out.println("minimum cost to transform in Magic Matrix is " + minCost(matrix));
    }


    // Function to perform
    public static int minCost(List<List<Integer>> s) {
        int[] a = new int[9];
        int temp = 0;

        //store all 9  entry in a array a[9]
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                a[temp] = s.get(i).get(j);
                temp++;
            }
        }

        // only possible matrix
        // each row show a matrix with 9 entry, will check cost to convert given matrix
        // to anyone of the below matrix with minimum cost
        int[][] matrix={{4,9,2,3,5,7,8,1,6},
                {2,7,6,9,5,1,4,3,8},
                {6,1,8,7,5,3,2,9,4},
                {8,3,4,1,5,9,6,7,2},
                {2,9,4,7,5,3,6,1,8},
                {6,7,2,1,5,9,8,3,4},
                {8,1,6,3,5,7,4,9,2},
                {4,3,8,9,5,1,2,7,6}};

        int minCost = 100;
        for(int i = 0 ; i < 8 ; i++){
            int cost = 0;
            for(int j = 0 ; j < 9 ; j++){
                cost += Math.abs(a[j] - matrix[i][j]);
            }
            minCost = Math.min(cost, minCost);
        }

        return minCost;
    }
}
