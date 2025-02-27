public class ZeroOneKnapsack {

    // 0, 1背包 : 返回最大价值
    public double zeroOneKnapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        return dfs(weights, values, capacity, n);
    }

    public double dfs(int[] weights, int[] values, int capacity, int index) {
        if (index < 0) {
            return 0;
        }

        if (capacity < weights[index]) {
            return dfs(weights, values, capacity, index -1);
        }

        return Math.max(dfs(weights, values, capacity, index -1), dfs(weights, values, capacity - weights[index], index -1) + values[index]) ;
    }

    public int zeroOneKnapsack2(int[] weights, int[] values, int capacity) {
        int n = weights.length;

        // 创建 dp 数组，初始化为 0
        int[] dp = new int[capacity + 1];

        // 遍历所有物品
        for (int i = 0; i < n; i++) {
            // 从背包最大容量开始，倒序遍历，防止重复使用同一个物品
            for (int w = capacity; w >= weights[i]; w--) {
                // 更新 dp[w]：选择当前物品或不选择当前物品
                dp[w] = Math.max(dp[w], dp[w - weights[i]] + values[i]);
            }
        }

        // 返回背包容量为 capacity 时的最大价值
        return dp[capacity];
    }
}
