package Trees;

public class SymmetricTree {
    public static void invert(Node root){
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        invert(root.left);
        invert(root.right);
    }
    public static boolean isSameTree(Node p, Node q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;

        if(p.val != q.val) return false;
        if(!(isSameTree(p.left, q.left))) return false;
        if(!(isSameTree(p.right, q.right))) return false;
        return true;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(2);
        Node f = new Node(3);
        Node g = new Node(4);
        a.left = b; a.right = e; // 2 - 1 - 2
        b.left = c; b.right = d; // 3 - 2 - 4
        e.left = g; e.right = f; // 4 - 2 - 3

        invert(a.right);

        System.out.println(isSameTree(a.left, a.right));
    }
}
