package hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Happy202
 * @Description TODO
 * @Author 小何
 * @Date 2024/9/30 21:06
 **/
public class Happy202 {
    public boolean isHappy(int n) {
        // 如果重复出现sum =》return false
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        while (sum != 1){
            sum = 0;
            while (n != 0){
                sum = sum + (n % 10) * (n % 10);
                n = n / 10;
            }
            if (set.contains(sum)){
                return false;
            }else {
                set.add(sum);
            }

            n = sum;

        }
        return true;
    }

    public static void main(String[] args) {
        Happy202 h = new Happy202();
        System.out.println(h.isHappy(19));
    }
}
