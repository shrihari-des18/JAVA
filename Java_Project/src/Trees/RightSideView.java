package Trees;

import java.util.ArrayList;
import java.util.List;

public class RightSideView {
    static int levels(Node root){
        if(root == null) return 0;
        return 1 + Math.max(levels(root.left), levels(root.right));
    }
    static void dfs(Node root, int level, List<Integer> ans){
        if(root == null) return;
        ans.set(level, root.val);
        dfs(root.left, level+1, ans);
        dfs(root.right, level+1, ans);
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

        List<Integer> ans = new ArrayList<>();
        int n = levels(a);
        for (int i = 0; i < n; i++) {
            ans.add(0);
        }
        dfs(a,0,ans);
        System.out.println(ans);
    }
}
