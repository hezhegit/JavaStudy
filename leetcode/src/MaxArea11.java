public class MaxArea11 {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                max = Math.max(max, height[left] * (right - left));
                left++;
            }else {
                max = Math.max(max, height[right] * (right - left));
                right--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        MaxArea11 maxArea11 = new MaxArea11();
        System.out.println(maxArea11.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
