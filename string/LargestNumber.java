import java.util.ArrayList;
import java.util.Comparator;
/**
 * 179
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        StringBuilder numBuilder = new StringBuilder();
        ArrayList<String> numArray = new ArrayList<>();
        Comparator<String> cmp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String o1First = o1 + o2;
                String o2First = o2 + o1;
                return o2First.compareTo(o1First); // Reverse order, larger first.
            }
        };

        for (int num : nums) {
            numArray.add(Integer.toString(num));
        }

        numArray.sort(cmp);

        // Handle the extreme case on LeetCode given nums full of 0's
        if (numArray.get(0).equals("0")) {
            return "0";
        } else {
            for (String num : numArray) {
                numBuilder.append(num);
            }
            return numBuilder.toString();
        }

    }

    public static void main(String[] args) {
        LargestNumber ln = new LargestNumber();
        int[] nums = new int[] {10, 2};
        System.out.println(ln.largestNumber(nums));

        nums = new int[] {3, 30, 34, 5, 9};
        System.out.println(ln.largestNumber(nums));
    }
}
