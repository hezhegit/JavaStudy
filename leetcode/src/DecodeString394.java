import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DecodeString394 {
    public String decodeString(String s) {
        // 用于存储重复次数的栈
        Stack<Integer> countStack = new Stack<>();
        // 用于存储部分字符串的栈
        Stack<StringBuilder> stringStack = new Stack<>();
        // 当前处理的字符串
        StringBuilder curr = new StringBuilder();
        // 当前的重复次数
        int k = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                // 累积数字，考虑多位数字的情况
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                // 遇到 '['，将当前重复次数和当前字符串保存到栈中
                countStack.push(k);
                stringStack.push(curr);
                // 重置 k 和当前字符串
                k = 0;
                curr = new StringBuilder();
            } else if (c == ']') {
                // 遇到 ']'，弹出栈顶的重复次数和字符串
                int repeatTimes = countStack.pop();
                StringBuilder decodedString = stringStack.pop();
                // 将当前字符串重复 repeatTimes 次，并拼接到弹出的字符串后
                for (int j = 0; j < repeatTimes; j++) {
                    decodedString.append(curr);
                }
                // 更新当前字符串为拼接后的结果
                curr = decodedString;
            } else {
                // 普通字符直接追加
                curr.append(c);
            }
        }

        return curr.toString();
    }
}