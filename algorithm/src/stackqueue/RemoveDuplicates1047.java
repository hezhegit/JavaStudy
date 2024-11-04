package stackqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName RemoveDuplicates1047
 * @Description TODO
 * @Author 小何
 * @Date 2024/10/14 15:15
 **/
public class RemoveDuplicates1047 {
    public String removeDuplicates(String s) {
        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            if (stack.isEmpty() || array[i] != stack.peek() ) {
                stack.push(array[i]);
            }else {
                stack.pop();
            }
        }

        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();

        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicates1047 removeDuplicates1047 = new RemoveDuplicates1047();
        System.out.println(removeDuplicates1047.removeDuplicates("abbbaca"));
    }
}
