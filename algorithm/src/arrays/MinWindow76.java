package arrays;

import java.util.HashMap;

/** 未解决
 * @ClassName MinWindow
 * @Description TODO
 * @Author 小何
 * @Date 2024/9/24 21:24
 **/
public class MinWindow76 {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        String res = "";
        for (int left = 0, right = 0; right < s.length(); right++) {
            if (t.contains(Character.toString(s.charAt(right)))){
                map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            }

            while (map.size() >= t.length()) {
//                res = res.length()>right-left+1 ? s.substring(left, right+1):res;
                // 缩减窗口
                if (t.contains(Character.toString(s.charAt(left)))){
                    map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);
                }
                if (map.containsKey(s.charAt(left)) && map.get(s.charAt(left))== 0) {
                    map.remove(s.charAt(left));
                    if (res.isEmpty()) {
                        res = s.substring(left, right + 1);
                    }else {
                        res = res.length()>right-left+1 ? s.substring(left, right+1):res;
                    }
                }
                left++;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        MinWindow76 minWindow = new MinWindow76();
        System.out.println(minWindow.minWindow("ADOBECODEBANC", "ABC"));
    }
}
