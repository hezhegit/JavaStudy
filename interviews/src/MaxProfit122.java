public class MaxProfit122 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int start = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[start]) {
                maxProfit += prices[i-1] - prices[start];
                start = i;
            }

            if (i == prices.length - 1 && prices[i] > prices[start]) {
                maxProfit += prices[i] - prices[start];
            }
        }
        return maxProfit;

    }
}
