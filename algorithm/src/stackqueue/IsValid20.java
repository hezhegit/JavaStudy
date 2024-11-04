package stackqueue;

import java.util.Stack;

/**
 * @ClassName IsValid20
 * @Description TODO
 * @Author 小何
 * @Date 2024/10/13 14:31
 **/
public class IsValid20 {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '{' || chars[i] == '[') {
                stack.push(chars[i]);
            }else {
                if (!stack.isEmpty()) {
                    if (stack.peek() == '(' && chars[i] == ')' || stack.peek() == '{' && chars[i] == '}' || stack.peek() == '[' && chars[i] == ']') {
                        stack.pop();
                    }else {
                        return false;
                    }
                }else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
