package daily_test.Dec14;

// Qs link == {https://leetcode.com/problems/gas-station/}

public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};

        System.out.println(canCompleteCircuit(gas, cost));
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for(int i = 0 ; i < n ; i++){
            int total_fuel = 0;
            boolean travelled = true;
            for(int j = i ; j < i + n ; j++){
                total_fuel += gas[j%n];
                if(total_fuel >= cost[j%n]) total_fuel -= cost[j%n];
                else{
                    travelled = false;
                    if(i != j) i = j-1;      // optimization point (critical point)
                    break;
                }
            }
            if(travelled) return i;
        }
        return -1;
    }
}
