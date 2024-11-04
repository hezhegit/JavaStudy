package stackqueue;

import java.util.*;

/**
 * @ClassName TopKFrequent347
 * @Description TODO
 * @Author 小何
 * @Date 2024/10/18 16:25
 **/
public class TopKFrequent347 {
    public int[] topKFrequent(int[] nums, int k) {

        // 排序
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        // 计算频率
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // 排序 大根堆
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair2[1] - pair1[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {//大顶堆需要对所有元素进行排序
            pq.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = pq.poll()[0];
        }

        return result;
    }
}
