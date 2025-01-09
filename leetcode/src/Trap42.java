public class Trap42 {

    public int trap(int[] height) {
        // 定义两个指针
        int left = 0, right = height.length - 1;
        // 保存左右两端最大的值
        int leftMax = 0, rightMax = 0;
        int ans = 0;
        while (left < right) {
            // 更新左侧最大高度
            if (height[left] < height[right]) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                }else {
                    ans += leftMax - height[left];
                }
                left++;
            }else {
                // 更新右侧最大高度
                if (height[right] > rightMax) {
                    rightMax = height[right];
                }else {
                    ans += rightMax - height[right];
                }
                right--;
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        Trap42 t = new Trap42();
        System.out.println(t.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
