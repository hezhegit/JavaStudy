package arrays;

import java.util.Arrays;

/**
 * @ClassName RemoveElement27
 * @Description TODO
 * @Author 小何
 * @Date 2024/9/24 14:35
 **/
public class RemoveElement27 {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int i = 0, j = len - 1;
        while (i < len && j >= i) {
            if (nums[i] != val) {
                i++;
            }else {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j--;
            }
        }
        return i;
    }

    // 快慢指针解法：
    // 快指针：寻找新数组的元素 ，新数组就是不含有目标元素的数组。
    // 慢指针：指向更新 新数组下标的位置
    public int removeElement2(int[] nums, int val) {
        int low = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[low] = nums[fast];
                low++;
                fast++;
            }else {
                fast++;
            }
        }
        return low;
    }


    public static void main(String[] args) {
        RemoveElement27 obj = new RemoveElement27();
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        System.out.println(obj.removeElement2(nums, 2));
        System.out.println(Arrays.toString(nums));
    }
}
