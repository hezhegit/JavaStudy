package string;

/**
 * @ClassName ReverseWords151
 * @Description TODO
 * @Author 小何
 * @Date 2024/10/10 12:33
 **/
public class ReverseWords151 {
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder reversed = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            if (!strings[i].trim().isEmpty()) {
                reversed.append(strings[i].trim()).append(" ");
            }

        }

        return reversed.toString().trim();
    }

    public static void main(String[] args) {
        ReverseWords151 rw = new ReverseWords151();
        System.out.println(rw.reverseWords(" Hello World "));
    }
}
