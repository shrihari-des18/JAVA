package Trees;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
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

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        int targetSum = 12;
        helper(a, targetSum, arr, ans);
        System.out.println(ans);
    }

    private static void helper(Node root, int target, List<Integer> arr, List<List<Integer>> ans) {
        if(root == null) return;
        if(root.left == null && root.right == null){
            if(root.val == target){
                arr.add(root.val);
                ans.add(arr);
            }
            return;
        }
        arr.add(root.val);
        List<Integer> arr1 = copy(arr);
        List<Integer> arr2 = copy(arr);
        helper(root.left, target-root.val, arr1, ans);
        helper(root.right, target-root.val, arr2, ans);
    }
    static List<Integer> copy(List<Integer> arr){
        List<Integer> list = new ArrayList<>();
        for(int ele : arr){
            list.add(ele);
        }
        return list;
    }
}
