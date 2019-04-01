import java.util.Arrays;
import java.util.HashMap;
/**
 * 242
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i += 1) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (int j = 0; j < t.length(); j += 1) {
            char c = t.charAt(j);
            if (!map.containsKey(c)) {
                return false;
            } else {
                map.put(c, map.get(c) - 1);
            }
        }
        for (Character key : map.keySet()) {
            if (map.get(key) != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        return Arrays.equals(sArray, tArray);
    }

    public static void main(String[] args) {
        ValidAnagram va = new ValidAnagram();
        String s = "anagram";
        String t = "nagaram";
        System.out.println(va.isAnagram(s, t));
        System.out.println(va.isAnagram2(s, t));

        s = "rat";
        t = "car";
        System.out.println(va.isAnagram(s, t));
        System.out.println(va.isAnagram2(s, t));
    }
}
