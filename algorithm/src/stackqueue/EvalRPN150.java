package stackqueue;

import java.util.Stack;

/**
 * @ClassName EvalRPN150
 * @Description TODO
 * @Author 小何
 * @Date 2024/10/14 15:29
 **/
public class EvalRPN150 {
    // 无括号的后缀表达式求值
    public int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();
//        Stack<Integer> opStack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int right = numStack.pop();
                int left = numStack.pop();
                numStack.push(left + right);
            }else if (tokens[i].equals("-")) {
                int right = numStack.pop();
                int left = numStack.pop();
                numStack.push(left - right);
            }else if (tokens[i].equals("*")) {
                int right = numStack.pop();
                int left = numStack.pop();
                numStack.push(left * right);
            }else if (tokens[i].equals("/")) {
                int right = numStack.pop();
                int left = numStack.pop();
                numStack.push(left / right);
            }else {
                numStack.push(Integer.parseInt(tokens[i]));
            }
        }

        return numStack.pop();
    }

    public static void main(String[] args) {

    }
}
