package Trees;

import java.util.*;

class Pair{
    Node x;
    int lvl;

    public Pair(Node x, int lvl) {
        this.x = x;
        this.lvl = lvl;
    }
}
public class Traversals {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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

        preorder(a);
        System.out.println();
        inorder(a);
        System.out.println();
        postorder(a);
        System.out.println();
        levelOrder(a);
        System.out.println();
        System.out.print("Enter n:");
        n = sc.nextInt();
        nthLevel(a,0);
        System.out.println();
        System.out.println("level wise print:");
        for (int x = 0; x < 3; x++) {
            n = x;
            nthLevel(a,0);
            System.out.println();
        }
        NthlevelOrder(a);
        System.out.print("PreIter: ");
        preIter(a);
        System.out.print("PostIter :");
        postIter(a);
    }
    public static void preorder(Node root){
        if(root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
    public static void postorder(Node root){
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }
    public static void levelOrder(Node root){
        Queue<Node> q = new LinkedList<>();
        if(root != null) q.add(root);
        while(!q.isEmpty()){
            Node front  = q.remove();
            System.out.print(front.val+" ");
            if(front.left != null) q.add(front.left);
            if(front.right != null) q.add(front.right);
        }
    }
    public static void nthLevel(Node root,int level){
        if(root == null) return;
        if(level == n)System.out.print(root.val + " ");
        nthLevel(root.left,level+1);
        nthLevel(root.right,level+1);
    }
    public static void NthlevelOrder(Node root){
        int pl = 0;
        Queue<Pair> q = new LinkedList<>();
        if(root != null) q.add(new Pair(root,0));
        while(!q.isEmpty()){
            Pair front  = q.remove();
            Node temp = front.x;
            int lvl = front.lvl;
            if(pl != lvl) {
                System.out.println();
                pl++;
            }
            System.out.print(temp.val+" ");
            if(temp.left != null) q.add(new Pair((temp.left),lvl+1));
            if(temp.right != null) q.add(new Pair((temp.right),lvl+1));
        }
        System.out.println();
    }
    public static void preIter(Node root){
        List<Integer> ans = new ArrayList<>();
        Stack<Node> temp = new Stack<>();
        if(root!= null) temp.push(root);
        while(temp.size() > 0){
            Node top = temp.pop();
            ans.add(top.val);
            if(top.right != null) temp.push(top.right);
            if(top.left != null) temp.push(top.left);
        }
        System.out.println(ans);
    }
    public static void postIter(Node root){
        List<Integer> ans = new ArrayList<>();
        Stack<Node> temp = new Stack<>();
        if(root!= null) temp.push(root);
        while(temp.size() > 0){
            Node top = temp.pop();
            ans.add(top.val);
            if(top.left != null) temp.push(top.left);
            if(top.right != null) temp.push(top.right);
        }
        System.out.println(ans.reversed());

    }
}
