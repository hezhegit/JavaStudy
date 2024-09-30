package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName FourSumCount454
 * @Description TODO
 * @Author 小何
 * @Date 2024/9/30 21:41
 **/
public class FourSumCount454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int sum = 0;
        // 化解成两数之和
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : nums1) {
            for (int b : nums2) {
                map.put(a + b, map.getOrDefault(a + b, 0) + 1);
            }
        }
        for (int c : nums3) {
            for (int d : nums4) {
                if (map.containsKey(0-(c+d))) {
                    sum += map.get(0-(c+d));
                }
            }
        }


        return sum;
    }
}
