package validAnagram;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (char character : s.toCharArray()) {
            map1.put(character, map1.getOrDefault(character, 0) + 1);
        }
        for (char character : t.toCharArray()) {
            map2.put(character, map2.getOrDefault(character, 0) + 1);
        }
        if (map1.size() != map2.size()) {
            return false;
        }
        Iterator<Map.Entry<Character, Integer>> iterator = map1.entrySet().iterator();
        while(iterator.hasNext()) {
            char key = iterator.next().getKey();
            int num = map1.get(key);
            if (!map2.containsKey(key) || map2.get(key) != num) {
                return  false;
            }
        }
        return true;
    }
}
