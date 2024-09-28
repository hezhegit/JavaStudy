package arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <a href="https://kamacoder.com/problempage.php?pid=1070">区间和</a>
 * @ClassName KCCalculateRangeSum58
 * @Description TODO
 * @Author 小何
 * @Date 2024/9/26 13:58
 **/
public class KCCalculateRangeSum58 {
    // 时间超时
    public static int calculateRangeSum(int[] n, int a, int b){
        int sum = 0;
        for (int i = a; i <= b; i++) {
            sum += n[i];
        }
        return sum;
    }

    public static int[] calculateRangeSum(int[] n){
        int[] sum = new int[n.length];
        sum[0] = n[0];
        for (int i = 1; i < n.length; i++) {
           sum[i] = sum[i-1] + n[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt();
        int[] n = new int[l];
        for (int i = 0; i < l; i++) {
            n[i] = scanner.nextInt();
        }
        int[] sum = calculateRangeSum(n);
        int a;
        int b;
        while(scanner.hasNextInt())
        {
            a = scanner.nextInt();
            b = scanner.nextInt();
            System.out.println(sum[b] - sum[a] + n[a]);
        }
    }
}
