package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class SubsetXORSum1863 {

    // 暴力
    public int subsetXORSum(int[] nums) {
        // 1. 求出子集
        List<List<Integer>> list = subsets(nums);
//        List<List<Integer>> list = new ArrayList<>();
//        generateSubsets(nums,0, new ArrayList<Integer>(), list);

        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            List<Integer> subset = list.get(i);
            int total = subset.isEmpty()? 0 : subset.get(0);
            for (int j = 1; j < subset.size(); j++) {
                total ^= subset.get(j);
            }
            sum += total;
        }


        return sum;

    }





    public void generateSubsets(int[] nums, int index, List<Integer> current,List<List<Integer>> subset) {
        if (index == nums.length) {
            subset.add(new ArrayList<>(current));
            return;
        }

        generateSubsets(nums, index + 1, current, subset);

        current.add(nums[index]);
        generateSubsets(nums,index + 1,current,subset);

        current.remove(current.size() - 1);
    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = (1 << nums.length)-1;
        for (int i = 0; i <= len; i++) {
            List<Integer> sub = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                // 检测第j位是否为1
                int temp = (1 << j);
                if ((temp & i) != 0){
                    sub.add(nums[j]);
                }
            }
            res.add(sub);
        }

        return res;
    }

    public static void main(String[] args) {
        SubsetXORSum1863 xorSum1863 = new SubsetXORSum1863();
        System.out.println(xorSum1863.subsetXORSum(new int[]{3,4,5,6,7,8}));
    }
}
