import java.util.ArrayList;
import java.util.List;

public class PartitionLabels763 {
    public List<Integer> partitionLabels(String s) {
        char[] chars = s.toCharArray();
        List<Integer> ans = new ArrayList<>();
        int[] last = new int[26];
        for (int i = 0; i < chars.length; i++) {
            last[chars[i] - 'a'] = i;  // // 每个字母最后出现的下标
        }

        int start = 0, end = 0;
        for (int i = 0; i < chars.length; i++) {
            end = Math.max(end, last[chars[i] - 'a']); // 更新当前区间右端点的最大值
            if (end == i) { // 当前区间合并完毕
                ans.add(end - start + 1); // 区间长度加入答案
                start = i + 1; // 下一个区间的左端点
            }
        }
        return ans;

    }
}
