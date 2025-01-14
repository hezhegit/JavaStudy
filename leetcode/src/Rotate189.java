import java.util.Arrays;

public class Rotate189 {
    public void rotate(int[] nums, int k) {
        if (k > nums.length) {
            k = k % nums.length;
        }
        int[] temp = new int[nums.length];
        for (int i = nums.length - k; i < nums.length ; i++) {
            temp[i - nums.length + k] = nums[i];
        }
        for (int i = k; i < nums.length; i++) {
            temp[i] = nums[i - k];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }
    public static void main(String[] args) {
        Rotate189 r = new Rotate189();
        int[] nums = new int[]{-1};
        r.rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
    }
}
