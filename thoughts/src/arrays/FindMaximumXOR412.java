package arrays;

import java.util.HashSet;
import java.util.Set;

public class FindMaximumXOR412 {

    // 暴力 超时
    public int findMaximumXOR(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = nums[i] ^ nums[j];
                if (temp > max)
                    max = temp;
            }
        }

        return max;
    }

    public int findMaximumXOR2(int[] nums) {
        int ans = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {

            Set<Integer> pres = new HashSet<>();
            mask |= (1 << i);
            // 获取nums所有数的第i位前缀
            for (int num: nums) {
                pres.add(num & mask);
            }

            int temp = ans|(1 << i);
            for (int pre: pres) {
                if (pres.contains(temp ^ pre)){
                    ans = temp;
                    break;
                }
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3,10,5,25,2,8};
        FindMaximumXOR412 f = new FindMaximumXOR412();
        System.out.println(f.findMaximumXOR2(nums));
//        System.out.println(0 | 1 << 2);
    }
}
