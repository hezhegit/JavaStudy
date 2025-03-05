public class RemoveDuplicates80 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 2 ) {
            return nums == null ? 0 : nums.length;
        }
        // 栈
        int stackSize = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[stackSize - 2]) {
                // 入栈
                nums[stackSize++] = nums[i];
            }
        }
        return stackSize;
    }

}
