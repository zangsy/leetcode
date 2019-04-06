/**
 * 171
 * Similar to 168
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i += 1) {
            res += ((int) s.charAt(i) - (int) 'A' + 1) * Math.pow(26, s.length() - 1 - i);
        }
        return res;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber escn = new ExcelSheetColumnNumber();
        System.out.println(escn.titleToNumber("AB"));
    }
}
