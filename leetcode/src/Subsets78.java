import java.util.ArrayList;
import java.util.List;

public class Subsets78 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    public void dfs(int[] nums, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(ans));
            return;
        }

        // 不选
        dfs(nums, index + 1);

        // 选
        ans.add(nums[index]);
        dfs(nums, index + 1);
        ans.remove(ans.size() - 1); // 恢复现场
    }
}
