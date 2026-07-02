package HashMaps;

import java.util.HashMap;

public class Basics {
    static void main() {
        HashMap<String, Integer> map = new HashMap<>();
        
        map.put("Shrihari", 150);
        map.put("Sarosh", 152);
        map.put("Amogh", 119);
        map.put("Sudhanva", 141);
        map.put("Abhishek", 153);
        System.out.println(map);
        System.out.println(map.containsKey("Shrihari"));
        System.out.println(map.containsValue(150));
        System.out.println(map.size());
        
        for(String key : map.keySet()){
            System.out.println(key + " " + map.get(key));
        }
    }
}
