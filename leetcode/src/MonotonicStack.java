import java.util.Stack;

public class MonotonicStack {
    // 单调栈

    // 739 从右开始
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        // 从右开始
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                res[i] = stack.peek() - i;
            }
            stack.push(i);
        }

        return res;
    }

    // 739 从左开始
    public int[] dailyTemperatures2(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        // 从左开始
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        return res;
    }

    // 42 接雨水
    public int trap(int[] height) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int middle = height[stack.pop()];
                if (stack.isEmpty()) {
                    break;
                }
                int left = height[stack.peek()];
                ans += (Math.min(left, height[i]) - middle)* (i - stack.peek() -1 );

            }
            stack.push(i);
        }



        return ans;
    }
}
