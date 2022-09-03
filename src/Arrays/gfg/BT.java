package Arrays.gfg;

import java.util.*;


public class BT {

    static class Node
    {
        int data;
        Node left, right;

        // Function to create a new binary tree node having a given key
        public Node(int key)
        {
            data = key;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        //inOP(inOrder(null, "4(2(3)(1))(6(5))"));

        int inorder[] = {1, 6, 8, 7};
        int preorder[] = {1, 6, 7, 8};

        buildTree(inorder, preorder, 4);
    }

    public static void inorderIterative(Node root)
    {
        // create an empty stack
        Stack<Node> stack = new Stack<>();

        // start from the root node (set current node to the root node)
        Node curr = root;

        // if the current node is null and the stack is also empty, we are done
        while (!stack.empty() || curr != null)
        {
            // if the current node exists, push it into the stack (defer it)
            // and move to its left child
            if (curr != null)
            {
                stack.push(curr);
                curr = curr.left;
            }
            else {
                // otherwise, if the current node is null, pop an element from
                // the stack, print it, and finally set the current node to its
                // right child
                curr = stack.pop();
                System.out.print(curr.data + " ");

                curr = curr.right;
            }
        }
    }


    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        leftView(root, map, 0);

        int l = 0;
        while(map.containsKey(l)){
            ans.add(map.get(l));
            l++;
        }
        return ans;
    }

    void leftView(Node root, Map<Integer, Integer> map, int l)
    {
        if(root == null) return;

        if(!map.containsKey(l)) map.put(l, root.data);

        leftView(root.left, map, l+1);
        leftView(root.right, map, l+1);
    }




    ArrayList<Integer> leftView_opt(Node root)
    {
        ArrayList<Integer> rs = new ArrayList<>();
        leftView2(root, rs, 0);
        return rs;
    }
    void leftView2(Node root, ArrayList<Integer> lvl,int level ){
        if(root==null){
            return ;
        }
        if(lvl.size()==level) lvl.add(root.data);

        leftView2(root.left,lvl,level+1);
        leftView2(root.right,lvl,level+1);
    }

    /**
     * Top View
     */
    static class pair{
        Node node;
        int hd;
        pair(Node node,int hd){
            this.node=node;
            this.hd=hd;
        }
    }

    //Function to return a list of nodes visible from the top view
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }

        Map<Integer,Integer> map=new TreeMap<>();
        Queue<pair> q=new LinkedList<pair>();
        q.add(new pair(root,0));
        while(!q.isEmpty()){

            pair it=q.remove();

            int hd=it.hd;
            Node temp=it.node;

            map.computeIfAbsent(hd, k -> temp.data);
            if(temp.left!=null){
                q.add(new pair(temp.left,hd-1));
            }
            if(temp.right!=null){
                q.add(new pair(temp.right,hd+1));
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }


    //Function to return a list of nodes visible from the bottom view
    //from left to right in Binary Tree.
    static ArrayList<Integer> bottomView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<Integer>();


        if(root==null){

            return ans;

        }

        Map<Integer,Integer> map=new TreeMap<>();
        Queue<pair> q=new LinkedList<pair>();
        q.add(new pair(root,0));
        while(!q.isEmpty()){

            pair it=q.remove();

            int hd=it.hd;
            Node temp=it.node;

            map.put(hd,temp.data);
            if(temp.left!=null){
                q.add(new pair(temp.left,hd-1));
            }
            if(temp.right!=null){
                q.add(new pair(temp.right,hd+1));
            }
        }
        for (Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator(); entries.hasNext(); ) {
            Map.Entry<Integer, Integer> entry = entries.next();
            ans.add(entry.getValue());
        }

        return ans;
    }

    //Function to store the zig zag order traversal of tree in a list.
    ArrayList<Integer> zigZagTraversal(Node root)
    {
        ArrayList<Integer> ans=new ArrayList<Integer>();
        // if null then return
        if (root == null) {
            return ans;
        }
        // declare two stacks
        Stack<Node> currentLevel = new Stack<>();
        Stack<Node> nextLevel = new Stack<>();
        // push the root
        currentLevel.push(root);
        boolean leftToRight = true;
        // check if stack is empty
        while (!currentLevel.isEmpty()) {
            // pop out of stack
            Node node = currentLevel.pop();
            // print the data in it
            ans.add(node.data);
            // store data according to current
            // order.
            if (leftToRight) {
                if (node.left != null) {
                    nextLevel.push(node.left);
                }
                if (node.right != null) {
                    nextLevel.push(node.right);
                }
            }
            else {
                if (node.right!= null) {
                    nextLevel.push(node.right);
                }
                if (node.left != null) {
                    nextLevel.push(node.left);
                }
            }
            if (currentLevel.isEmpty()) {
                leftToRight = !leftToRight;
                Stack<Node> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }
        return ans;
    }

    static boolean check=true;

    //Function to check whether a binary tree is balanced or not.
    static boolean isBalanced(Node root)
    {
        height(root);
        return check;
    }

    static int height(Node root){
        if(root==null){
            return 0;
        }
        if(!check) return -1;
        int lh=height(root.left);
        int rh=height(root.right);

        if(Math.abs(lh-rh) > 1){
            check=false;
        }
        return 1+Math.max(lh,rh);
    }

    public static ArrayList<Integer> diagonal(Node root)
    {
        //add your code here.
        ArrayList<Integer> ans = new ArrayList<>();

        Queue<Node> curr = new LinkedList<>();
        Queue<Node> next = new LinkedList<>();

        if(root == null) return ans;
        curr.add(root);
        while(!curr.isEmpty() || !next.isEmpty()){
            Node temp = curr.poll();
            ans.add(temp.data);

            if(temp.right != null){
                curr.add(temp.right);
            }
            if(temp.left != null){
                next.add(temp.left);
            }

            if(curr.isEmpty() && !next.isEmpty()){
                curr.add(next.poll());
            }
        }

        return ans;
    }


    // boundary traversal
    ArrayList <Integer> boundary(Node node)
    {
        ArrayList<Integer> ans = new ArrayList<>();

        if(node == null) return ans;

        Node temp = node;
        if(temp.left != null) {
            while (true) {
                //temp.left != null || temp.righht != null
                ans.add(temp.data);
                if (temp.left != null) temp = temp.left;
                else if (temp.right != null) temp = temp.right;
                else {
                    ans.remove(ans.size() - 1);
                    break;
                }
            }
        }
        else{
            if(temp.right != null) ans.add(temp.data);
        }

        temp = node;
        inOrder(temp, ans);
        temp = node;
        temp = temp.right;
        if(temp == null) return ans;
        Stack<Integer> right = new Stack<>();

        while(true){
            right.push(temp.data);
            if(temp.right != null) temp = temp.right;
            else if(temp.left != null) temp = temp.left;
            else {
                right.pop();
                break;
            }
        }


        while(!right.empty()){
            ans.add(right.pop());
        }
        return ans;
    }

    void inOrder(Node root, ArrayList<Integer> ans){
        if(root == null) return;

        if(root.left == null && root.right == null) ans.add(root.data);
        inOrder(root.left, ans);
        inOrder(root.right, ans);
    }

    static Node inOrder(Node root, String s){
        if(s.length() < 1) return root;
        if(root == null) {
            root = new Node(s.charAt(0) - '0');
        }
        Stack<Character> st = new Stack<>();
        int p = -1;
        for(int i = 1 ; i < s.length() ;i++){
            if(s.charAt(i) == '(') st.push('(');
            if(!st.empty() && s.charAt(i) == ')' && st.peek() == '(') st.pop();

            if(st.empty()){
                p = i;
                break;
            }
        }
        if(p != -1) {
            root.left = inOrder(root.left, s.substring(2, p));
            root.right = inOrder(root.right, s.substring(p + 2));
        }
        return root;
    }

    static void inOP(Node root){
        if(root == null) {

            System.out.print("N ");
            return;
        }
        System.out.print(root.data + " ");
        inOP(root.left);
        inOP(root.right);
    }



    //Function to convert binary tree to doubly linked list and return it.
    static Node ans = new Node(0);
    static Node temp = ans;
    static Stack<Integer> st = new Stack<>();
    static Node bToDLL(Node root) {
        inOrder(root);
        if(!st.empty()) st.pop();
        while(!st.empty()){
            temp.left = new Node(st.pop());
            temp = temp.left;
        }
        return ans.right;
    }

    static void inOrder(Node root){
        if(root == null) return;

        inOrder(root.left);
        temp.right = new Node(root.data);
        st.push(root.data);
        temp = temp.right;
        inOrder(root.right);
    }


    public static Node buildTree(int[] inorder, int[] preorder, int n)
    {
        // code here
        if(n <= 0) return null;

        Node root = new Node(preorder[0]);
        int ind = index(inorder, preorder[0]);

        int[] left = subArray(inorder, 0, ind-1);
        int[] leftPre = subArray(preorder, 1, ind);
        int[] right = subArray(inorder, ind+1, n-1);
        int[] rightPre = subArray(preorder, ind+1, n-1);

        if(left!= null && leftPre != null) root.left = buildTree(left, leftPre, left.length);
        if(right!= null && rightPre != null) root.right = buildTree(right, rightPre, right.length);

        return root;
    }

    static int index(int[] a, int n){
        for(int i = 0 ; i < a.length ; i++){
            if(a[i] == n) return i;
        }
        return -1;
    }

    static int[] subArray(int[] a, int i, int j) {
        if (i > j) return null;
        int[] ans = new int[j - 1 + 1];
        int k = 0;
        while (i <= j) {
            ans[k] = a[i];
            i++;
            k++;
        }
        return ans;
    }


    static boolean flag=true;
    static boolean check(Node root)
    {
        int sameLevel=-1;
        return helper(root,0,sameLevel);

    }
    static boolean helper(Node node,int level,int sameLevel){
        if(node==null) return true;

        if(!flag) return false;
        if(node.left==null && node.right==null){
            if(sameLevel==-1) sameLevel=level;
            else {
                if(sameLevel!=level){
                    flag=false;
                    return false;
                }
            }
        }
        return helper(node.left,level+1,sameLevel) && helper(node.right,level+1,sameLevel);
    }

    public void toSumTree(Node root){
        //add code here.
        toSumTree2(root);
    }

    public int toSumTree2(Node root){
        if(root == null) return 0;

        int l = toSumTree2(root.left);
        int r = toSumTree2(root.right);

        int curr = root.data;
        root.data = l + r;

        //if(root.left == null && root.right == null) return curr;
        return l+r+curr;
    }

    //func Flatten binary tree to linked list
    public static void flatten(Node root)
    {
        while(root != null){
            Node temp = root;
            Node left = root.left;
            Node right = root.right;

            if(left != null){
                root.right = left;
                root.left = null;
                while(temp.right != null){
                    temp = temp.right;
                }
                temp.right = right;
            }
            root = root.right;
        }

    }


    //Minimum swap required to convert binary tree to binary search tree
    public static int minSwaps(int n, int[] A) {
        // code here
        List<Integer> l = new ArrayList<>();
        minSwaps(n, A, l,0);
        //System.out.println(l);
        return minSwap(n, l);
    }

    public static void minSwaps(int n, int[] A, List<Integer> l, int i) {
        // code here
        if(i>=n) return;

        minSwaps(n, A, l, 2*i +1);

        l.add(A[i]);

        minSwaps(n, A, l, 2*i +2);
    }

    static int minSwap(int n, List<Integer> list){
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> arr = new ArrayList<>(list);
        Collections.sort(arr);
        for(int i=0;i<list.size();i++){
            map.put(list.get(i),i);
        }
        int count =0;
        for(int i=0;i<list.size();i++){
            int x = list.get(i);
            if(list.get(i)!=arr.get(i)){
                count++;
                Collections.swap(list, i, map.get(arr.get(i)));
                map.put(x, map.get(arr.get(i)));
                map.put(arr.get(i), i);
            }
        }
        return count;
    }

    boolean ans2 = true;
    boolean isSumTree(Node root)
    {
        // Your code here
        isSumTree2(root);

        return ans2;

    }

    int isSumTree2(Node root)
    {
        // Your code here
        if(!ans2)  return -1;
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.data;

        int l = isSumTree2(root.left);
        int r = isSumTree2(root.right);

        if(l+r != root.data) ans2 = false;

        return root.data + l + r;
    }


}
