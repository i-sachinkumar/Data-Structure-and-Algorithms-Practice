package Tree;

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}


public class BinaryTree {
    Node root = null;

    public void add(int data){
        if(root == null) {
            root = new Node(data);
            return;
        }
        Node temp = root;
        while (true){
            if(temp.data > data && temp.left != null) temp = temp.left;
            else if(temp.data > data) {
                temp.left = new Node(data);
                return;
            }
            else if(temp.right != null) temp = temp.right;
            else {
                temp.right = new Node(data);
                return;
            }
        }
    }

    public int delete(int data, Node temp){
        Node prev = root;
        while (temp != null){
            if(temp.data > data && temp.left != null) {
                prev = temp;
                temp = temp.left;
            }
            else if(temp.data > data) {
                return Integer.MIN_VALUE;
            }
            else if(temp.data < data && temp.right != null){
                prev = temp;
                temp = temp.right;
            }
            else if(temp.data < data){
                return Integer.MIN_VALUE;
            }
            else {
                //if leaf node
                if(prev.left.data == data && prev.left.left==null && prev.left.right ==null){
                    prev.left = null;
                    return data;
                }
                if(prev.right.data == data && prev.right.left == null && prev.right.right == null){
                    prev.right = null;
                    return data;
                }

                // if parent node
                if(temp.left != null){
                    temp.data = deleteMax(root.left);
                    return temp.data;
                }
                if(temp.right != null){
                    temp.data = deleteMin(root.right);
                }
            }
        }

        return Integer.MIN_VALUE;
    }

    public int deleteMin(Node root){
        if(root.left.left == null){
            int temp = root.left.data;
            root.left = null;
            return temp;
        }
        return deleteMin(root.left);
    }
    public int deleteMax(Node root){
        if(root.right.right == null) {
            int temp = root.right.data;
            root.right = null;
            return temp;
        }
        return deleteMin(root.right);
    }


    public void printLNR(Node root){
        if(root == null) return;

        printLNR(root.left);
        System.out.print(root.data + " ");
        printLNR(root.right);
    }
}


class Main{
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.add(50);
        bt.add(55);
        bt.add(51);
        bt.add(25);
        bt.add(27);

        //bt.delete(55, bt.root);
        //bt.printLNR(bt.root);

        //System.out.println(bt.deleteMax(bt.root));
        bt.printLNR(bt.root);
    }
}