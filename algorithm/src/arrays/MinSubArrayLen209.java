package arrays;

/**
 * @ClassName MinSubArrayLen209
 * @Description TODO
 * @Author 小何
 * @Date 2024/9/24 15:46
 **/
public class MinSubArrayLen209 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, sum = 0;
        int result = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                result = Math.min(result, right - left+1);
                sum -= nums[left++];
            }
            right++;
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }

    //滑动窗口
    public int minSubArrayLen2(int target, int[] nums) {
        int left = 0, sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                result = Math.min(result, right - left+1);
                // 压缩窗口
                sum -=nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        MinSubArrayLen209 obj = new MinSubArrayLen209();
        System.out.println(obj.minSubArrayLen2(7, new int[]{2,3,1,2,4,3}));
    }
}
