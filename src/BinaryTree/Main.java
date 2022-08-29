package BinaryTree;

public class Main {
    public static void main(String[] args) {

        BinaryTree b = new BinaryTree() ;

        Node n = b.createTree();
        b.printLNR(n);
        b.printNLR(n);
    }

}