import java.util.List;

public class WordBreak139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        // dp[i] 表示字符串 s 的前 i 个字符是否可以由 wordDict 中的单词组成
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // dp[i]=dp[j] && (s[j:i]∈wordDict)
                // 能在前面找到一个位置 j，使得 dp[j] 为 true，且 s[j:i] 是字典中的一个单词，那么我们就可以将 dp[i] 设置为 true
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
