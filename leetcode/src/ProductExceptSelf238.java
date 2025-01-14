public class ProductExceptSelf238 {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] pre = new int[nums.length];
        int[] post = new int[nums.length];
        // 前缀乘积
        pre[0] = nums[0];
        post[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1] * nums[i];
            post[nums.length - 1 - i] = post[nums.length - i] * nums[nums.length - 1 - i];
        }
        result[0] = post[1];
        for (int i = 1; i < nums.length -1 ; i++) {
            result[i] = pre[i-1] * post[i+1];
        }
        result[nums.length - 1] = pre[nums.length - 2];

        return result;

    }

    public static void main(String[] args) {
        ProductExceptSelf238 p = new ProductExceptSelf238();
        int[] nums = {1, 2, 3, 4};
        int[] result = p.productExceptSelf(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
