public class SingleNumber136 {
    // 一个数和 0 做 XOR 运算等于本身
    // 一个数和其本身做 XOR 运算等于 0
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
