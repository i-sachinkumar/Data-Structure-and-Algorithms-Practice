package Mission450;

import java.util.*;

public class Greedy {
    public static void main(String[] args) {

        System.out.println(buyMaximumProducts(3, 45, new int[]{10, 7, 19}));
        System.out.println(findPlatform(new int[]{900, 940, 950, 1100, 1500, 1800},
                new int[]{940, 1200, 1120, 1130, 1900, 2000}, 6));

        int n = 15, p = 10;

        ArrayList<Integer> a = new ArrayList<>(List.of(2, 5, 13, 14, 3, 10, 4, 15, 6, 1));
        ArrayList<Integer> b = new ArrayList<>(List.of(13, 8, 7, 1, 11, 14, 9, 2, 15, 10));
        ArrayList<Integer> d = new ArrayList<>(List.of(4, 6, 8, 3, 9, 9, 10, 3, 7, 8));
        System.out.println(solve(n, p, a,b,d));

        System.out.println(huffmanCodes("abcdefg", new int[]{5,9,12,13,16,45},100));

        int[] arr = {1, 3, 0, 5, 8, 5};
        int[] arr1 = {2, 4, 6, 7, 9, 9};
        System.out.println(maxMeetings(arr, arr1, 6));
    }

    // n - bulb problem

    /**
     * N light bulbs are connected by a wire. Each bulb has a switch associated with it,
     * however due to faulty wiring, a switch also changes the state of all the bulbs to
     * the right of current bulb. Given an initial state of all bulbs,
     * find the minimum number of switches you have to press to turn on all the bulbs.
     * "0 represents the bulb is off and 1 represents the bulb is on."
     */
    public static int countFlips(int a[], int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (count % 2 == 0) {
                if (a[i] == 0) count++;
            } else {
                if (a[i] == 1) count++;
            }
        }
        return count;
    }


    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 1] * nums[n - 2] * nums[n - 3]);
    }

    public int maximumProductFast(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }

            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }


    /**
     * Given an array of intervals intervals where intervals[i] = [starti, endi],
     * return the minimum number of intervals you need to remove to make the rest of the
     * intervals non-overlapping.
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int count = 1;
        int[] last = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (last[1] <= intervals[i][0]) {
                count++;
                last = intervals[i];
            }
        }
        return intervals.length - count;
    }


    void KswapPermutation(long[] arr, int n, int k) {
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        long max = n;
        int curr_ind = 0;
        while (k > 0 && max > 0) {
            int max_ind = map.get(max);
            if (max_ind == curr_ind) {
                curr_ind++;
                max--;
            } else {
                long temp = arr[curr_ind];
                arr[curr_ind] = max;
                arr[max_ind] = temp;
                map.put(max, curr_ind);
                map.put(temp, max_ind);
                max--;
                curr_ind++;
                k--;
            }
        }
    }


    /**
     * Disjoint Interval
     * Given a set of N intervals denoted by 2D array A of size N x 2,
     * the task is to find the length of maximal set of mutually disjoint intervals.
     * <p>
     * Two intervals [x, y] & [p, q] are said to be disjoint if they do not have any point in common.
     * Return a integer denoting the length of maximal set of mutually disjoint intervals.
     */
    public int maxDisjointIntervals(ArrayList<ArrayList<Integer>> A) {
        A.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(1) - o2.get(1);
            }
        });
        ArrayList<Integer> last = A.get(0);
        int count = 1;
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i).get(0) > last.get(1)) {
                count++;
                last = A.get(i);
            }
        }
        return count;
    }


    /**
     * Given an integer array A of size N consisting of unique integers from 1 to N.
     * You can swap any two integers atmost B times.
     * Return the largest lexicographical value array that can be created by executing atmost B swaps.
     */
    public ArrayList<Integer> largestPermutation(ArrayList<Integer> A, int B) {
        if(B >= A.size()){
            A.sort(Collections.reverseOrder());
            return A;
        }
        Map<Integer, Integer> indexOf = new HashMap<>();
        for (int j = 0; j < A.size(); j++) {
            indexOf.put(A.get(j), j);
        }
        int i = 0;
        int max = A.size();
        while (B > 0 && i < A.size()) {
            int cur_ind = indexOf.get(max);
            if (cur_ind == i) ;
            else {
                int temp = A.get(i);
                int temp2 = A.get(cur_ind);
                A.set(i, temp2);
                A.set(cur_ind, temp);
                indexOf.put(temp, cur_ind);
                indexOf.put(temp2, i);
                B--;
            }
            i++;
            max--;
        }
        return A;
    }


    /** Meeting Rooms
     *
     */
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        a.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return 0;
            }
        });
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> in = new ArrayList<>();
            int st = A.get(i).get(0);
            int end = A.get(i).get(1);
            in.add(st);
            in.add(+1);
            a.add(in);
            in.clear();
            in.add(end);
            in.add(-1);
            a.add(in);
        }

        a.sort((o1, o2) -> {
            if (Objects.equals(o1.get(0), o2.get(0))) return o2.get(1) - o1.get(1);
            return o1.get(0) - o2.get(0);
        });

        int curr = 0;
        int max = 0;
        for (ArrayList<Integer> e : a) {
            curr += e.get(1);
            max = Math.max(max, curr);
        }
        return max;
    }

    public int solve(int[][] A) {
        int n = A.length;
        ArrayList<ArrayList<Integer>> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int s = A[i][0];
            int e = A[i][1];
            ArrayList<Integer> temp1 = new ArrayList<>();
            temp1.add(s);
            temp1.add(1);

            ArrayList<Integer> temp2 = new ArrayList<>();
            temp1.add(e);
            temp1.add(-1);
            l.add(temp1);
            l.add(temp2);
        }
        int curr = 0;
        int max = 0;
        l.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(0) - o2.get(0);
            }
        });
        for (ArrayList<Integer> e : l) {
            curr += e.get(1);
            max = Math.max(max, curr);
        }
        return max;
    }


    //Function to find the maximum number of meetings that can
    public static int maxMeetings(int[] start, int[] end, int n) {
        int[][] times = new int[n][2];
        for (int i = 0; i < n; i++) {
            times[i][0] = start[i];
            times[i][1] = end[i];
        }

        Arrays.sort(times, Comparator.comparingInt(o -> o[1]));
        int ans = 1;
        int last_y = times[0][1];
        for (int i = 1; i < n; i++) {
            if (times[i][0] >= last_y) {
                ans++;
                last_y = times[i][1];
            }
        }
        return ans;
    }


    public static class Job {
        public int id, profit, deadline;

        Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }

    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n) {
        Arrays.sort(arr, (o1, o2) -> o2.profit - o1.profit);
        HashSet<Integer> set = new HashSet<>();
        int profit = 0;
        profit += arr[0].profit;
        set.add(arr[0].deadline);
        for (int i = 1; i < n; i++) {
            int dead = arr[i].deadline;
            if (!set.contains(dead)) {
                set.add(dead);
                profit += arr[i].profit;
            } else {
                for (int j = dead - 1; j >= 1; j--) {
                    if (!set.contains(j)) {
                        set.add(j);
                        profit += arr[i].profit;
                        break;
                    }
                }
            }
        }
        return new int[]{set.size(), profit};
    }








    //QS: https://www.interviewbit.com/problems/seats/
    public int seats(String A) {
        char[] seats = A.toCharArray();
        ArrayList<Integer> ind_of_cross = new ArrayList<>();
        for(int i = 0 ; i < seats.length; i++){
            if(seats[i] == 'x') ind_of_cross.add(i);
        }
        if(ind_of_cross.size() == 0 || ind_of_cross.size() == seats.length) return 0;
        int  mod = 10000003;
        int ans = Integer.MAX_VALUE;
        // for(int i = 0 ; i <= seats.length - ind_of_cross.size(); i++){
        int temp = ind_of_cross.get(ind_of_cross.size()/2) - ind_of_cross.size()/2;
        int cost = 0;
        for(int ind : ind_of_cross){
            cost = (cost + (Math.abs(ind - temp)))%mod;
            temp++;
        }
        ans = Math.min(ans, cost);
        // }
        return ans;
    }



    //Qs: https://www.interviewbit.com/problems/distribute-candy/
    static class Pair{
        int rating;
        int index;
        Pair(int r, int i){
            rating = r;
            index = i;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "rating=" + rating +
                    ", index=" + index +
                    '}';
        }
    }
    public static int candy(ArrayList<Integer> A) {
        ArrayList<Pair> ch = new ArrayList<>();
        for(int i = 0 ; i < A.size(); i++){
            ch.add(new Pair(A.get(i), i));
        }
        Collections.sort(ch, new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2){
                return p1.rating - p2.rating;
            }
        });
        int[] candies = new int[A.size()];
        Arrays.fill(candies, 1);
        for (Pair pair : ch) {
            int ind = pair.index;
            if (ind > 0 && A.get(ind) > A.get(ind - 1)) {
                candies[ind] = candies[ind - 1] + 1;
            }
            if (ind < A.size() - 1 && A.get(ind) > A.get(ind + 1)) {
                candies[ind] = Math.max(candies[ind], candies[ind + 1] + 1);
            }
        }
        int ans = 0;
        for(int i : candies){
            ans += i;
        }
        return ans;
    }



    //Qs: https://www.interviewbit.com/problems/assign-mice-to-holes/
    public int mice(ArrayList<Integer> A, ArrayList<Integer> B) {
        Collections.sort(A);
        Collections.sort(B);
        int ans = -1;
        for(int i = 0 ; i < A.size(); i++){
            ans = Math.max(ans, Math.abs(A.get(i) - B.get(i)));
        }
        return ans;
    }




    //Qs: https://www.interviewbit.com/problems/majority-element/
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    // do by bits
    public int majorityElement(final List<Integer> A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : A){
            if(map.containsKey(i)) map.replace(i, map.get(i) + 1);
            else map.put(i, 1);
        }
        for(int i : map.keySet()){
            if(map.get(i) >= A.size()/2) return 1;
        }
        return 0;
    }



    //Qs https://www.interviewbit.com/problems/gas-station/
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int canCompleteCircuit( List<Integer> A, final List<Integer> B) {
        int n = A.size();
        for(int i = 0 ; i < n; i++){
            int gas = 0;
            for(int j = i ; j < n + n; j++){
                gas += A.get(j%n);
                gas -= B.get(j%n);
                if(gas < 0){
                    i = j;
                    break;
                }
                if(j == i+n-1) return i;
            }
        }
        return -1;
    }



    //Qs: https://practice.geeksforgeeks.org/problems/huffman-encoding3345/1
    static class Node implements Comparable<Node> {
        int data;
        Node left = null , right = null;
        Node(int data){
            this.data = data;
        }
        @Override
        public int compareTo(Node o) {
            return this.data - o.data;
        }
        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
    public static ArrayList<String> huffmanCodes(String S, int[] f, int N) {
        Queue<Node> pq = new PriorityQueue<>();
        for(int i : f){
            pq.add(new Node(i));
        }
        while (pq.size() > 1){
            Node n1 = pq.remove();
            Node n2 = pq.remove();
            Node newNode = new Node(n1.data + n2.data);
            newNode.left = n1;
            newNode.right = n2;
            pq.add(newNode);
        }
        Node root = pq.remove();
        ArrayList<String> ans = new ArrayList<>();
        inOrder(root, "", ans);
        return ans;
    }
    // 5 9 12 13 16 45 -> 12 13 14 16 45 -> 14 16 25 45 -> 25 30 45 -> 45 55 -> 100
    public static void inOrder(Node root, String curr, ArrayList<String> ans){
        if(root == null) return;
        if(root.left == null && root.right == null){
            //System.out.print(curr + ", ");
            ans.add(curr);
            return;
        }
        inOrder(root.left, curr+"0", ans);
        inOrder(root.right, curr+"1", ans);
    }




    // water connection problem
    // Qs: https://practice.geeksforgeeks.org/problems/water-connection-problem5822/1
    static ArrayList<ArrayList<Integer>> solve(int n, int p, ArrayList<Integer> a ,ArrayList<Integer> b ,ArrayList<Integer> d){
        // code here
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(n);
        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>());
        }
        //Collections.fill(graph, new ArrayList<>());
        for(int i = 0 ; i < p ; i++){
            graph.get(a.get(i)-1).add(b.get(i)-1);
            graph.get(a.get(i)-1).add(d.get(i));
            //graph.set(a.get(i)-1, new ArrayList<>(List.of(b.get(i)-1, d.get(i))));
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>(n);
        for(int i = 0; i < n ; i++){
            ans.add(new ArrayList<>());
        }
        //Collections.fill(ans, new ArrayList<>());
        boolean[] vis = new boolean[n];
        for(int i = 0 ; i < n ; i++){
            //System.out.println("i, " + i);
            if(!vis[i]) solve(graph, i, ans, vis, Integer.MAX_VALUE, i);
        }
        ArrayList<ArrayList<Integer>> req_ans = new ArrayList<>();
        for(int i = 0; i < n ; i++){
            ArrayList<Integer> data = ans.get(i);
            if(data.size() == 0) continue;
            req_ans.add(new ArrayList<>(List.of(i+1, data.get(0)+1, data.get(1))));
        }
        return req_ans;
    }
    static void solve(ArrayList<ArrayList<Integer>> graph,
               int i, ArrayList<ArrayList<Integer>> ans, boolean[] vis, int diameter, int start){
        if(vis[i]){
            if(ans.get(i).size() > 0){
                //System.out.println(ans.get(i));
                ans.get(start).add(ans.get(i).get(0));
                ans.get(start).add(Math.min(diameter, ans.get(i).get(1)));
                ans.get(i).clear();
            }
            else if(start != i){
                ans.get(start).add(i);
                ans.get(start).add(diameter);
            }
//            ans.set(start+1, new ArrayList<>(List.of(ans.get(i).get(0), Math.min(diameter, ans.get(i).get(1)))));
//            ans.set(i+1, new ArrayList<>());
            return;
        }
        vis[i] = true;
        ArrayList<Integer> neighbor = graph.get(i);
        if(neighbor.size() == 0){
            if(start != i) {
                ans.get(start).add(i);
                ans.get(start).add(diameter);
                //ans.set(start+1, new ArrayList<>(List.of(i+1, diameter)));
            }
            return;
        }
        int next_house = neighbor.get(0);
        int dia = neighbor.get(1);
        solve(graph, next_house, ans, vis,  Math.min(dia, diameter), start);
    }


    //Function to get the maximum total value in the knapsack.
    static class Item implements Comparable<Item>{
        public int value, weight;
        Item(int x, int y){
            this.value = x;
            this.weight = y;
        }
        @Override
        public int compareTo(Item o) {
            if((double)this.value/(double)this.weight  >=  (double) o.value/(double)o.weight) return 1;
            return -1;
        }
    }
    double fractionalKnapsack(int W, Item[] arr, int n) {
        Arrays.sort(arr, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                if((double)o2.value/(double)o2.weight  >=  (double) o1.value/(double)o1.weight) return 1;
                return -1;
            }
        });
        double ans = 0.0;
        int i = 0;
        for(; i < n ; i++){
            if(W - arr[i].weight > 0){
                ans += arr[i].value;
                W -= arr[i].weight;
            }
            else break;
        }
        ans += (((double) W * arr[i].value)/ (double) arr[i].weight);
        return ans;
    }


    String chooseandswap(String A){
        // Code Here
        char[] arr = A.toCharArray();
        int[] freq = new int[26];
        for(char c : arr){
            freq[c - 'a']++;
        }

        for(int i = 0 ; i < freq.length ; i++){
            char curr = arr[i];
            for(int j = 0 ; j < (curr - 'a'); j++){
                if(freq[j] > 0) return replace(arr, curr, (char) ('a' + j));
            }
            freq[i] = 0;
        }
       return A;
    }
    String replace(char[] arr, char a, char b){
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == a) arr[i] = b;
            else if(arr[i] == b) arr[i] = a;
        }
        return String.valueOf(arr);
    }


    public static ArrayList<Integer> findLeastGreater(int n, int[] arr) {
        int[][] nArr = new int[n][2];
        for(int i = 0 ; i < n ; i++){
            nArr[i][0] = arr[i];
            nArr[i][1] = i;
        }
        Arrays.sort(nArr, Comparator.comparingInt(o -> o[0]));
        for(int i = 0 ; i < n ; i++){
            int[] e = nArr[i];
            int el = e[0];
            int ind = e[1];
            for(int j = i+1; j <= n ; j++){
                if(j == n){
                    arr[ind] = -1;
                    break;
                }
                if(nArr[j][1] > ind && el != nArr[j][0]){
                    arr[ind] = nArr[j][0];
                    break;
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i : arr){
            ans.add(i);
        }
        return ans;
    }


    //Qs: https://practice.geeksforgeeks.org/problems/bb917adb320fba36a9d68fd64c83ef322632a094/1
    //Max trains on platform
    static int maxStop(int n, int m, ArrayList<ArrayList<Integer>> trains) {
        // Write your code here
        ArrayList<ArrayList<Pair>> platforms = new ArrayList<>();
        for(int i = 0; i < n ; i++){
            platforms.add(new ArrayList<>());
        }
        for (ArrayList<Integer> train : trains) {
            platforms.get(train.get(2)-1).add(new Pair(train.get(0), train.get(1)));
        }
        int ans = 0;
        for(ArrayList<Pair> platform : platforms){
            if(platform.size() == 0) continue;
            platform.sort(Comparator.comparingInt(o -> o.index));
            Pair last = platform.get(0);
            int count = 1;
            for(int i = 1 ; i < platform.size(); i++){
                if(last.index <= platform.get(i).rating){
                    last = platform.get(i);
                    count++;
                }
            }
            ans += count;
        }
        return ans;
    }


    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int[] arr, int[] dep, int n){
        ArrayList<Pair> cp = new ArrayList<>();
         //Pair: rating == arrival; index == departure
        for(int i = 0 ; i < n ; i++){
            cp.add(new Pair(arr[i], 1));
            cp.add(new Pair(dep[i], -1));
        }
        cp.sort((o1, o2) -> {
            if(o1.rating != o2.rating) return o1.rating - o2.rating;
            return o1.index - o2.index;
        });
        System.out.println(cp);
        int ans = 0;
        int curr = 0;
        for(int i = 0 ; i < cp.size(); i++){
            curr += cp.get(i).index;
            ans = Math.max(curr, ans);
        }
        return ans;
    }



    // max stock
    //Qs: https://practice.geeksforgeeks.org/problems/buy-maximum-stocks-if-i-stocks-can-be-bought-on-i-th-day/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
    public static int buyMaximumProducts(int n, int k, int[] price) {
        // code here
        int[][] stocks = new int[n][2];
        for(int i = 0; i < n ;i++){
            stocks[i][0] = price[i];
            stocks[i][1] = i+1;
        }
        Arrays.sort(stocks, Comparator.comparingInt(o -> o[0]));
        int ans = 0;
        int i = 0;
        for( ; i < n ; i++){
            int p = stocks[i][0];
            int f = stocks[i][1];
            if(k >= p*f){
                ans += f;
                k -= (p*f);
            }
            else break;
        }
        if(i >= n) return ans;
        int p = stocks[i][0];
        int f = stocks[i][1];
        while(k-p >= 0 && f > 0){
            ans++;
            k -= p;
            f--;
        }
        return ans;
    }



    //Shop in Candy Store
    //Qs: https://practice.geeksforgeeks.org/problems/shop-in-candy-store1145/1
    static ArrayList<Integer> candyStore(int[] candies, int N, int K){
        Arrays.sort(candies);
        int min = 0;
        int temp = 0;
        int i = 0;
        while(temp < N){
            min += candies[i];
            temp += (K+1);
            i++;
        }
        int max = 0;
        temp = 0;
        i = N-1;
        while(temp < N){
            max += candies[i];
            temp += (K+1);
            i--;
        }
        return new ArrayList<>(List.of(min, max));
    }



    //Minimum Cost to cut a board into squares
    //Qs: https://practice.geeksforgeeks.org/problems/minimum-cost-to-cut-a-board-into-squares/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
    public static int minimumCostOfBreaking(int[] X, int[] Y,int M,int N) {
        // code here
        int[][] costs = new int[X.length + Y.length][2];
        for(int i = 0 ; i < X.length; i++){
            costs[i][0] = X[i];
            costs[i][1] = 1; //verticle
        }
        for(int i = 0 ; i < Y.length; i++){
            costs[X.length + i][0] = Y[i];
            costs[X.length + i][1] = -1; //horizontal
        }
        Arrays.sort(costs, (o1, o2) -> {
            if(o1[0] == o2[0]) return Y.length - X.length;
            return o1[0] - o2[0];
        });
        int vert_cut = 0;
        int hor_cut = 0;
        int ans = 0;
        for (int[] ints : costs) {
            int cost = ints[0];
            int type = ints[1];
            if (type == 1) {
                ans += (cost * (hor_cut + 1));
                vert_cut++;
            } else {
                ans += (cost * (vert_cut + 1));
                hor_cut++;
            }
        }
        return ans;
    }











    // Random Qs of a Test (onward)
    public static int countSubArray(List<Integer> arr,int k) {
        int j = 1;
        int ans =0;
        int count=0;
        while(j < arr.size())
        {
            if(arr.get(j) > arr.get(j-1))
            {
                count++;
            }
            else
            {
                if(count+1 >= k)
                {
                    ans += count-k+2;
                    count=0;
                }
            }
            j++;
        }
        if(count+1 >= k)
            ans += count-k+2;
        return ans;
    }

    static class Car{
        public void topSpeed(){
            System.out.println("Top Speed of the vehicle is 100 kmph");
        }
        public void fuelType(){
            System.out.println("Car fuel type is Petrol");
        }
    }

    static class SUV extends Car{
        @Override
        public void topSpeed() {
            super.topSpeed();
        }

        @Override
        public void fuelType() {
            System.out.println("SUV fuel type is Diesel");
        }
    }


    public static int getMinDeletions(String s){
        Set<Character> mp = new HashSet<>();
        int ans = 0;
        for(char c : s.toCharArray()){
            if(mp.add(c)) ;
            else ans++;
        }
        return ans;
    }

    public static int getMinDeletions(String s, int i, int j){
        if(i >= j){
            return 0;
        }
        if(s.charAt(i) == s.charAt(j)) return getMinDeletions(s, i+1, j-1);
        return 1 + Math.min(getMinDeletions(s, i, j-1), getMinDeletions(s, i+1, j));
    }

    public static int optimalPoint(List<Integer> magic, List<Integer> dist){
        int n = magic.size();
        for(int i = 0 ; i < n; i++){
            int gas = 0;
            for(int j = i ; j < n + n; j++){
                gas += magic.get(j%n);
                gas -= dist.get(j%n);
                if(gas < 0){
                    i = j;
                    break;
                }
                if(j == i+n-1) return i;
            }
        }
        return -1;
    }

    /**
     * int n = blue.size() ;
     *     vector<vector<long>> dp(n+1,vector<long>(2,INT_MAX)) ;
     *     dp[0][0] = 0 ;
     *     dp[0][1] = blueCost ;
     *
     *     for(int i=0;i<n;i++){
     *         for(int j=0;j<2;j++){
     *             dp[i+1][1] =  min(dp[i+1][1], dp[i][j] + (blueCost*(j==0)) + blue[i] ) ;
     *             dp[i+1][0] = min(dp[i+1][0], dp[i][j] + red[i] ) ;
     *         }
     *     }
     *     vector<long> ans ;
     *     for(int i=0;i<n+1;i++)
     *         ans.push_back(min(dp[i][0],dp[i][1])) ;
     *
     *   return ans;
     */
    public static List<Long> minimumCost(List<Integer> red, List<Integer> blue, int blueCost){
        int n = blue.size();
        long[][] dp  = new long[n+1][n+1];
        for(long[] in : dp){
            Arrays.fill(in, Long.MAX_VALUE);
        }
        dp[0][0] = 0;
        dp[0][1] =  blueCost;
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < n ; j++){
                if(j==0) dp[i+1][1] =  Math.min(dp[i+1][1], dp[i][j] + blueCost + blue.get(i) ) ;
                else Math.min(dp[i+1][1], dp[i][j] + blue.get(i) );
                dp[i+1][0] = Math.min(dp[i+1][0], dp[i][j] + red.get(i) ) ;
            }
        }
        List<Long> ans = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            ans.add(Math.min(dp[i][0],dp[i][1]));
        }
        return ans;
    }
    public static int intervals(int[] prices, int k){
        int ans = 0;
        int n = prices.length;
        for(int i = 0 ; i < n; i++){
            for(int j = i ; j < n-1; j++){
                if(prices[j+1] > prices[j]);
                else{
                    i = j-1;
                    break;
                }
                if(j == i+k-1){
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }



}
