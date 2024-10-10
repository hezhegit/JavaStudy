package string;

import java.util.Scanner;

/**
 * @ClassName KCExchangeNum
 * @Description TODO
 * @Author 小何
 * @Date 2024/10/10 12:24
 **/
public class KCExchangeNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder stringBuilder = new StringBuilder(s);
        for (int i = 0; i < stringBuilder.length(); i++) {
            char c = stringBuilder.charAt(i);
            if (c <= '9' && c >= '0') {
                stringBuilder.deleteCharAt(i);
                stringBuilder.insert(i, "number");
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
