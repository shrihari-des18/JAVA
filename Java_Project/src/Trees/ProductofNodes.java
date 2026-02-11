package Trees;

public class ProductofNodes {
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
        System.out.println(productofNonzero(a));
    }
    private static int product(Node root) {
        if(root == null) return 1;
        return root.val * product(root.left) * product(root.right);
    }
    private static int productofNonzero(Node root) {
        if(root == null) return 1;
        return ((root.val == 0)? 1 : root.val) * productofNonzero(root.left) * productofNonzero(root.right);
    }
}
