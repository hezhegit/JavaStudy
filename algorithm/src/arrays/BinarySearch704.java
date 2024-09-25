package arrays;

/**
 * @ClassName BinarySearch704
 * @Description TODO
 * @Author 小何
 * @Date 2024/9/24 14:24
 **/
public class BinarySearch704 {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] < target){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        BinarySearch704 b = new BinarySearch704();
        int[] nums = new int[]{-1,0,3,5,9,12};
        System.out.println(b.search(nums, 9));
        System.out.println(b.search(nums, 2));
    }
}
