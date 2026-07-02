package LinkedList;
import java.util.*;
public class CollectionFramework {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.addFirst("hi");
        list.addFirst("hello");
        list.add(1,"Shrihari");
        System.out.println(list);
        System.out.println(list.size());

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
//        list.removeFirst();
//        list.removeLast();
//        System.out.println(list);

        list.remove(2);
        System.out.println(list);
    }
}
 