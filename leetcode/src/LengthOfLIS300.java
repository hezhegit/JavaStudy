import java.util.Arrays;

public class LengthOfLIS300 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // dp[i] = dp[i-x] + 1
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > dp[nums.length]) {
                dp[nums.length] = dp[i];
            }
        }
        return dp[nums.length];
    }
}
