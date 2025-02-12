import java.util.ArrayList;
import java.util.List;

public class Subsets78_2 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    public void dfs(int[] nums, int start) {
        res.add(new ArrayList<>(ans));

        for (int i = start; i < nums.length; i++) {
            ans.add(nums[i]);
            dfs(nums, i+1);
            ans.remove(ans.size()-1);
        }
    }
}
