import java.util.ArrayList;
import java.util.List;

public class Partition131 {
    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList< >();
    public List<List<String>> partition(String s) {
        dfs(0, s);
        return result;
    }

    public void dfs(int start, String s) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String t = s.substring(start, i + 1);
            if (check(start, i, s)) {
                path.add(t);
                dfs(i + 1, s);
                path.remove(path.size() - 1);
            }
        }
    }

    public boolean check(int left, int right, String s) {
        if (left < right) {
            while (left != right) {
                if (s.charAt(left++) != s.charAt(right--)) {
                    return false;
                }
            }
        }

        return true;
    }

}
