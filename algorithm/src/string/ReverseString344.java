package string;

/**
 * @ClassName ReverseString
 * @Description TODO
 * @Author 小何
 * @Date 2024/10/9 14:12
 **/
public class ReverseString344 {
    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        ReverseString344 reverseString = new ReverseString344();
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        reverseString.reverseString(s);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }
}
