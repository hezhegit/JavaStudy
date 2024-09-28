package arrays;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/spiral-matrix-ii/">螺旋矩阵</a>
 * @ClassName GenerateMatrix59
 * @Description TODO
 * @Author 小何
 * @Date 2024/9/26 13:22
 **/
public class GenerateMatrix59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int m = 1;
        int d = 1;
        int i = 0, j = n-1, p = n-1, q = 0;
        while (m <= n * n) {
            if (d == 1) {
                for (int k = q; k <= p; k++) {
                    matrix[i][k] = m;
                    m++;
                }
                i++;
                d++;
            }else if (d == 2) {
                for (int k = i; k <= j; k++) {
                    matrix[k][p] = m;
                    m++;
                }
                p--;
                d++;
            }else if (d == 3) {
                for (int k = p; k >= q; k--) {
                    matrix[j][k] = m;
                    m++;
                }
                j--;
                d++;
            }else if (d == 4) {
                for (int k = j; k >= i; k--) {
                    matrix[k][q] = m;
                    m++;
                }
                q++;
                d = 1;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        GenerateMatrix59 gm = new GenerateMatrix59();
        int[][] matrix = gm.generateMatrix(3);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

    }
}
