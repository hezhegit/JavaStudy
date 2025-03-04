public class MaximalSquare221 {
    // 定义
    // dp[i][j] 表示以 (i, j) 为右下角的、只包含 '1' 的正方形的最大边长。
    // 边界
    // dp[0][0] = m[0][0]
    // 第一行和第一列
    // 状态转移方程
    // dp[i][j] =
    // matrix[i][j] == '1' =》dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
    // matrix[i][j] == '0' =》dp[i][j] = 0
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxLength = 0;
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            maxLength = Math.max(maxLength, dp[i][0]);
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j] == '1' ? 1 : 0;
            maxLength = Math.max(maxLength, dp[0][j]);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                }else {
                    dp[i][j] = 0;
                }
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        return maxLength * maxLength;
    }
}
