package string;

/**
 * @ClassName KMP
 * @Description TODO
 * @Author 小何
 * @Date 2024/10/12 15:40
 **/
public class KMP {

    public static void getNext(int[] next, String pattern) {
        // 初始化
        char[] chars = pattern.toCharArray();
        next[0] = 0;

        int j = 0;
        for (int i = 1; i < chars.length; i++) {
            // 前缀不相同
            while (j > 0 && chars[j] != chars[i]) {
                j = next[j - 1];
            }
            // 前缀相同
            if (chars[j] == chars[i]) {
                j++;
            }
            next[i] = j;
        }

    }

}
