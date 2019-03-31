import java.util.HashMap;

public class WordPattern{
    public boolean wordPattern(String pattern, String str) {
        String[] splitStr = str.split("\\s+");
        HashMap<Character, Integer> pMap = new HashMap<>();
        HashMap<String, Integer> sMap = new HashMap<>();
        if (pattern.length() != splitStr.length) {
            return false;
        }
        for (Integer i = 0; i < splitStr.length; i += 1) {
            Character c = pattern.charAt(i);
            String word = splitStr[i];
            if (pMap.put(c, i) != sMap.put(word, i)) {
                // put return the last value associated with the key
                // if exists, or return null if not.
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        WordPattern wp = new WordPattern();
        String pattern = "abba";
        String str = "dog cat cat dog";
        System.out.println(wp.wordPattern(pattern, str));
    }
}