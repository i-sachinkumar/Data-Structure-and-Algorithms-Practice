package Arrays.gfg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


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
}
