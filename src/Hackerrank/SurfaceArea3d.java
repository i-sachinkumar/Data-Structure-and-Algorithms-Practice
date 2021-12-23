package Hackerrank;


// Qs Link = {TODO}

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SurfaceArea3d {
    public static void main(String[] args) {
        List<List<Integer>> A = new ArrayList<>();
//        1 3 4
//        2 2 3
//        1 2 4
        A.add(List.of(1,3,4));
        A.add(List.of(2,3,3));
        A.add(List.of(1,2,4));

        System.out.println(surfaceArea(A));
        System.out.println(surfaceArea2(A));

        new ArrayList<Integer>(List.of(-1));
        Set<Integer> s = new HashSet<>();


    }

    public static int surfaceArea(List<List<Integer>> A) {
        int r = A.size();
        int c = A.get(0).size();
        int area = 2*r*c;
        int[][] grid = new int[r+2][c+2];
        for(int i = 1 ; i <= r ; i++){
            for (int j = 1 ; j <= c ; j++){
                grid[i][j] = A.get(i-1).get(j-1);
            }
        }

        for(int i = 1 ; i <= r ; i++){
            for (int j = 1 ; j <= c ; j++){
                area += Math.max(0, grid[i][j] - grid[i][j+1]);
                area += Math.max(0, grid[i][j] - grid[i][j-1]);
                area += Math.max(0, grid[i][j] - grid[i+1][j]);
                area += Math.max(0, grid[i][j] - grid[i-1][j]);
            }
        }
        return area;

    }

    public static int surfaceArea2(List<List<Integer>> A) {
        int r = A.size();
        int c = A.get(0).size();
        int area = 2*r*c;
        int[][] grid = new int[r+1][c+1];
        for(int i = 0 ; i < r ; i++){
            for (int j = 0 ; j < c ; j++){
                grid[i][j] = A.get(i).get(j);
            }
        }

        for(int i = 0 ; i < r ; i++){
            for (int j = 0 ; j < c ; j++){
                area += (4 * grid[i][j]);
                area -= (2 * Math.min(grid[i][j], grid[i+1][j]));
                area -= (2 * Math.min(grid[i][j], grid[i][j+1]));
            }
        }
        return area;

    }
}
