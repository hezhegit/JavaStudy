import java.util.ArrayList;
import java.util.List;

public class Permute46 {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        permute(nums, new ArrayList<>(), used);
        return res;
    }

    public void permute(int[] nums, List<Integer> list, boolean[] used) {
        if (nums.length == list.size()) {
            res.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                list.add(nums[i]);
                permute(nums, list, used);
                // 回朔
                used[i] = false;
                list.remove(list.size() - 1);

            }
        }


    }
}
