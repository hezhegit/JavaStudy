package arrays;

import java.util.HashMap;

/**
 * @ClassName TotalFruit
 * @Description TODO
 * @Author 小何
 * @Date 2024/9/24 19:32
 **/
public class TotalFruit904 {
    public int totalFruit(int[] fruits) {
        int left = 0;
        int maxFruits = 0;
        HashMap<Integer, Integer> basket = new HashMap<>();
        for (int right = 0; right < fruits.length; right++) {
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);
            // 如果篮子中的水果种类超过两个，收缩窗口
            while (basket.size() > 2) {
                basket.put(fruits[left], basket.get(fruits[left]) - 1);
                if (basket.get(fruits[left]) == 0) {
                    basket.remove(fruits[left]);
                }
                left++;
            }
            // 更新最大水果数量
            maxFruits = Math.max(maxFruits, right - left + 1);
        }



        return maxFruits;
    }

    public static void main(String[] args) {
        TotalFruit904 totalFruit904 = new TotalFruit904();
        System.out.println(totalFruit904.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
    }
}
