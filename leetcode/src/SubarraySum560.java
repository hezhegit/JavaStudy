import java.util.HashMap;
import java.util.Map;

public class SubarraySum560 {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int left = 0;
        int sum = 0;
        while (left < nums.length) {
            for (int i = left; i < nums.length; i++) {
                sum += nums[i];
                if (sum == k) {
                    result++;
                }
            }
            sum = 0;
            left++;
        }

        return result;
    }

    public int subarraySum2(int[] nums, int k) {
        int sum = 0;
        int ans = 0;
        Map<Integer, Integer> prefixSum = new HashMap<>();
        // 一定要初始化（0，1）=》当[0,i]和为k时生效
        prefixSum.put(0, 1);
        // 计算前缀和
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // 子数组[j,i]的和：sum[i] - sum[j-1] = k ，这里是判断i前面的数有没有子数组的和为k的
            if (prefixSum.containsKey(sum - k)) {
                ans += prefixSum.get(sum - k);
            }

            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);

        }

        return ans;

    }

    public static void main(String[] args) {
        SubarraySum560 subarraySum560 = new SubarraySum560();
        System.out.println(subarraySum560.subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySum560.subarraySum2(new int[]{1, 1, 1}, 2));
    }
}
