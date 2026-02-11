package Trees;

public class MaxMin {
    public static void main(String[] args) {
        Node a = new Node(4);
        Node b = new Node(2);
        Node c = new Node(0);
        Node d = new Node(22);
        Node e = new Node(6);
        Node f = new Node(-1);

        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.right = f;

        Node g = new Node(10);
        Node h = new Node(20);
        c.left = g;
        e.left = h;
        a.print(a);
        System.out.println();
        System.out.println(max(a));
        System.out.println(min(a));
        System.out.println(size(a));
    }
    public static int max(Node root){
        if(root == null) return Integer.MIN_VALUE;
        return Math.max(root.val,
                Math.max(max(root.left),max(root.right)));
    }
    public static int min(Node root){
        if(root == null) return Integer.MAX_VALUE;
        return Math.min(root.val,
                Math.min(min(root.left),min(root.right)));
    }
    public static int size(Node root){
        if(root == null) return 0;
        return 1 + size(root.left) + size(root.right);
    }
}
