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

    public static void main(String[] args) {
        StrStr28 strStr28 = new StrStr28();
        System.out.println(strStr28.strStr("leetcode", "leeto"));
    }
}
