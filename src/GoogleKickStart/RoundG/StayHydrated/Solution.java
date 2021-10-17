package GoogleKickStart.RoundG.StayHydrated;

// Google Kick-Start solution of round G in java
// staying hydrated problem

/**
 * With online classes in full swing,
 * it is important for Grace to take breaks and keep herself hydrated at all times.
 * She has decided to place a water bottle in her room in the most convenient place.
 * This means that the position of this water bottle should be close to all the places
 * in the room where she generally hangs out like the study desk,
 * bed and coffee table among other places.
 *
 * The room is represented in the form of a coordinate plane.
 * The number of steps Grace needs to go from Point A to Point B is equal to the
 * Manhattan distance between the 2 points. This means,
 * Grace can only walk parallel to the axes of the coordinate
 * plane and with each step, she can move one unit in either of the four directions.
 *
 * Can you help her find a position in the room to keep the bottle,
 * such that the sum of steps from the bottle to all her favourite furniture pieces will be minimum?
 *
 * Notes:
 *
 * All the furniture (like study desk, bed, or coffee table) can be represented
 * as rectangles of non-zero area in the plane with edges parallel to the axes.
 * It is possible for furniture pieces to overlap,
 * as she likes to work on her bed-table too.
 * Assume that Grace can simply pass through the furniture
 * while walking and does not need to go around them.
 *
 *
 * Input
 * The first line of the input gives the number of test cases, T. T test cases follow.
 * The first line of each test case contains an integer K which represents
 * the number of objects in Grace's room.
 * K lines follow, each of them describing one object.
 * The i-th line contains four integers, xi,1, yi,1, xi,2, yi,2, where (xi,1, yi,1)
 * represents coordinates of the bottom left corner and (xi,2, yi,2)
 * represents coordinates of the top right corner of the i-th rectangular object.
 *
 * Output
 * For each test case, output one line containing Case #i: x y,
 * where i is the test case number (starting from 1) and x and y are coordinates of
 * the water bottle such that the sum of steps from these coordinates to all
 * the furniture pieces will be minimum.
 * Note, the bottle can lie on the floor or on top of any furniture but
 * should be placed on integer coordinates only.
 * If multiple solutions exist, output the one with minimum x coordinate,
 * if multiple solutions have the same x coordinate output the one with minimum y coordinate.
 *
 * Limits
 * Memory limit: 1 GB.
 * 1≤T≤100.
 * xi,1<xi,2, for all i.
 * yi,1<yi,2, for all i.
 * Test Set 1
 * Time limit: 40 seconds.
 * 1≤K≤20.
 * −100≤xi,1,xi,2,yi,1,yi,2≤100, for all i.
 * Test Set 2
 * Time limit: 90 seconds.
 * 1≤K≤105
 * −109≤xi,1,xi,2,yi,1,yi,2≤109, for all i.
 * Sample
 */

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();

        int min_x = Integer.MAX_VALUE;
        int min_y = Integer.MAX_VALUE;

        int max_x = Integer.MIN_VALUE;
        int max_y = Integer.MIN_VALUE;

        for(int i = 1 ; i <= testCases ; i++){
            int num_of_obj = sc.nextInt();

            int[][] obj = new int[num_of_obj][4];



            for(int j = 0 ; j < num_of_obj ; j++){
                obj[j][0] = sc.nextInt();       // bottom x
                min_x = Math.min(min_x, obj[j][0]);
                max_x = Math.max(max_x, obj[j][0]);

                obj[j][1] = sc.nextInt();       // bottom y
                min_y = Math.min(min_y, obj[j][1]);
                max_y = Math.max(max_y, obj[j][1]);

                obj[j][2] = sc.nextInt();       // top x
                min_x = Math.min(min_x, obj[j][2]);
                max_x = Math.max(max_x, obj[j][2]);

                obj[j][3] = sc.nextInt();       // top y
                min_y = Math.min(min_y, obj[j][3]);
                max_y = Math.max(max_y, obj[j][3]);
            }

            int ans_x = min_x;
            int ans_y = min_y;

            int distance = Integer.MAX_VALUE;

            for(int curr_x = min_x ; curr_x <= max_x ; curr_x++){
                for(int curr_y = min_y ; curr_y <= max_y ; curr_y++){
                    int curr_distance = sumOfDistance(curr_x,curr_y,obj);
                    if(curr_distance < distance){
                        distance = curr_distance;
                        ans_x = curr_x;
                        ans_y = curr_y;
                    }
                }
            }
            System.out.println("Case #" + i + ": " + ans_x + " " + ans_y);
        }
    }

    public static int findDistance(int x, int y, int[] obj){
        int horizontal_dist;
        if(obj[0] <= x && obj[2] >= x)  horizontal_dist = 0;
        else horizontal_dist = Math.min(Math.abs(x-obj[0]),Math.abs(x - obj[2]));

        int vertical_dist;
        if (obj[1] <= y && obj[3] >= y) vertical_dist = 0;
        else vertical_dist = Math.min(Math.abs(y-obj[1]),Math.abs(y - obj[3]));

        return horizontal_dist + vertical_dist;
    }

    public static int sumOfDistance(int x, int y, int[][] objs){
        int dist = 0;
        for (int[] obj : objs) {
            dist += findDistance(x, y, obj);
        }
        return dist;
    }
}
