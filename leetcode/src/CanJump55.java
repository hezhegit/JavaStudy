public class CanJump55 {
    public boolean canJump(int[] nums) {
        int maxReach = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i > maxReach) return false;
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return maxReach >= nums.length - 1;
    }

    public int jump(int[] nums) {
        int n = nums.length;
        // 跳跃次数、当前能到达的边界和最远能到达的距离
        int jump = 0, currentEnd = 0, farthest = 0;

        // 遍历到倒数第二个位置即可，不用遍历到最后一个位置
        for (int i = 0; i < n - 1; i++) {
            // 更新在当前位置出发能达到的最远距离
            farthest = Math.max(farthest, i + nums[i]);

            // 如果到达了当前跳跃范围的末尾，则需要跳跃一次，并更新当前范围
            if (i == currentEnd) {
                jump++;
                currentEnd = farthest;
            }
        }
        return jump;
    }

}
