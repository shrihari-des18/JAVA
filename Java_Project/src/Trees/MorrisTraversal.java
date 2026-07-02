package Trees;

import java.util.ArrayList;
import java.util.List;

public class MorrisTraversal {
    static List<Integer> traversal(Node cur){
        List<Integer> arr = new ArrayList<>();

        while(cur != null){
            if(cur.left != null){
                 Node pred = cur.left;
                 while(pred.right != null && pred.right != cur)
                     pred = pred.right;

                 if(pred.right == null){    //Linking
                     pred.right = cur;
                     cur = cur.left;
                 }
                 else{                      //Unlinking
                     arr.add(cur.val);
                     cur = cur.right;
                     pred.right = null;
                 }
            }
            else{
                arr.add(cur.val);
                cur = cur.right;
            }
        }
        return arr;

    }
    static void main() {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);

        Node cur = root;
        List<Integer> arr = traversal(cur);
        System.out.println(arr);
    }
}
