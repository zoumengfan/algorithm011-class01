import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int hash = hash(s);
            if (!map.containsKey(hash)) {
                map.put(hash, new ArrayList<>());
            }
            map.get(hash).add(s);
        }

        List<List<String>> result = new ArrayList<>();
        result.addAll(map.values());
        return result;
    }

    private int hash(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            ++count[c - 'a'];
        }
        return Arrays.hashCode(count);
    }
}