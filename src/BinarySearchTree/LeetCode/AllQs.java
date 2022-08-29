package BinarySearchTree.LeetCode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class AllQs {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        /**
         * l = 0, r = 5
         * mid = 5/2  = 2
         * left                                 right
         * l=0, r=mid =2                          l=mid+1 = 3, r = 5
         * mid = 2/2 = 1                          mid = 8/2 = 4
         */
        TreeNode root = sortedArrayToBST(nums);

        System.out.println(lowestCommonAncestor(root, root.left, root.right).val);

        twoSum(root, -13);
        System.out.println(found);


        int[] a = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
        System.out.println(findZeroes(a, 11, 2));

        int[] toSearch = {2, 2, 5, 5, 20, 30, 30};
        System.out.println(search(toSearch, 7));

        System.out.println(maxXor(2,4,8));


        //List<String> sortedTitles = getMovieTitles("Spiderman");
        //System.out.println(sortedTitles);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val == q.val) return p;
        if(p.val <= root.val && q.val >= root.val) return root;
        if(p.val >= root.val && q.val <= root.val) return root;
        if(p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        return lowestCommonAncestor(root.right, p, q);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        return BSTconstructor(nums,l, r, null);
    }


    public static TreeNode BSTconstructor(int[] arr, int low, int high, TreeNode root){
        if(low > high) return null;
        int mid = (low + high) / 2;
        root = new TreeNode(arr[mid]);
        root.left = BSTconstructor(arr , low , mid - 1, root.left);
        root.right = BSTconstructor(arr , mid + 1, high , root.right);
        return root;
    }

    public static int[] findMode(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        findMode(root, arr);

        List<Integer> ans = new ArrayList<>();
        int max = -1;

        for (int i = 0 ; i < arr.size() ; i++){
            int curr = arr.get(i);
            int count = 0;
            for(int j = i ; j < arr.size() ; j++){
                if(arr.get(j) == curr) count++;
                else{
                    i = j-1;
                    break;
                }
            }
            if(count > max) max = count;
        }

        for (int i = 0 ; i < arr.size() ; i++){
            int curr = arr.get(i);
            int count = 0;
            for(int j = i ; j < arr.size() ; j++){
                if(arr.get(j) == curr) count++;
                else{
                    i = j-1;
                    break;
                }
            }
            if(count == max) {
                ans.add(curr);
            }
        }

        return ans.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static int[] findMode2(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        findMode2(root,map);
        List<Integer> l = new ArrayList<>(map.values());
        Collections.sort(l);
        int max = l.get(l.size()-1);
        List<Integer> ans = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry :map.entrySet()){
            if(entry.getValue() == max) ans.add(entry.getKey());
        }

        return ans.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public int[] findMode3(TreeNode root) {
        count = 1;
        max = -1;
        List<Integer> al = new ArrayList<>();
        prev = null;
        findMode3(root, al);
        int n = al.size();
        int [] arr = new int[n];
        int i = 0;
        while(i < n){
            arr[i] = al.get(i);
            i++;
        }
        return arr;
    }

    public static void findMode(TreeNode root, List<Integer> a) {
        if(root == null) return;
        findMode(root.left, a);
        a.add(root.val);
        findMode(root.right, a);
    }
    public static void findMode2(TreeNode root, Map<Integer, Integer> map) {
        if(root == null) return;
        int val = root.val;
        if(map.containsKey(val)) map.put(val, map.get(val)+1);
        findMode2(root.left, map);
        findMode2(root.right, map);
    }


    static int count;
    static int max;
    static TreeNode prev;
    /**
     * fastest
     */
    private static void findMode3(TreeNode curr, List<Integer> list){
        if(curr == null)    return;
        findMode3(curr.left, list);
        if(prev != null && prev.val == curr.val){
            count++;
        } else {
            count = 1;
        }
        if(max == count){
            list.add(curr.val);
        }
        if(max < count){
            max = count;
            list.clear();
            list.add(curr.val);
        }
        prev = curr;
        findMode3(curr.right, list);
    }

    public static TreeNode insertIntoBST(TreeNode root, int[] nums, int l,int r){
        if(l>=r) return null;
        int mid = (l+r)/2;
        root = new TreeNode(nums[mid]);
        root.left = insertIntoBST(root.left,nums,l,mid);
        root.right = insertIntoBST(root.right,nums,mid+1,r);

        return root;
    }

    public TreeNode BSTconstructor(int[] arr, int low, int high){
        if(low > high) return null;

        int mid = (low + high) / 2;

        int val = arr[mid];

        TreeNode leftChild = BSTconstructor(arr , low , mid - 1);

        TreeNode rightChild = BSTconstructor(arr , mid + 1 , high);

        return new TreeNode(val , leftChild , rightChild);
    }

//    public static TreeNode sortedArrayToBST(int[] nums, int i, int j, TreeNode root){
//        if(j >= nums.length) return null;
//        if(i < 0) return null;
//
//        root = new TreeNode(nums[i]);
//        root.left = sortedArrayToBST(nums, i-1, j, root.left);
//        root.right = sortedArrayToBST(nums, i, j+1, root.right);
//        return root;
//    }


    int prev_val = 1000000;
    int min = 1000000;
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return min;
    }
    public void inOrder(TreeNode root) {
        if(root == null) return;
        inOrder(root.left);
        min = Math.min(min, Math.abs(root.val - prev_val));
        prev_val = root.val;
        inOrder(root.right);
    }

    static boolean found = false;
    static Set<Integer> s = new HashSet<>();
    public static void twoSum(TreeNode root, int k) {
        if(root == null) return;
        if(found) return;

        if(s.contains(root.val)){
            found = true;
            return;
        }
        else{
            int toFind = k - root.val;
            s.add(toFind);
        }

        twoSum(root.left, k);
        twoSum(root.right, k);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] ans = {-1,-1};
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
                return ans;
            }
            else{
                map.put(nums[i], i);
            }
        }
        return ans;
    }

    public TreeNode searchBST(TreeNode root, int val)
    {
        if(root==null)
            return null;
        if(root.val==val)
            return root;
        if(val< root.val)
            return searchBST(root.left,val);
        else
            return searchBST(root.right,val) ;

    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        inOrder(root, l);
        return balanceBST(l,  0, l.size()-1);
    }
    void inOrder(TreeNode root, List<Integer> l){
        if(root == null) return;
        inOrder(root.left, l);
        l.add(root.val);
        inOrder(root.right, l);
    }
    public TreeNode balanceBST(List<Integer> list, int l, int h) {
        if(l > h) return null;

        int mid = (l+h)/2 ;
        TreeNode r = new TreeNode(list.get(mid));
        r.left = balanceBST(list, l, mid-1);
        r.right = balanceBST(list, mid+1, h);
        return r;
    }












    static int findZeroes(int[] arr, int n, int m) {
        // code here
        int l = 0;
        int r = 0;

        int zero_count = 0;
        int one_count = 0;
        int max_count = -1;
        // int zero_pointer = -1;

        while(r < n){
            if(arr[r] == 1){
                one_count++;
                max_count = Math.max(max_count, one_count);
                r++;
            }
            else{
                if(zero_count < m){
                    zero_count++;
                    one_count++;
                    max_count = Math.max(max_count, one_count);
                    r++;
                }
                else{
                    while(l < n && arr[l] == 1){
                        l++;
                        one_count--;
                    }
                    l++;
                    max_count = Math.max(max_count, one_count);
                    r++;

                }
            }
        }
        return max_count;
    }


    public static int search(int A[], int N)
    {
        search(A, N, 0, N);
        return ans1;
    }
    static int ans1 = 0;
    public static void search(int a[], int n, int l , int r)
    {
        if(l >= r) return;

        int mid = (l+r)/2;

        if((mid+1 < n && a[mid] == a[mid+1]) || (mid > 0 && a[mid] == a[mid-1])){
            search(a, n, l, mid);
            search(a, n, mid+1, r);
        }
        else{
            ans1 = a[mid];
            return;
        }

    }

    static int maxXor(int lo, int hi, int k){
        int ans = Integer.MIN_VALUE;
        for(int i = lo ; i <= hi; i++){
            for(int j = i ; j <= hi ; j++){
                int temp = Math.max(ans, i^j);
                if(temp <= k) ans = temp;
            }
        }
        return ans;
    }



    long maxProduct(int[] arr, int n) {
        // code here
        int l = 0;
        int r = 0;

        int min_el = Integer.MAX_VALUE;
        int max_el = Integer.MIN_VALUE;
        boolean isZero = false;

        boolean isNeg = false;
        long curr = 1;
        long max = Long.MIN_VALUE;
        while(l<=r && r < n){
            min_el = Math.min(min_el, arr[r]);
            max_el = Math.max(max_el, arr[r]);
            if(arr[r] > 0){
                curr *= arr[r];
                max = Math.max(max, curr);
            }
            else if(arr[r] < 0){
                isNeg = !isNeg;
                curr *= arr[r];
                max = Math.max(max, curr);
            }
            else{
                isZero = true;
                if(isNeg){
                    while(l <= r && isNeg){
                        curr /= arr[l];
                        max = Math.max(max, curr);
                        l++;
                        if(curr > 0) isNeg = false;
                    }
                }
                curr = 1;
                l = r+1;
            }
            r++;
        }
        while(l<=r && isNeg){
            curr /= arr[l];
            max = Math.max(max, curr);
            l++;
            if(curr > 0) isNeg = false;
        }


        if(max < max_el) return max_el;
        if(arr.length == 1) return arr[0];
        if(max_el <= 0 && max == 1){
            if(isZero) return max_el;
        }
        return max;
    }

    long maxProduct_sol(int[] arr, int n) {
        // Variables to store maximum and minimum
        // product till ith index.
        long minVal = arr[0];
        long maxVal = arr[0];

        long maxProduct = arr[0];

        for (int i = 1; i < n; i++) {

            // When multiplied by -ve number,
            // maxVal becomes minVal
            // and minVal becomes maxVal.
            if (arr[i] < 0) {
                long temp = maxVal;
                maxVal = minVal;
                minVal = temp;
            }

            // maxVal and minVal stores the
            // product of subarray ending at arr[i].
            maxVal = Math.max(arr[i], maxVal * arr[i]);
            minVal = Math.min(arr[i], minVal * arr[i]);

            // Max Product of array.
            maxProduct = Math.max(maxProduct, maxVal);
        }

        // Return maximum product found in array.
        return maxProduct;
    }


    static List<Integer> nextPermutation(int n, int arr[]){
        // code here
        int p = -1;
        for(int i = n-1 ; i > 0 ; i--){
            if(arr[i] <= arr[i-1]);
            else{
                p = i-1;
                break;
            }
        }

        int q = -1;

        for(int i = n-1 ; p != -1 && i > 0 ; i--){
            if(arr[i] <= arr[p]);
            else{
                q = i;
                break;
            }
        }

        if(p != -1){
            int temp = arr[p];
            arr[p] = arr[q];
            arr[q] = temp;
        }

        for(int i = p+1, j = n-1; i<j; i++,j--){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        List<Integer> ans = new ArrayList<>();

        for(int e : arr){
            ans.add(e);
        }
        return ans;
    }


//    public static List<String> getMovieTitles(String title) {
//        String url = "https://jsonmock.hackerrank.com/api/movies/search/?Title=%s";
//        url = String.format(url, title);
//        System.out.println(url);
//
//        List<String> result = new ArrayList<String>();
//
//        String res_s = "";
//        URL obj;
//        try {
//            obj = new URL(url);
//            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//
//            // optional default is GET
//            con.setRequestMethod("GET");
//
//            int responseCode = con.getResponseCode();
//
//            System.out.println("\nSending 'GET' request to URL : " + url);
//            System.out.println("Response Code : " + responseCode);
//
//            BufferedReader in = new BufferedReader(
//                    new InputStreamReader(con.getInputStream()));
//            String inputLine;
//
//
//            while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine);
//            }
//            in.close();
//
//            res_s = response.toString();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        result = getTitlesArray(res_s);
//        Collections.sort(result);
//
//        return result;
//    }
//
//    public static List<String> getTitlesArray(String str) {
//
//        List<String> result = new ArrayList<>();
//
//        try {
//            // Parse JSON
//            Object obj1 = new JSONParser().parse(str);
//            JSONObject jo = (JSONObject) obj1;
//            JSONArray data = (JSONArray) jo.get("data");
//
//            Iterator<JSONObject> itr = data.iterator();
//
//            while(itr.hasNext()) {
//                Object item = new JSONParser().parse(itr.next().toString());
//                JSONObject itemObj = (JSONObject) item;
//                String theTitle = (String) itemObj.get("Title");
//
//                result.add(theTitle);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        Collections.sort(result);
//
//        return result;
//
//    }

}
