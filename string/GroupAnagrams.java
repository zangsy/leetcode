import java.util.*;
/**
 * 49
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            StringBuilder strBuid = new StringBuilder();
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            for (char c : charArray) {
                strBuid.append(c);
            }
            String key = strBuid.toString();
            if (map.containsKey(key)) {
                List<String> val = map.get(key);
                val.add(str);
                map.put(key, val);
            } else {
                List<String> val = new ArrayList<>();
                val.add(str);
                map.put(key, val);
            }
        }
        res.addAll(map.values());

        return res;
    }
}
