import java.util.Stack;

public class LongestValidParentheses32 {
    public int longestValidParentheses(String s) {
        // 栈初始化，存储索引
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // 这个 -1 是为了处理从第一个字符开始的有效括号情况

        int maxLen = 0; // 用于记录最长有效括号的长度

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
}
