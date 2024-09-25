package arrays;

import java.util.Arrays;

/**
 * @ClassName SortedSquares977
 * @Description TODO
 * @Author 小何
 * @Date 2024/9/24 14:55
 **/
public class SortedSquares977 {
    public int[] sortedSquares(int[] nums) {
        // 排序（绝对值）
        int i = 0;
        int[] new_nums = new int[nums.length];

        while(i < nums.length) {
            if(nums[i] > 0){
                break;
            }else {
                i++;
            }
        }

        int j = i - 1;
        int k = 0;
        while (k < nums.length && j >= 0 && i < nums.length) {
           if (nums[i] < Math.abs(nums[j])) {
               new_nums[k] = nums[i] * nums[i];
               i++;
           }else {
               new_nums[k] = nums[j] * nums[j];
               j--;
           }
           k++;
        }
        while (k < nums.length && j >= 0) {
            new_nums[k] = nums[j] * nums[j];
            j--;
            k++;
        }
        while (i < nums.length && k < nums.length) {
            new_nums[k] = nums[i] * nums[i];
            k++;
            i++;
        }

        return new_nums;
    }

    // 更简洁的办法：从最大开始排
    public int[] sortedSquares2(int[] nums) {
        int[] new_nums = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        int k = new_nums.length -1;
        while (k >= 0 && i <= j) {
            if (nums[i] * nums[i] < nums[j] * nums[j]) {
                new_nums[k] = nums[j] * nums[j];
                j--;
            }else {
                new_nums[k] = nums[i] * nums[i];
                i++;
            }
            k--;
        }

        return new_nums;
    }

    // 滑动窗口


    public static void main(String[] args) {
        SortedSquares977 s = new SortedSquares977();
        System.out.println(Arrays.toString(s.sortedSquares2(new int[]{-7,-3,2,3,11})));
    }
}
