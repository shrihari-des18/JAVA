package Trees;

import java.util.List;
import java.util.Scanner;

public class Inorder_Predecessor_Successor {
    static int pred;
    static int succ;
    static void inorder(Node root, List<Integer> list){
        if(root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    static void solution(Node root, int target){
        List<Integer> list = new java.util.ArrayList<>();
        inorder(root, list);
        for(int i=0; i<list.size(); i++) {
            if (list.get(i) == target) {
                if (i - 1 >= 0) pred = list.get(i - 1);
                else pred = -1;
                if (i + 1 < list.size()) succ = list.get(i + 1);
                else succ = -1;
                break;
            }
        }
        System.out.println("Predecessor: " + pred);
        System.out.println("Successor: " + succ);
    }

    static void solution2(Node root, int target){
        Node curr = root;
        while(curr != null){
            if(curr.val == target) break;
            else if(curr.val > target){
                succ = curr.val;
                curr = curr.left;
            }
            else{
                pred = curr.val;
                curr = curr.right;
            }
        }
        if(curr == null) {
            pred = -1;
            succ = -1;
        }
        else{
            if(curr.left != null){
                Node temp = curr.left;
                while(temp.right != null) temp = temp.right;
                pred = temp.val;
            }
            else pred = -1;
            if(curr.right != null){
                Node temp = curr.right;
                while(temp.left != null) temp = temp.left;
                succ = temp.val;
            }
            else succ = -1;
        }
        System.out.println("Predecessor: " + pred);
        System.out.println("Successor: " + succ);
    }
    static void main() {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        solution2(root,target);
    }
}
