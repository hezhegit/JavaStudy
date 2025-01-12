import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinWindow76 {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // 记录 t 中字符的需求
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // 滑动窗口记录
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0; // 窗口的左右指针
        int valid = 0; // 记录当前窗口中满足条件的字符数
        int minLen = Integer.MAX_VALUE; // 最小窗口长度
        int start = 0; // 最小窗口的起始位置

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            // 更新窗口
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 收缩窗口
            while (valid == need.size()) {
                // 更新最小窗口
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char d = s.charAt(left);
                left++;

                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        MinWindow76 minWindow76 = new MinWindow76();
        System.out.println(minWindow76.minWindow("ADOBECODEBANC", "ABC"));
    }
}
