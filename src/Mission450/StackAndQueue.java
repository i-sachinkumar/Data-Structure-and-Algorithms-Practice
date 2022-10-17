package Mission450;

import java.util.*;

public class StackAndQueue {
    public static void main(String[] args) {

    }

    //Function to find if there is a celebrity in the party or not.
    int celebrity(int[][] m, int n) {
        // code here
        for(int i = 0 ; i < n ; i++){
            boolean flag = false;
            for(int j = 0; j < n ; j++){
                if(m[i][j] == 1){
                    flag = true;
                    break;
                }
            }
            if(!flag && isCeleb(m, n, i)) return i;
        }
        return -1;
    }
    boolean isCeleb(int[][] m, int n, int  i){
        for(int j = 0; j < n ; j++){
            if(i == j) continue;
            if(m[j][i] == 0) return false;
        }
        return true;
    }

    //Function to find if there is a celebrity in the party or not.
    int celebrityOpt(int m[][], int n)
    {
        // code here
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n ; i++){
            st.push(i);
        }
        while(st.size() >= 2){
            int t1 = st.pop();
            int t2 = st.pop();
            if(m[t1][t2] == 1) st.push(t2);
            else st.push(t1);
        }
        if(st.empty()) return -1;
        int last = st.pop();
        if(isCeleb2(m,n,last)) return last;
        return -1;
    }
    boolean isCeleb2(int[][] m, int n, int  i){
        for(int j = 0; j < n ; j++){
            if(i == j) continue;
            if(m[j][i] == 0 || m[i][j] == 1) return false;
        }
        return true;
    }

    public Stack<Integer> sort(Stack<Integer> s) {
        if(s.empty()) return s;
        int a = s.pop();
        sort(s);
        sort(s, a);
        return s;
    }
    static void sort(Stack<Integer> s, int x) {
        if(s.empty() || x >= s.peek()) {
            s.push(x);
            return;
        }
        int a = s.pop();
        sort(s, x);
        s.push(a);
    }


    // Valid Substring
    static int findMaxLen(String s) {
        // code here
        Stack<Integer> index = new Stack();
        index.push(-1);
        int ans = 0;
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') index.push(i);
            else{
                index.pop();
                if(index.empty()){
                    index.push(i);
                }
                else{
                    ans = Math.max(ans, i - index.peek());
                }
            }
        }
        return ans;
    }

    // Function to check redundant brackets in a
    // balanced expression
    static boolean checkRedundancy(String s) {
        // create a stack of characters
        Stack<Character> st = new Stack<>();
        char[] str = s.toCharArray();
        // Iterate through the given expression
        for (char ch : str) {

            // if current character is close parenthesis ')'
            if (ch == ')') {
                char top = st.peek();
                st.pop();

                // If immediate pop have open parenthesis '('
                // duplicate brackets found
                boolean flag = true;

                while (top != '(') {

                    // Check for operators in expression
                    if (top == '+' || top == '-'
                            || top == '*' || top == '/') {
                        flag = false;
                    }

                    // Fetch top element of stack
                    top = st.peek();
                    st.pop();
                }

                // If operators not found
                if (flag) {
                    return true;
                }
            } else {
                st.push(ch); // push open parenthesis '(',
            }                // operators and operands to stack
        }
        return false;
    }


    public static int isStackPermutation(int n, int[] ip, int[] op) {
        // code here
        Stack<Integer> st = new Stack<>();
        int i = 0;
        int j = 0;

        while (i < n){
            if(st.empty()){
                st.push(ip[i]);
                i++;
            }
            else{
                if(st.peek() == op[j]) {
                    st.pop();
                    j++;
                }
                else {
                    st.push(ip[i]);
                    i++;
                }
            }
        }
        while (!st.empty() && st.peek() == op[j]){
            st.pop();
            j++;
        }
        if(j >= n) return 1;
        return 0;
    }

    public Queue<Integer> rev(Queue<Integer> q){
        //add code here.
        if(q.isEmpty()) return q;
        int temp = q.poll();
        rev(q);
        q.offer(temp);
        return q;
    }

    // Function to interleave the queue
//    void interLeaveQueue(queue<int>& q)
//    {
//        // To check the even number of elements
//        if (q.size() % 2 != 0)
//            cout << "Input even number of integers." << endl;
//
//        // Initialize an empty queue of int type
//        queue<int> temp;
//        int halfSize = q.size() / 2;
//
//        // Push first half elements into the stack
//        // queue:16 17 18 19 20, queue: 11 12 13 14 15
//        for (int i = 0; i < halfSize; i++) {
//            temp.push(q.front());
//            q.pop();
//        }
//
//        // enqueue back the queue elements alternatively
//        // queue: 11 16 12 17 13 18 14 19 15 20
//        while (!temp.empty()) {
//            q.push(temp.front());
//            q.push(q.front());
//            q.pop();
//            temp.pop();
//        }
//    }

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        int ans = 0;
        int ch1 = 0;
        int ch2 = 0;
        int ch3 = 0;
        int i=0, j=0, k=0;
        while(i < h1.size() || j < h2.size() || k < h3.size()){
            if(ch1 == ch2 && ch1 == ch3){
                ans = ch1;
                if(i < h1.size()){
                    ch1 += h1.get(i);
                    i++;
                }
                if(j < h2.size()){
                    ch2 += h2.get(i);
                    j++;
                }
                if(k < h3.size()){
                    ch3 += h3.get(i);
                    k++;
                }
            }
            if(ch1 < ch2){
                if(i < h1.size()){
                    ch1 += h1.get(i);
                    i++;
                    continue;
                }
            }
            if(ch2 < ch3){
                if(j < h2.size()){
                    ch2 += h2.get(i);
                    j++;
                    continue;
                }
            }
            if(ch3 < ch1){
                if(k < h3.size()){
                    ch3 += h3.get(i);
                    k++;
                }
            }

        }
        return ans;
    }

    //Function to find maximum of each subarray of size k.
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k)
    {
        int l = 0;
        int r = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 -o1;
            }
        });
        while (r < k){
            q.add(arr[r]);
            r++;
        }
        while (r < n){
            ans.add(q.peek());
            q.remove(arr[l]);
            q.add(arr[r]);
            l++;
            r++;
        }
        return ans;
    }
}
