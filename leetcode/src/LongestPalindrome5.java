public class LongestPalindrome5 {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return "";

        // dp[i][j] 表示 s[i...j] 是否是回文子串
        boolean[][] dp = new boolean[n][n];
        String res = s.substring(0, 1);  // 初始化为一个字符的子串

        // 所有单字符子串都是回文
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // 从长度为2的子串开始，逐步计算更长的子串
        for (int len = 2; len <= n; len++) {  // 子串的长度从 2 到 n
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;  // 子串的结束位置

                if (s.charAt(i) == s.charAt(j)) {
                    // 如果子串的两端字符相等，且中间部分是回文，当前子串也是回文
                    if (len == 2) {
                        dp[i][j] = true;  // 两个字符相同时，是回文
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];  // 检查子串 s[i+1...j-1] 是否回文
                    }
                }

                // 如果当前子串是回文，并且比已知的最长回文子串更长，则更新结果
                if (dp[i][j] && len > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;
    }

    // 暴力
    public String longestPalindromeBL(String s) {
        int n = s.length();
        String res = s.substring(0, 1);  // 初始化为一个字符的子串
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                String str = s.substring(i, j + 1);
                if (isHuiWen(str) && str.length() > res.length()) {
                    res = str;
                }
            }
        }
        return res;
    }

    public boolean isHuiWen(String str) {
        int n = str.length();
        int left = 0, right = n - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
