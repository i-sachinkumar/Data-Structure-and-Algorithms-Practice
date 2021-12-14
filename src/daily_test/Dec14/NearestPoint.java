package daily_test.Dec14;

public class NearestPoint {
    public static void main(String[] args) {
        int[][] points = {
                {1,2},
                {3,1},
                {2,4},
                {2,3},
                {4,4}
        };

        System.out.println(nearestValidPoint(3,4,points));

    }

    public static int nearestValidPoint(int x, int y, int[][] points) {

        int ans = -1;

        int small_dist = Integer.MAX_VALUE;

        for(int i = 0 ; i < points.length ; i++ ){

            // if valid point found
            if(x == points[i][0] || y == points[i][1]){

                // find distance
                int dist = Math.abs(x-points[i][0]) + Math.abs(y - points[i][1]);

                // if dist is 0, then it's the smallest one, no need to check further
                if(dist == 0) return i;  // reason for faster than 100% of submissions
                if(dist < small_dist){
                    ans = i;
                    small_dist = dist;
                }
            }
        }

        return ans;
    }
}
