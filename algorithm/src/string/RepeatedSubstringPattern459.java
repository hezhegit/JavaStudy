package string;

/**
 * @ClassName RepeatedSubstringPattern459
 * @Description TODO
 * @Author 小何
 * @Date 2024/10/10 13:09
 **/
public class RepeatedSubstringPattern459 {
    //暴力解决
    public boolean repeatedSubstringPattern(String s) {
        // 字串默认包含第一个字符，即从头挑选字串
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length / 2; i++) {
            // 字串 == 主串 比较
            for (int j = 0, k = 0; j < array.length; j++) {
                if (k > i){
                    k = 0;
                }
                if (array[j] == array[k]) {
                    k++;
                }else {
                    break;
                }
                if (j == array.length -1 && k == i +1) {
                    return true;
                }
            }

        }

        return false;
    }

    // 移除匹配 s+s 去掉首尾元素仍然包含 s =》存在子串可以匹配
    public boolean repeatedSubstringPattern2(String s) {
        String ss = (s+s).substring(1, 2*s.length()-1);

        char[] ssCharArray = ss.toCharArray();
        char[] array = s.toCharArray();

        int i = 0;
        int j = 0;

        while (i < ssCharArray.length) {
            // 剪枝
            if (ssCharArray.length - i < array.length) {
                return false;
            }

            if (ssCharArray[i] == array[j]) {
                int k = i;
                while (j < array.length && k < ssCharArray.length) {
                    if (ssCharArray[k] == array[j]) {
                        k++;
                        j++;
                    }else {
                        break;
                    }
                }
                if (j == array.length) {
                    return true;
                }else {
                    j = 0;
                    i++;
                }

            }else {
                i++;
            }

        }


        return false;
    }

    public static void main(String[] args) {
        RepeatedSubstringPattern459 r = new RepeatedSubstringPattern459();
        System.out.println(r.repeatedSubstringPattern2("abab"));
    }
}
