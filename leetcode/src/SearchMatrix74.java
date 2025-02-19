public class SearchMatrix74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0, right = matrix[0].length * matrix.length -1;
        int m = matrix.length, n = matrix[0].length;
        while (left <= right) {
            int mid = (right + left) / 2;
            int mm = mid / n , mn = mid % n;
            if (matrix[mm][mn] == target) {
                return true;
            }else if (matrix[mm][mn] > target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return false;
    }
}
