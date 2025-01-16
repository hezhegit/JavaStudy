public class Rotate48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix.length;
        int k = n / 2;
        int c = 0;
        while (c < k) {
            for (int i = c; i < n-1; i++) {
                int temp = matrix[c][i];
                int temp2 = matrix[i][m-1-c];
                int temp3 = matrix[m-1-c][m-1-i];
                int temp4 = matrix[m-1-i][c];



                matrix[c][i] = temp4;
                matrix[i][m-1-c] = temp;
                matrix[m-1-c][m-1-i] = temp2;
                matrix[m-1-i][c] = temp3;
            }
            c++;
            n--;
        }
    }

    public static void main(String[] args) {
        Rotate48 rotate48 = new Rotate48();
        rotate48.rotate(new int[][]{
                {2,29,20,26,16,28},
                {12,27,9,25,13,21},
                {32,33,32,2,28,14},
                {13,14,32,27,22,26},
                {33,1,20,7,21,7},
                {4,24,1,6,32,34}
        });
        System.out.println();
    }

}
