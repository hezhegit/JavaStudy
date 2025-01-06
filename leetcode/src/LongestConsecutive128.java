import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestConsecutive128 {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 将所有数字加入哈希集合
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;

        // 遍历集合
        for (int num : set) {
            // 仅从序列的起点开始扩展
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // 向后扩展序列
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                // 更新最大长度
                max = Math.max(max, currentStreak);
            }
        }

        return max;
    }


    public static void main(String[] args) {
        LongestConsecutive128 lc = new LongestConsecutive128();
        System.out.println(lc.longestConsecutive(new int[]{0,-1}));
    }
}
