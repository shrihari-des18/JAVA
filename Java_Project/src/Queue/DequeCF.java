package Java_Project.src.Queue;


import java.util.*;

public class DequeCF {
    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            dq.addLast(i+1);
        }
        dq.addFirst(0);
        System.out.println(dq);
    }
}
