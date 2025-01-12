import java.util.*;

public class MaxSlidingWindow239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            if (i - deque.getFirst() >= k) {
                deque.removeFirst();
            }
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.getFirst()];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        MaxSlidingWindow239 solution = new MaxSlidingWindow239();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] ans = solution.maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(ans));
    }
}
