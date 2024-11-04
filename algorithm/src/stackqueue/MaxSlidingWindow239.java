package stackqueue;

import java.util.*;

/**
 * @ClassName MaxSlidingWindow239
 * @Description TODO
 * @Author 小何
 * @Date 2024/10/16 15:13
 **/
public class MaxSlidingWindow239 {
    public int[] maxSlidingWindow(int[] nums, int k) {

        List<Integer> res = new ArrayList<>();

        if (nums.length <= k){
            Arrays.sort(nums);
            res.add(nums[nums.length-1]);
        }else {
            Queue<Integer> q = new LinkedList<Integer>();
            for (int i = 0; i < k; i++) {
                q.offer(nums[i]);
            }
            res.add(Collections.max(q));
            for (int i = k; i < nums.length; i++) {
               q.poll();
               q.offer(nums[i]);
               res.add(Collections.max(q));
            }

        }


        return res.stream().mapToInt(i -> i).toArray();
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            // 移除不在窗口内的元素（队列头部元素的下标是否超出窗口范围）
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // 移除队列中比当前元素小的所有元素，因为它们永远不会成为最大值
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // 将当前元素的下标加入队列
            deque.offerLast(i);

            // 当窗口形成时，记录当前窗口的最大值（即队列头部元素对应的值）
            if (i >= k - 1) {
                result[j++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MaxSlidingWindow239 m = new MaxSlidingWindow239();
        int[] nums = {-7,-8,7,5,7,1,6,0};
        int k = 4;
        System.out.println(Arrays.toString(m.maxSlidingWindow2(nums, k)));
    }
}
