public class Search33 {
    public int search(int[] nums, int target) {
        // 找到k
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                // k 在右边
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        int k = left;
        left = 0;
        right = nums.length -1;
        if (target > nums[right]) {
            right = k-1;
        }else {
            left = k;
        }

        // 二分查找
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] > target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
