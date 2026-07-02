package Trees;

public class DiameterOfTree {
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

        int[] ans = {0};
        level(a, ans);
        System.out.println(ans[0]);
    }

    static int level(Node root, int[] ans) {
        if(root == null) return 0;
        int lL = level(root.left, ans); int rL = level(root.right, ans);
        int dia = lL + rL;
        ans[0] = Math.max(dia, ans[0]);
        return 1 + Math.max(lL,rL);
    }
}
