public class MinDistance72 {
    // 定义
    // dp[i][j]:  word1[0:i] 转换成 word2[0:j] 所使用的最少操作数
    // 边界
    // d[0][0] = 0
    // d[i][0] = i d[0][j] = j
    // 状态转移
    // dp[i][j] =
    // if w1[i] == w2[j] => dp[i][j] = dp[i-1][j-1]
    // else 删插换 dp[i][j] = 1 + min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
            }
        }
        return dp[m][n];
    }
}
