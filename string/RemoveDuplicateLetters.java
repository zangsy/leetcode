import java.util.Stack;
/**
 * 316
 * First, given "bcabc", the solution should be "abc".
 * If we think about this problem intuitively, you would
 * sort of go from the beginning of the string and start
 * removing one if there is still the same character left
 * and a smaller character is after it. Given "bcabc",
 * when you see a 'b', keep it and continue with the search,
 * then keep the following 'c', then we see an 'a'. Now we
 * get a chance to get a smaller lexi order, you can check
 * if after 'a', there is still 'b' and 'c' or not.
 * We indeed have them and "abc" will be our result.
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            count[c - 'a'] += 1;
        }
        boolean[] visited = new boolean[26];
        for (char c : chars) {
            count[c - 'a'] -= 1;
            if (visited[c - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0) {
                visited[stack.peek() - 'a'] = false;
                stack.pop();
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters rdl = new RemoveDuplicateLetters();
        String s = "bcabc";
        System.out.println(rdl.removeDuplicateLetters(s));

        s = "cbacdcbc";
        System.out.println(rdl.removeDuplicateLetters(s));
    }
}
