public class IsInterleave97 {
    // （1）定义：
    //  dp[i][j] ：s1 的前 i 个字符和 s2 的前 j 个字符能否交错组成 s3 的前 i+j 个字符。
    // （2）边界：
    // dp[0][0] = true 两个空串可以组成空串
    // 当 s2 为空时，只有 s1：dp[i][0] = dp[i-1][0] && (s1.charAt(i-1) == s3.charAt(i-1))
    // 当 s1 为空时，只有 s2：dp[0][j] = dp[0][j-1] && (s2.charAt(j-1) == s3.charAt(j-1))
    // 状态转移：
    // （3）对于一般情况，考虑 dp[i][j] 对应的 s3 字符的位置为 i+j-1，有两种情况：（s3的最后一个字符来自s1  且 d[i-1][j] true） 或者（s3的最后一个字符来自s2  且 d[i][j-1] true）
    // 如果 s1 的第 i 个字符与 s3 的第 i+j 个字符相同，并且 dp[i-1][j] 为 true，则 dp[i][j] 为 true。
    // 或者如果 s2 的第 j 个字符与 s3 的第 i+j 个字符相同，并且 dp[i][j-1] 为 true，则 dp[i][j] 为 true。
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) return false;
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int j = 1; j <= len2; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i+j-1))
                || dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i+j-1);
            }
        }
        return dp[len1][len2];
    }
}
