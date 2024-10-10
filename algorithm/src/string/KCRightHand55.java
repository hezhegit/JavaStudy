package string;

import java.util.Scanner;

/**
 * @ClassName KCRightHand55
 * @Description TODO
 * @Author 小何
 * @Date 2024/10/10 12:47
 **/
public class KCRightHand55 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();

        sc.nextLine(); // 读取并丢弃行尾的换行符

        String s = sc.nextLine();

        int i = 0, j = k;
        for (; j < s.length(); i++, j++);

        System.out.println(s.substring(i, j) + s.substring(0, i));
    }
}
