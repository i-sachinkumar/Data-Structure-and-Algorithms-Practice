package DynamicProgramming.Tabulation;

public class GridTraveller {
    public static void main(String[] args) {

        System.out.println(gridTraveller(4,4));
        
    }

    public static int gridTraveller(int m, int n){
        int[][] grid = new int[m+1][n+1];
        grid[1][1] = 1;

        for(int i = 1 ; i < m+1; i++){
            for(int j = 1 ; j < n+1 ; j++){
                if(i+1 < m+1) grid[i+1][j] += grid[i][j];
                if(j+1 < n+1) grid[i][j+1] += grid[i][j];
            }
        }

        return grid[m][n];
    }
}
