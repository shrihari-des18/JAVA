package Trees;

class Node{
    int val;
    Node right;
    Node left;

    public Node(int val) {
        this.val = val;
    }
    void print(Node root){
        if(root == null) return;
        System.out.print(root.val + " ");
        print(root.left);
        print(root.right);
    }
}
public class Implementation {
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(4);
        Node c = new Node(3);
        Node d = new Node(2);
        Node e = new Node(6);
        Node f = new Node(5);

        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.right = f;

        Node g = new Node(10);
        Node h = new Node(20);
        c.left = g;
        e.left = h;
        a.left = null;

        a.print(a);

    }
}
