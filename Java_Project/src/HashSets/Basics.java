package HashSets;

import java.util.HashSet;

public class Basics {
    static void main() {
        HashSet<Integer> set = new HashSet<>();

        set.add(6);
        set.add(8);
        set.add(9);
        System.out.println(set);
        System.out.println(set.contains(6));
        System.out.println(set.size());
    }
}
