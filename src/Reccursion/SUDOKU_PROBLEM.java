package Reccursion;

public class SUDOKU_PROBLEM {
//    static int[][] board = {
//            { 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 },
//            { 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 },
//            { 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 },
//            { 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 },
//            { 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 },
//            { 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 },
//            { 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 },
//            { 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 },
//            { 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 }
//    };

    public static void main(String[] args) {

        int[][] board = {

                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        solve_sudoku(board);

        for(int[] ints : board){
            for(int i : ints){
                System.out.print(i + "  ");
            }
            System.out.println();
        }
    }



    static boolean solve_sudoku(int[][] board){


        int row = -1;
        int col = -1;

        boolean isEmpty = false;

        for(int i = 0 ; i < 9 ; i++){
            for(int j = 0 ; j < 9 ; j++){
                if(board[i][j] == 0) {
                    isEmpty = true;
                    row = i;
                    col = j;
                    break;
                }
            }
            if(isEmpty) break;
        }

        if(!isEmpty) return true;

        for(int num = 1 ; num <= 9 ; num++){
            if(isSafe(board,row, col, num)){
                board[row][col] = num;
                if(solve_sudoku(board)) return true;
                else board[row][col] = 0;
            }
        }
        return false;
    }












    static boolean isSafe(int[][] board, int r, int c, int n){

        // Check in row 'r' for number 'n'
        for(int i = 0 ; i < 9 ; i ++){
            if(board[r][i] == n) return false;
        }

        // Check in row 'c' for number 'n'
        for(int i = 0 ; i < 9 ; i ++){
            if(board[i][c] == n) return false;
        }


        //top left index of subBox is
        int curr_row = r/3;
        int curr_col = c/3;
        // Check for number 'n' in current subBox(3x3)
        for(int i = curr_row*3 ; i < curr_row*3 +  3 ; i++ ){
            for(int j = curr_col*3 ; j < curr_col*3 + 3 ; j++){
                if(board[i][j] == n) return false;
            }
        }

        return true;
    }


}