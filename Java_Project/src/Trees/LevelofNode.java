package Trees;

public class LevelofNode {
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
        System.out.println(level(a));
    }
    public static int level(Node root){
        if(root == null) return 0;
        return 1 + Math.max(level(root.right), level(root.left));
    }
    public static int diameter(Node root){
        if(root == null) return 0;
        int myD = level(root.right) + level(root.left);
        int leftD = diameter(root.left);
        int rightD = diameter  (root.right);
        return Math.max(myD, Math.max(leftD,rightD));
    }
}
