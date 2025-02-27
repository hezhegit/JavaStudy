public class MinDistance72 {

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        // dp[i][j] 表示 word1[0...i-1] 转换为 word2[0...j-1] 的最小操作次数
        int[][] dp = new int[m + 1][n + 1];

        // 初始化边界条件
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;  // word1[0...i-1] 转换为空字符串，需要删除 i 个字符
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;  // 空字符串转换为 word2[0...j-1]，需要插入 j 个字符
        }

        // 填充 dp 数组
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];  // 如果字符相同，不需要操作
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;  // 取最小的操作数
                }
            }
        }

        return dp[m][n];  // 返回从 word1[0...m-1] 转换为 word2[0...n-1] 的最小操作次数


    }
}
