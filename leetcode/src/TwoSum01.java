import java.util.HashMap;
import java.util.Map;

public class TwoSum01 {

    // 暴力
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j == i) {
                    continue;
                }

                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};

    }
    // 哈希表
    public int[] twoSum2(int[] nums, int target) {
        // <Value, Index>
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0;i < nums.length; i++) {
            int complete = target - nums[i];
            if (map.containsKey(complete)) {
                return new int[]{map.get(complete), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
