import java.util.*;

public class ThreeSum15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int p = i+1, q = nums.length - 1;
            while (p < q) {
                int comp = nums[i] + nums[p] + nums[q];
                if (comp == 0) {
                    res.add(Arrays.asList(nums[i], nums[p], nums[q]));
                    p++;
                    q--;
                }else if (comp > 0) {
                    q--;
                }else {
                    p++;
                }
            }
        }

        return res.stream().toList();
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,1,1,2};
        List<List<Integer>> res = new ThreeSum15().threeSum(nums);
        System.out.println(res);
    }
}
