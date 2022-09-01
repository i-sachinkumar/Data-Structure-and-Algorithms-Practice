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
}
