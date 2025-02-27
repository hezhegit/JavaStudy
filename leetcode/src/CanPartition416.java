import java.util.Arrays;

public class CanPartition416 {

    int[][] cache;

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum%2 != 0) return false;
        int target = sum/2;

        Arrays.sort(nums);
        cache = new int[nums.length+1][target+1];
        return dfs(nums, 0, target);
    }

    public boolean dfs(int[] nums, int start, int target) {
        if(target == 0) return true;
        if(start >= nums.length || nums[start] > target) return false;

        if (cache[start+1][target-nums[start]] == 0) {
            boolean dfs = dfs(nums, start + 1, target - nums[start]);
            if(dfs) cache[start+1][target-nums[start]] = 1;
            else cache[start+1][target-nums[start]] = 2;
        }

        if(cache[start+1][target-nums[start]] == 1) return true;

        return dfs(nums, start+1, target);
    }
}
