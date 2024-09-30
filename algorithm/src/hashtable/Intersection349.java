package hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Intersection
 * @Description TODO
 * @Author 小何
 * @Date 2024/9/30 20:54
 **/
public class Intersection349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> inter = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }
        for (Integer i : set1) {
            if (set2.contains(i)) {
                inter.add(i);
            }
        }
        int[] num3 = new int[inter.size()];
        int i = 0;
        for (Integer num : inter) {
            num3[i++] = num;
        }

        return num3;
    }
}
