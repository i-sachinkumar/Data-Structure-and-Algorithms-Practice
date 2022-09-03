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
        inOP(inOrder(null, "4(2(3)(1))(6(5))"));
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
}
