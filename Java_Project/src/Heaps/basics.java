package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class basics {
    static void kthSmal(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : nums){
            pq.add(i);
            if(pq.size() > k) pq.remove();
        }
        System.out.println(pq.peek());
    }
    static void main() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(4);
        pq.add(3);
        pq.add(5);
        pq.add(2);
//        System.out.println(pq);
//        System.out.println(pq.peek());
//        pq.remove();
//        System.out.println(pq);
        int[] arr = {10, 2, 3, 8, -4, -2, 6};
        kthSmal(arr, 2);
    }
}
