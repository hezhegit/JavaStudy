import java.util.ArrayList;
import java.util.List;

public class SpiralOrder54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int m = matrix.length, n = matrix[0].length;
        int p = 0, q = 0;
        int i = p, j = q;
        int sum = matrix.length * matrix[0].length;
        while (res.size() < sum) {
            // 从左到右
            while (j < n && res.size() < sum){
                res.add(matrix[i][j]);
                j++;
            }
            j--;
            i++;
            // 从上到下
            while (i < m && res.size() < sum){
                res.add(matrix[i][j]);
                i++;
            }
            i--;
            j--;
            // 右到左
            while (j >= p && res.size() < sum){
                res.add(matrix[i][j]);
                j--;
            }
            j++;
            i--;
            // 下到上
            while (i > q && res.size() < sum){
                res.add(matrix[i][j]);
                i--;
            }

            p++;
            q++;
            m--;
            n--;
            i = p;
            j = q;
        }

        return res;

    }

    public static void main(String[] args) {
        SpiralOrder54 spiralOrder54 = new SpiralOrder54();
        System.out.println(spiralOrder54.spiralOrder(new int[][]{{1},{2},{3}}));

    }
}
