public class FindMedianSortedArrays4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        if (total % 2 == 1) {
            // 奇数：取第 (total+1)/2 小的元素
            return getKthElement(nums1, nums2, (total + 1) / 2);
        } else {
            // 偶数：取第 total/2 小和第 total/2+1 小的元素的平均值
            return (getKthElement(nums1, nums2, total / 2) +
                    getKthElement(nums1, nums2, total / 2 + 1)) / 2.0;
        }
    }

    public int getKthElement(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int i = 0, j = 0;

        while (true) {
            // 如果 nums1 已经用完，直接返回 nums2 中的第 k 小
            if (i == m) {
                return nums2[j + k - 1];
            }
            // 如果 nums2 已经用完，直接返回 nums1 中的第 k 小
            if (j == n) {
                return nums1[i + k - 1];
            }
            // 当 k == 1 时，返回两个数组当前最小的那个元素
            if (k == 1) {
                return Math.min(nums1[i], nums2[j]);
            }

            // 取 k/2 个元素作为比较基准
            int half = k / 2;
            // newi 表示 nums1 中第 k/2 个元素的下标（如果不足 k/2 个则取最后一个）
            int newi = Math.min(i + half, m) - 1;
            // newj 表示 nums2 中第 k/2 个元素的下标（如果不足 k/2 个则取最后一个）
            int newj = Math.min(j + half, n) - 1;

            if (nums1[newi] <= nums2[newj]) {
                // 舍弃 nums1 中 [i, newi] 的所有元素
                int eliminated = newi - i + 1;
                k -= eliminated;
                i = newi + 1;
            } else {
                // 舍弃 nums2 中 [j, newj] 的所有元素
                int eliminated = newj - j + 1;
                k -= eliminated;
                j = newj + 1;
            }
        }
    }

}