package Trees;

public class InvertTree {
    public static void invert(Node root){
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        invert(root.left);
        invert(root.right);
    }

    public static void main(String[] args) {
        Node a = new Node(4);
        Node b = new Node(3);
        Node c = new Node(0);
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
        a.print(a);
        System.out.println();

    }
}
