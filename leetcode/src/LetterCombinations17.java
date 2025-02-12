import java.util.ArrayList;
import java.util.List;

public class LetterCombinations17 {
    List<String> result = new ArrayList<>();
    String[] mapping = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        dfs(digits, new StringBuffer(), 0);
        return result;
    }
    public void dfs(String digits, StringBuffer res, int start) {
        if (digits.length() == res.length()) {
            result.add(res.toString());
            return;
        }

        String letters = mapping[digits.charAt(start)-'2'];
        for (int i = 0; i < letters.length(); i++) {
            char c = letters.charAt(i);
            res.append(c);
            dfs(digits, res, start + 1);
            res.deleteCharAt(res.length()-1);
        }
    }
}
