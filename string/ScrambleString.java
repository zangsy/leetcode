/**
 * 87
 */
public class ScrambleString {
    public boolean isScramble(String s1, String s2) {

        if (s1 == null || s2 == null) {
            return false;
        }

        int len = s1.length();
        boolean[][][] check = new boolean[len][len][len + 1];

        // k is the length of current string.
        for (int k = 1; k <= len; k += 1) {
            // i is the index of start char of s1.
            for (int i = 0; i <= len - k; i += 1) {
                // j is the index of start char of s2.
                for (int j = 0; j <= len - k; j += 1) {
                    // for a single char, it is only the scramble of itself.
                    if (k == 1) {
                        check[i][j][k] = s1.charAt(i) == s2.charAt(j);
                        continue;
                    }
                    check[i][j][k] = false;
                    for (int w = 1; w <= k - 1; w += 1) {
                        // cut s1 into two parts, there are two situations:
                        // 1. if the left of s1 and the left of s2 is scramble,
                        //    and the right of s1 and the right of s2 is scramble;
                        // 2. if the left of s1 and the right of s2 is scramble,
                        //    and the right of s1 and the left of s2 is scramble.
                        // s1 and s2 is scramble if either of the situations is true.
                        if ((check[i][j][w] && check[i + w][j + w][k - w])
                                || (check[i][j + k - w][w] && check[i + w][j][k - w])) {
                            check[i][j][k] = true;
                            break;
                        }
                    }
                }
            }
        }
        return check[0][0][len];
    }

    public static void main(String[] args) {
        ScrambleString ss = new ScrambleString();
        String s1 = "great";
        String s2 = "rgeat";
        System.out.println(ss.isScramble(s1, s2));

        s1 = "abcde";
        s2 = "caebd";
        System.out.println(ss.isScramble(s1, s2));
    }
}
