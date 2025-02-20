import java.util.Stack;

public class IsValid20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }else {
                    Character pop = stack.pop();
                    if ( (c == ')' && pop != '(')
                    || (c == '}' && pop != '{')
                    || (c == ']' && pop != '[')) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
