public class Trap42 {
    // 接雨水
    public int trap(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        int preMax = 0; // 左侧（前缀）的最大高度
        int sufMax = 0; // 右侧（后缀）的最大高度

        // 当左指针与右指针未交叉时继续循环
        while (left < right) {
            // 更新左侧和右侧的最大高度
            preMax = Math.max(preMax, height[left]);
            sufMax = Math.max(sufMax, height[right]);

            // 关键：根据哪边较小决定移动哪边指针
            if (preMax < sufMax) {
                // 左侧较小，当前位置可接水为 preMax - height[left]
                ans += preMax - height[left];
                left++;  // 移动左指针
            } else {
                // 右侧较小，当前位置可接水为 sufMax - height[right]
                ans += sufMax - height[right];
                right--; // 移动右指针
            }
        }
        return ans;
    }

}
