/**
 * 168
 * 本质上就是将一个10进制数转换为一个26进制的数.
 * 由于下标从1开始而不是从0开始，因此要减一操作.
 * 一个X进制的数abc，转换成10进制的话可以写成
 * a*X^2 + b*X^1 + c*X^0，反过来的话，用这个数
 * 对X取余，可以得到c，然后让这个数减去c再除以X，
 * 这个数就变成a*X^1 + b*X^0，这时候继续对X取余
 * 就可以得到b，一直重复直到这个数小于等于0.
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
