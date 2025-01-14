public class MaxSubArray53 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
            if (dp[i] > max) {
                max = dp[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        MaxSubArray53 maxSubArray53 = new MaxSubArray53();
        System.out.println(maxSubArray53.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
