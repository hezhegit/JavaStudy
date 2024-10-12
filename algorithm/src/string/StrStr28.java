package string;

/**
 * @ClassName StrStr28
 * @Description TODO
 * @Author 小何
 * @Date 2024/10/10 12:59
 **/
public class StrStr28 {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }

        char[] array = haystack.toCharArray();
        char[] arrayNeedle = needle.toCharArray();
        int i = 0;
        int j = 0;
        while (i < array.length && j < arrayNeedle.length) {

            // 剪枝
            if (array.length - i < arrayNeedle.length) {
                return -1;
            }

            if (array[i] == arrayNeedle[j]) {
                int k = i;
                while (k < array.length && j < arrayNeedle.length && array[k] == arrayNeedle[j]) {
                    k++;
                    j++;
                }
                if (j == arrayNeedle.length) {
                    return i;
                }else {
                    i++;
                    j = 0;
                }
            }else {
                i++;
            }
        }

        return -1;

    }

    // KMP
    public static void getNext(int[] next, char[] chars) {
        // 初始化
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

    public int strStr2(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }

        char[] s = haystack.toCharArray();
        char[] pattern = needle.toCharArray();

        int[] next = new int[pattern.length];
        getNext(next, pattern);

        int i = 0, j = 0;
        while (i < s.length) {
            if (j < pattern.length && s[i] == pattern[j]) {
                i++;
                j++;
            } else {

                if (j > 0) {
                    j = next[j - 1];
                } else {
                    i++;
                }
            }

            // 如果找到了整个pattern
            if (j == pattern.length) {
                return i - j; // 返回起始索引
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        StrStr28 strStr28 = new StrStr28();
        System.out.println(strStr28.strStr("leetcode", "leeto"));
        System.out.println(strStr28.strStr2("leetcode", "leeto"));
    }
}
