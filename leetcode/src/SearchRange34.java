public class SearchRange34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int left = 0, right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            }else if (nums[mid] < target) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        if (index == -1) {
            res[0] = -1;
            res[1] = -1;
        }else {
            res[1] = index;
            while (index >= 0 && nums[index] == target) {
                index--;
            }
            res[0] = ++index;
            index = res[1];
            while (index < nums.length && nums[index] == target) {
                index++;
            }
            res[1] = --index;

        }
        return res;
    }
}
