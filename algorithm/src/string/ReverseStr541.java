package string;

import java.util.WeakHashMap;

/**
 * @ClassName ReverseStr541
 * @Description TODO
 * @Author 小何
 * @Date 2024/10/9 14:16
 **/
public class ReverseStr541 {
    public String reverseStr(String s, int k) {
        char[] array = s.toCharArray();
        int i = 0;
        int j = k-1;
        int index = 1;
        while (i < j) {
            if (j > array.length - 1) {
                j = array.length - 1;
                while (i < j){
                    char temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    i++;
                    j--;
                }

                break;
            }else {
                while (i < j){
                    char temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    i++;
                    j--;
                }
                index = index + 2;
                j = index * k -1;
                i = j - k + 1;
            }
        }

        return new String(array);
    }

    public static void main(String[] args) {
        ReverseStr541 str = new ReverseStr541();
        System.out.println(str.reverseStr("abcdefghij", 2));
    }
}
