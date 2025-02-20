import java.util.Stack;

public class DailyTemperatures739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                ans[stack.pop()] = i - stack.peek();
            }
            stack.push(i);
        }
        ans[stack.peek()] = 0;
        int temp = stack.pop();
        while (!stack.isEmpty()) {
            if (temperatures[temp] > temperatures[stack.peek()]) {
                ans[stack.peek()] = temperatures[temp];
            }else {
                ans[stack.peek()] = 0;
            }
            temp = stack.pop();
        }
        return ans;
    }
}
