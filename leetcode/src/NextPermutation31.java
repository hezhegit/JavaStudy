public class NextPermutation31 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // 步骤 1：找到第一个下降的元素
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = n - 1;
            // 步骤 3：找到第一个大于 nums[i] 的元素
            while (nums[j] <= nums[i]) {
                j--;
            }
            // 步骤 4：交换 nums[i] 和 nums[j]
            swap(nums, i, j);
        }

        // 步骤 5：反转 i 之后的部分
        reverse(nums, i + 1, n - 1);
    }

    // 交换数组中两个元素的位置
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 反转数组中从 start 到 end 的部分
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

}
