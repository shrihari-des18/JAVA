package Heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class NearlySorted {
    static void main() {
        int[] arr = {6,5,3,2,8,10,9};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> ans = new ArrayList<>();
        for(int i : arr){
            pq.add(i);
            if(pq.size() > 3) ans.add(pq.remove());
        }
        while(!pq.isEmpty()) ans.add(pq.remove());
        System.out.println(ans);
    }
}
