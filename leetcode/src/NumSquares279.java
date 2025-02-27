import java.util.Arrays;

public class NumSquares279 {
    public int numSquares(int n) {
        // dp[i] = dp[i-x]
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i * i <= n; i++) {
            for (int j = i * i; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[i - j] + 1);
            }
        }
        return dp[n];
    }

}
