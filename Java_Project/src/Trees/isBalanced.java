package Trees;

public class isBalanced {
    static int levels(Node root){
        if(root == null) return 0;
        return 1 + Math.max(levels(root.left), levels(root.right));
    }

//    Time complexity is O(n^2) - Not Good
    static boolean ans(Node root){
        if(root == null) return true;
        int diff = Math.abs(levels(root.left) - levels(root.right));
        if(diff > 1) return false;
        boolean lst = ans(root.left);
        if(!lst) return false;
        boolean rst = ans(root.right);
        if(!rst) return false;
        return true;
    }

    static boolean ans;
    static int levelsOP(Node root){
        if(root == null) return 0;
        int lL = levelsOP(root.left); int rL = levelsOP(root.right);
        int diff = Math.abs(lL - rL);
        if(diff > 1) ans = false;
        return 1 + Math.max(lL,rL);
    }
    static void main() {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);

        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.left = f; c.right = g;

        System.out.println(ans(a));
    }
}
