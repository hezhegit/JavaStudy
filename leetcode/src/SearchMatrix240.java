public class SearchMatrix240 {
    public boolean searchMatrix(int[][] matrix, int target) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    for (int k = 1; k < matrix[0].length; k++) {
                        if (matrix[i][k] < matrix[i][k-1] ) {
                            return false;
                        }
                    }
                    for (int k = 1; k < matrix.length; k++) {
                        if (matrix[k][j] < matrix[k-1][j]) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        SearchMatrix240 searchMatrix240 = new SearchMatrix240();
        searchMatrix240.searchMatrix(new int[][]{{-1},{-1}}, -1);
    }
}
