import java.util.Stack;

public class LargestRectangleArea84 {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        // 使用栈存储柱子的下标
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // 当前柱子小于栈顶柱子，说明可以计算以栈顶柱子为高度的矩形面积
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int topIndex = stack.pop();
                // 计算宽度：如果栈为空，则说明左侧没有更矮的柱子，宽度为 i
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, heights[topIndex] * width);
            }
            stack.push(i);
        }

        // 处理栈中剩余的柱子
        while (!stack.isEmpty()) {
            int topIndex = stack.pop();
            int width = stack.isEmpty() ? n : n - stack.peek() - 1;
            maxArea = Math.max(maxArea, heights[topIndex] * width);
        }

        return maxArea;
    }

}
