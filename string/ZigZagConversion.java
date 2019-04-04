/**
 * 6
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows <= 1 || s.length() <= numRows) {
            return s;
        }

        // Make numRows of StringBuilder array and initialize.
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i += 1) {
            sb[i] = new StringBuilder();
        }

        int curRow = 0;
        boolean goDown = false;
        char[] sArray = s.toCharArray();
        for (char c: sArray) {
            sb[curRow].append(c);
            // Determine next step is go down or up.
            // Every time reaches the top or bottom,
            // flip the direction.
            if (curRow == 0 || curRow == numRows - 1) {
                goDown = !goDown;
            }
            curRow += goDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder elem : sb) {
            ret.append(elem);
        }

        return ret.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion zzc = new ZigZagConversion();
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(zzc.convert(s, numRows));
    }
}
