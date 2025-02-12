import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum39 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        dfs(candidates, new ArrayList<Integer>(),0, target);
        return result;
    }

    public void dfs(int[] candidates, List<Integer> ans, int start, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(ans));
            return;
        }

        if (target < candidates[start]) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            target -= candidates[i];
            ans.add(candidates[i]);
            dfs(candidates, ans, i+1, target);
            target += candidates[i];
            ans.remove(ans.size()-1);
        }
    }
}
