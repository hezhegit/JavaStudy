public class LongestPalindrome5 {

    // 定义
    // dp[i][j] 表示s[i:j]是回文串
    // 边界
    // 单个字符都是回文串 dp[i][i] = true
    // 状态转移方式
    // dp[i][j] = (s[i] == s[j]) && dp[i+1][j-1]
    // 循环 =》回文串的长度从2-》n

    public String longestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) return s;
        boolean[][] dp = new boolean[n][n];
        int maxLen = 1;
        int start = 0;

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int len = 2; len <= n ; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2) {
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && len > maxLen) {
                    maxLen = len;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);

    }

    public String longestPalindrome2(String s) {
        int n = s.length();
        if (n <= 1) return s; // 只有一个字符，直接返回

        boolean[][] dp = new boolean[n][n];
        int maxLen = 1;
        int start = 0;

        // 所有单字符都是回文
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // 处理长度 >= 2 的情况
        for (int len = 2; len <= n; len++) { // len = 子串长度
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1; // 子串的右边界

                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2) { // 长度为2，只需要判断相邻字符是否相等
                        dp[i][j] = true;
                    } else { // 长度大于2，需要检查内部是否是回文
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                // 更新最大回文子串的信息
                if (dp[i][j] && len > maxLen) {
                    maxLen = len;
                    start = i;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }
}
