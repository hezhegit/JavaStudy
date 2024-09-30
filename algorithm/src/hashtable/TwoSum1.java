package hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TwoSum1
 * @Description TODO
 * @Author 小何
 * @Date 2024/9/30 21:18
 **/
public class TwoSum1 {
    // 暴力
    public int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        for (int i = 0; i < nums.length; i++) {
            index[0] = i;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[j] == target - nums[i]) {
                    index[1] = j;
                    return index;
                }
            }

        }
        return index;
    }

    // 哈希表
    public int[] twoSum2(int[] nums, int target) {
        int[] index = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            index[0] = i;
            if (map.containsKey(temp)) {
                index[1] = map.get(temp);
                break;
            }
            map.put(nums[i], i);
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {-1,-2,-3,-4,-5};
        int target = -8;
        TwoSum1 ts = new TwoSum1();
        System.out.println(Arrays.toString(ts.twoSum2(nums, target)));
    }
}
