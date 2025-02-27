public class MaxProduct152 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int dpMin = nums[0];
        int dpMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = dpMax;
                dpMax = dpMin;
                dpMin = temp;
            }
            dpMax = Math.max(nums[i], nums[i] * dpMax);
            dpMin = Math.min(nums[i], nums[i] * dpMin);
            max = Math.max(max, dpMax);
        }
        return max;
    }
}
