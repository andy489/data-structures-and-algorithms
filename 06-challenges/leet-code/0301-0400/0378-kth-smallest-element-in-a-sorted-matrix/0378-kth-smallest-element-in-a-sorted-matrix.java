// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

// Solution 1: Binary Search on Value — O(n log(max-min)) time, O(1) space
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int lo = matrix[0][0], hi = matrix[n - 1][n - 1];
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (countLessEqual(matrix, mid, n) < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private int countLessEqual(int[][] matrix, int mid, int n) {
        int count = 0;
        int row = 0, col = n - 1;
        while (row < n && col >= 0) {
            if (matrix[row][col] <= mid) {
                count += col + 1;
                row++;
            } else {
                col--;
            }
        }
        return count;
    }
}

// Solution 2: Min-Heap — O(k log n) time, O(n) space
class Solution2 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }
        int result = 0;
        for (int i = 0; i < k; i++) {
            int[] top = pq.poll();
            result = top[0];
            int row = top[1], col = top[2];
            if (col + 1 < n) {
                pq.offer(new int[]{matrix[row][col + 1], row, col + 1});
            }
        }
        return result;
    }
}
