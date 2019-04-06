/**
 * 168
 * 本质上就是将一个10进制数转换为一个26进制的数.
 * 由于下标从1开始而不是从0开始，因此要减一操作.
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        int rem = 0;
        while (n > 0) {
            rem = Math.floorMod(n - 1, 26);
            sb.insert(0, (char) (rem + 'A'));
            n = (n - rem) / 26;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ExcelSheetColumnTitle esct = new ExcelSheetColumnTitle();
        System.out.println(Math.floorMod(700, 26));
        System.out.println(esct.convertToTitle(28));
        System.out.println(esct.convertToTitle(26));
        System.out.println(esct.convertToTitle(701));
    }
}
