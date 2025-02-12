import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis22 {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(new StringBuffer(),  n, 0, 0);
        return result;
    }

    public void dfs(StringBuffer ans, int n, int left, int right) {
        if (left == n && right == n) {
            result.add(ans.toString());
            return;
        }

        if (left < n) {
            ans.append("(");
            dfs(ans, n, left + 1, right);
            ans.deleteCharAt(ans.length() - 1);
        }

        if (right < left) {
            ans.append(")");
            dfs(ans, n, left, right + 1);
            ans.deleteCharAt(ans.length() - 1);
        }


    }
}
