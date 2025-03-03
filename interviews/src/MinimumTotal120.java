import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumTotal120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for (int i = 0; i < triangle.size(); i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
        }
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i-1][j-1], dp[i-1][j]);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.size(); i++) {
            if (dp[triangle.size()-1][i] < min) {
                min = dp[triangle.size()-1][i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(){{add(2);}});
        triangle.add(new ArrayList<>(){{add(3);add(4);}});
        triangle.add(new ArrayList<>(){{add(6);add(5);add(7);}});
        triangle.add(new ArrayList<>(){{add(4);add(1);add(8);add(3);}});
        MinimumTotal120 minimumTotal = new MinimumTotal120();
        System.out.println(minimumTotal.minimumTotal(triangle));
    }
}
