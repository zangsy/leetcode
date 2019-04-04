/**
 * 38
 */
public class CountAndSay {
    public String countAndSay(int n) {
        StringBuilder curBuilder = new StringBuilder("1");
        StringBuilder preBuilder;
        int count;
        char anchorChar;
        int len;
        for (int i = 1; i < n; i += 1) {
            preBuilder = curBuilder;
            curBuilder = new StringBuilder();
            count = 1;
            anchorChar = preBuilder.charAt(0);
            len = preBuilder.length();
            for (int j = 1; j < len; j += 1) {
                if (preBuilder.charAt(j) == anchorChar) {
                    count += 1;
                } else {
                    curBuilder.append(count).append(anchorChar);
                    count = 1;
                    anchorChar = preBuilder.charAt(j);
                }
            }
            // Add the last few same chars to the builder.
            curBuilder.append(count).append(anchorChar);
        }
        return curBuilder.toString();
    }

    public static void main(String[] args) {
        CountAndSay cas = new CountAndSay();
        int n = 4;
        System.out.println(cas.countAndSay(4));
    }
}
